package com.booklibrary.models;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.booklibrary.DAL.UserRoleMethods;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
public class User {
	@Id@GeneratedValue
	private int userId;
	private String email;
	private String password;
	@OneToOne
	@JoinColumn(name="roleId")
	private User_role userRole;
	public User(){}
	public User(String e,String p,User_role ur){
		email=e;
		password=p;
		userRole=ur;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int id) {
		userId=id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User_role getUserRole() {
		return userRole;
	}
	public void setUserRole(User_role userRole) {
		this.userRole = userRole;
	}
	@Override
    public int hashCode() {
        return email.hashCode()+password.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
       if (!(obj instanceof User))
            return false;
        if (obj == this)
            return true;

        User rhs = (User) obj;
        if((this.email.equals(rhs.email))&&(this.password.equals(rhs.password))){
        	return true;
        }
        else {
        	return false;
        }
    }
	
}
