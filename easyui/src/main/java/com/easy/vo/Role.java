package com.easy.vo;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import org.hibernate.annotations.GenericGenerator;
/**
 * 角色类，用于保存角色信息、用户列表（多对多）与角色（一对多）对应的权限
 * <p/>
 * Created by Jeremie on 2014/10/1.
 */
@Entity
@Table(name = "t_role")
public class Role {

	@Id
	@GenericGenerator(name="hibernate.identity",strategy="identity")
	@GeneratedValue(generator="hibernate.identity")
	private Integer id;
	@Column(name="rolename",length=45)
    private String rolename;
	@OneToMany(targetEntity = Permission.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "t_role_permission", joinColumns = {@JoinColumn(name = "role_id")}, inverseJoinColumns = {@JoinColumn(name = "permission_id")})
    private Set<Permission> permissionList;
	@ManyToMany(targetEntity = User.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "t_user_role", joinColumns = {@JoinColumn(name = "role_id")}, inverseJoinColumns = {@JoinColumn(name = "user_id")})
    private Set<User> userList;
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public Set<Permission> getPermissionList() {
		return permissionList;
	}
	public void setPermissionList(Set<Permission> permissionList) {
		this.permissionList = permissionList;
	}
	public Set<User> getUserList() {
		return userList;
	}
	public void setUserList(Set<User> userList) {
		this.userList = userList;
	}
   public Set<String> getPermissionsName() {
	        Set<String> list = new HashSet<>();
	        Set<Permission> perlist = this.getPermissionList();
	        for (Permission per : perlist) {
	            list.add(per.getPermissionname());
	        }
	        return list;
	}
@Override
public String toString() {
	return "Role [id=" + id + ", rolename=" + rolename + ", permissionList=" + permissionList ;
}
	

	
	
   
}
