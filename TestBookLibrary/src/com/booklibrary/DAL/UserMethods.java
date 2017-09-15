package com.booklibrary.DAL;

import java.util.ArrayList;

import org.hibernate.Session;

import com.booklibrary.models.User;
public class UserMethods {
	@SuppressWarnings({ "deprecation", "unchecked" })
	public static ArrayList<User> getUsers(){
		ArrayList<User> arr=new ArrayList<User>();
		Session s=Configurations.getSession();
		s.beginTransaction();
		arr=(ArrayList<User>) s.createCriteria(User.class).list();
		s.getTransaction().commit();
		Configurations.closeSession(s);
		return arr;
	}
	public static User getUserById(int id){
		Session s=Configurations.getSession();
		s.beginTransaction();
		User u=(User)s.get(User.class, id);
		s.getTransaction().commit();
		Configurations.closeSession(s);
		return u;
	}
	public static User getUserByEmail(String em){
		ArrayList<User> arr=getUsers();
		User user=new User();
		for(User u:arr){
			if(u.getEmail().equals(em)){
				user=u;
				break;
			}
		}
		return user;
	}
	public static void addUser(User u){
		Session s=Configurations.getSession();
		s.beginTransaction();
		s.save(u);
		s.getTransaction().commit();
		Configurations.closeSession(s);
	}
	public static void deleteUser(int id){
		User u=getUserById(id);
		Session s=Configurations.getSession();
		s.beginTransaction();
		s.delete(u);
		s.getTransaction().commit();
		Configurations.closeSession(s);
	}
	public static void updateUser(User u){
		User us2=getUserById(u.getUserId());
		us2.setUserId(u.getUserId());
		us2.setEmail(u.getEmail());
		us2.setPassword(u.getPassword());
		us2.setUserRole(u.getUserRole());
		Session s=Configurations.getSession();
		s.beginTransaction();
		s.update(us2);
		s.getTransaction().commit();
		Configurations.closeSession(s);
	}
}
