package com.booklibrary.loginLogic;

import com.booklibrary.DAL.UserMethods;
import com.booklibrary.models.User;

public class LoginMethods {
	public static boolean isRegisteredUser(String name){
		User u=UserMethods.getUserByEmail(name);
		if(u.getEmail()!=null){
			return true;
		}
		else{
			return false;
		}
	}
	public static boolean isPasswordRight(String name,String pass){
		User u=UserMethods.getUserByEmail(name);
		if(u.getEmail()!=null){
			if(u.getPassword().equals(pass)){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}
	public static boolean isUserLoggedIn(String name,String pass){
		boolean isuser=isRegisteredUser(name);
		boolean ispass=isPasswordRight(name,pass);
		if (isuser&&ispass){
			return true;
		}
		else{
			return false;
		}
	}
}
