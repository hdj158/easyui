package com.easy.controller;



import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.ExcessiveAttemptsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;

import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.easy.mail.MyMail;
import com.easy.vo.User;





@Controller
@RequestMapping(value="/user")
public class HomeController{
	@Resource
	private MyMail myMail;
	
	@RequestMapping(value="/login")
	public ModelAndView login(User user,BindingResult bindingResult,RedirectAttributes redirectAttributes,ModelMap modelMap)
	{
		int code=(int) (Math.random()*1000+1);
		myMail.send(user,String.valueOf(code));
		 ModelAndView mav = new ModelAndView();
	    System.out.println(user);
       //获取凭据
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUserName(),user.getPassWord());
        token.setRememberMe(true);
       
        Subject currentUser = SecurityUtils.getSubject();
	    try {
	    	//提交凭据，
	        currentUser.login(token);
	        mav.setViewName("redirect:/main");
	        mav.addObject("message", 0);
	        return mav;
	    } catch (UnknownAccountException ex) {//用户名没有找到  
	        System.out.println("用户名没有找到");
	        mav.setViewName("redirect:/message");
	        mav.addObject("message", 1);
	        return mav;
	    } catch (IncorrectCredentialsException ex) {//用户名密码不匹配  
	        System.out.println("用户名密码不匹配");  
	        mav.setViewName("redirect:/message");
	        mav.addObject("message", 1);
	        return mav;
	    }catch (LockedAccountException lae ) {  
	    	 System.out.println(lae);  
	    	 mav.setViewName("redirect:/message");
		        mav.addObject("message", 1);
		        return mav;
	    }catch (ExcessiveAttemptsException eae ) {  
	    	System.out.println(eae);  
	    	 mav.setViewName("redirect:/message");
	        mav.addObject("message", 1);
	        return mav;
	    }catch (AuthenticationException ae ) {  
	    	System.out.println(ae);  
	    	 mav.setViewName("redirect:/message");
	        mav.addObject("message", 1);
	        return mav;
	    }  
	   

    	
	}
	
	@RequestMapping(value="/loginout")
	public String loginOut() {
		 
		Subject currentUser = SecurityUtils.getSubject();		 
			currentUser.logout();
		 return "jsp/user";
	}
	@RequestMapping(value="/add")
	public String useradd() {
		 
		
		 return "jsp/add";
	}
	@RequestMapping(value="/delete")
	public String userdel() {
		 
		
		 return "jsp/delete";
	}
	@RequestMapping(value="/update")
	public String userupdate() {
		 
		
		 return "jsp/update";
	}
	@RequestMapping(value="/query")
	public String userquery() {
		 
		
		 return "jsp/query";
	}
}
