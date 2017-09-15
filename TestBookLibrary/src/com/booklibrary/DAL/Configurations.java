package com.booklibrary.DAL;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Configurations {
	public static Session getSession(){
		SessionFactory sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session=sessionFactory.openSession();
		return session;
	}
	public static void closeSession(Session s){
		s.close();
	}
}
