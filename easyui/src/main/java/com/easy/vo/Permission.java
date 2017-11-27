package com.easy.vo;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

/**
 * 权限类，保存权限信息与对应的角色（多对一）
 * <p/>
 * Created by Jeremie on 2014/10/1.
 */

@Entity
@Table(name = "t_permission")
public class Permission implements Serializable {
	@Id
	@GenericGenerator(name="hibernate.identity",strategy="identity")
	@GeneratedValue(generator="hibernate.identity")
    private Integer id;
	@Column(name="permissionname",length=45)
    private String permissionname;
	@ManyToOne(targetEntity = Role.class)
	@JoinTable(name = "t_role_permission", joinColumns = {@JoinColumn(name = "permission_id")}, inverseJoinColumns = {@JoinColumn(name = "role_id")})
    private Role role;

   
    public Permission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPermissionname() {
        return permissionname;
    }

    public void setPermissionname(String permissionname) {
        this.permissionname = permissionname;
    }

   
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

	@Override
	public String toString() {
		return "Permission [id=" + id + ", permissionname=" + permissionname + "]";
	}

	

}
