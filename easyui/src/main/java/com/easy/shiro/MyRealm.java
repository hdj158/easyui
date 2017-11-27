package com.easy.shiro;





import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import com.easy.service.UserService;
import com.easy.vo.Role;
import com.easy.vo.User;


@Service
public class MyRealm extends AuthorizingRealm{

   @Resource
    private UserService userServiceImpl;
   
    
   
//权限认证
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
 
		 String username=(String)principals.fromRealm(getName()).iterator().next();  
	        System.out.println(getName()+"====================================================================");
		 if( username != null ){  
	            User user = userServiceImpl.findByName(username); 
	            System.out.println("权限"+user);
	            if( user != null && user.getRoleList() != null ){  
	                SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();  
	                for(Role each: user.getRoleList() ){  
	                        info.addRole(each.getRolename());  
	                        info.addStringPermissions(each.getPermissionsName());  
	                }  
	                return info;  
	            }  
	        }  
		return null;
	}
//登录认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authcToken;  
        String userName = token.getUsername(); 
        char[] userPwd = token.getPassword(); 
        System.out.println(userName+"------------------");
       
        if( userName != null && !"".equals(userName) ){  
        	System.out.println(String.valueOf(userPwd)+"-----666666---------");
            User user = userServiceImpl.login(userName, String.valueOf(userPwd));  
            Subject currentUser = SecurityUtils.getSubject();
            Session s=currentUser.getSession();
	        s.setAttribute("user", user);
            if( user != null ) { 
            	System.out.println("登录+++++++++++++"+user);
                return new SimpleAuthenticationInfo(user.getUserName(),user.getPassWord(), getName());  
            }else {
            	
            	 return null;
            }
          }else {
        	
        	  return null;
          }  
	}

}
