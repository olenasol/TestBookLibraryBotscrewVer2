package com.booklibrary.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User_role {
	@Id@GeneratedValue
	private int roleId;
	private String roleName;
	public User_role() {}
	public User_role(String name) {
		this.roleName=name;
	}
	public int getRoleId() {
		return roleId;
	}
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
