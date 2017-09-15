package com.booklibrary.loginLogic;

import java.util.List;

import com.booklibrary.DAL.UserMethods;
import com.booklibrary.models.User;

public class RegisterMethods {
	public boolean register(User user) {
		List<User> listOfUsers=UserMethods.getUsers();
		if(listOfUsers.contains(user)) {
			return false;
		}
		else {
			UserMethods.addUser(user);
			return true;
		}
	}
}
