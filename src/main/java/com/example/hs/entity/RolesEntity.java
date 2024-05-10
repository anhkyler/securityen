package com.example.hs.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "roles")
public class RolesEntity implements Serializable{
    private static final long serialVersionUID = 1L;


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
    private Integer id;

	@Column(name = "name")
    private String name;
	
	
	@OneToMany(mappedBy = "rolesId")
    private Set<UserRolesEntity> userRoles;


	public RolesEntity(Integer id, String name) {
		this.id = id;
		this.name = name;
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Set<UserRolesEntity> getUserRoles() {
		return userRoles;
	}


	public void setUserRoles(Set<UserRolesEntity> userRoles) {
		this.userRoles = userRoles;
	}

	
}