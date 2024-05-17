package com.example.hs.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "user_roles")
//@IdClass(UserRolesBridgeID.class)
public class UserRolesEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
//	@Id
//	@Column(name = "id")
//    private Integer id;
//	
//	@Id
//	@Column(name = "user_id")
//    private Integer userId;
//	
//	@Id
//	@Column(name = "role_id")
//    private Integer rolesId;
//
//
//	 @ManyToOne
//     @JoinColumn(name="user_id")
//     private UserEntity userEntity;
//
//     @ManyToOne  
//     @JoinColumn(name="role_id")  
//     private RolesEntity rolesEntity;
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public Integer getUserId() {
//		return userId;
//	}
//
//	public void setUserId(Integer userId) {
//		this.userId = userId;
//	}
//
//	
//
//	public Integer getRolesId() {
//		return rolesId;
//	}
//
//	public void setRolesId(Integer rolesId) {
//		this.rolesId = rolesId;
//	}
//
//	public UserEntity getUserEntity() {
//		return userEntity;
//	}
//
//	public void setUserEntity(UserEntity userEntity) {
//		this.userEntity = userEntity;
//	}
//
//	public RolesEntity getRolesEntity() {
//		return rolesEntity;
//	}
//
//	public void setRolesEntity(RolesEntity rolesEntity) {
//		this.rolesEntity = rolesEntity;
//	}

	
}
