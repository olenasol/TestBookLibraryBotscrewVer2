package com.booklibrary.DAL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.booklibrary.models.Journal;

public class JournalMethods {

	public List<Journal> getAllJournals(){
		List<Journal> listOfJournals=new ArrayList<>();
		Session session=Configurations.getSession();
		try {
			session.beginTransaction();
			listOfJournals=session.createQuery("FROM Journal").list(); 
			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			if(session.getTransaction()!=null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace(); 
		}
		finally {
			Configurations.closeSession(session);
		}
		Collections.sort(listOfJournals, (a,b)->a.getName().compareTo(b.getName()));
		return listOfJournals;
	}
	public Journal getJournalById(int id){
		Session session=Configurations.getSession();
		Journal journal=null;
		try {
			session.beginTransaction();
			journal=(Journal)session.get(Journal.class, id);
			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			if(session.getTransaction()!=null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace(); 
		}
		finally {
			Configurations.closeSession(session);
		}
		return journal;
	}
	
	public List<Journal> getJournalsByName(String journalName){
		List<Journal> listOfJournals=new ArrayList<>();
		Session session=Configurations.getSession();
		try {
			session.beginTransaction();
			listOfJournals=session.createQuery("FROM Journal where name=\'"+journalName+"\'").list(); 
			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			if(session.getTransaction()!=null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace(); 
		}
		finally {
			Configurations.closeSession(session);
		}
		return listOfJournals;
	}
	
	public void addJournal(Journal journal){
		Session session=Configurations.getSession();
		try {
			session.beginTransaction();
			session.save(journal);
			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			if(session.getTransaction()!=null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace(); 
		}
		finally {
			Configurations.closeSession(session);
		}
	}
	public  void deleteJournal(int id){
		Journal journal=getJournalById(id);
		Session session=Configurations.getSession();
		try {
			session.beginTransaction();
			session.delete(journal);
			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			if(session.getTransaction()!=null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace(); 
		}
		finally {
			Configurations.closeSession(session);
		}
	}
	public void updateJournal(Journal journal){
		
		Session session=Configurations.getSession();
		try {
			session.beginTransaction();
			session.update(journal);
			session.getTransaction().commit();
		}
		catch (HibernateException e) {
			if(session.getTransaction()!=null) {
				session.getTransaction().rollback();
			}
			e.printStackTrace(); 
		}
		finally {
			Configurations.closeSession(session);
		}
	}
}
