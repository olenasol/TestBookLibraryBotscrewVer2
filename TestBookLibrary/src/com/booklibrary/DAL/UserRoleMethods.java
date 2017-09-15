package com.booklibrary.DAL;

import org.hibernate.Session;

import com.booklibrary.models.User;
import com.booklibrary.models.User_role;
public class UserRoleMethods {
	
	public static User_role getUserRoleById(int id){
		Session s=Configurations.getSession();
		s.beginTransaction();
		User_role u=(User_role)s.get(User_role.class, id);
		s.getTransaction().commit();
		Configurations.closeSession(s);
		return u;
	}
	public static void addUserRole(User_role u){
		Session s=Configurations.getSession();
		s.beginTransaction();
		s.save(u);
		s.getTransaction().commit();
		Configurations.closeSession(s);
	}
}
