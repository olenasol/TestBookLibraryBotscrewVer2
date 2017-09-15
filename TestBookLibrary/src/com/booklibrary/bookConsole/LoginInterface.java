package com.booklibrary.bookConsole;

import java.util.Scanner;

import com.booklibrary.loginLogic.LoginMethods;
import com.booklibrary.loginLogic.RegisterMethods;
import com.booklibrary.models.User;

public class LoginInterface {
	static private Scanner scanner=new Scanner(System.in);
	
	public static void registerUser() {
		System.out.println("Enter email");
		String name=scanner.nextLine();
		System.out.println("Enter password");
		String password=scanner.nextLine();
		System.out.println("Confirm password");
		String password2=scanner.nextLine();
		if(password.equals(password2)) {
			User u=new User(name,password,null);
			RegisterMethods rm=new RegisterMethods();
			if(rm.register(u)) {
				System.out.println("User was successfully registered");
			}
			else {
				System.out.println("User already exists");
			}
		}
		else {
			System.out.println("Passwords don't match");
		}
	}
	public static boolean loginUser() {
		System.out.println("Enter email");
		String name=scanner.nextLine();
		System.out.println("Enter password");
		String password=scanner.nextLine();
		if(LoginMethods.isUserLoggedIn(name, password)) {
			System.out.println("User is logged in");
			return true;
		}
		else {
			if(!LoginMethods.isRegisteredUser(name)) {
				System.out.println("User with such name is not registered");
			}
			else if(!LoginMethods.isPasswordRight(name, password)) {
				System.out.println("Wrong password");
			}
			return false;
		}
	}
}
