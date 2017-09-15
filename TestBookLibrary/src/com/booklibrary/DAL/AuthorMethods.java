package com.booklibrary.DAL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.booklibrary.models.Author;
import com.booklibrary.models.Book;

public class AuthorMethods {
	public List<Author> getAllAuthors(){
		List<Author> listOfAuthors=new ArrayList<>();
		Session session=Configurations.getSession();
		try {
			session.beginTransaction();
			listOfAuthors=session.createQuery("FROM Author").list(); 
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
		return listOfAuthors;
	}
	public Author getAuthorById(int id){
		Session session=Configurations.getSession();
		Author author=null;
		try {
			session.beginTransaction();
			author=(Author)session.get(Author.class, id);
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
		return author;
	}
	public void addAuthor(Author author){
		Session session=Configurations.getSession();
		try {
			session.beginTransaction();
			session.save(author);
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
	public Author getAuthorByName(String name){
		Author author=new Author();
		Session session=Configurations.getSession();
		try {
			session.beginTransaction();
			List<Author> authors=session.createQuery("FROM Author where name=\'"+name+"\'").list();
			if(authors.size()>=1) {
				author=authors.get(0);
			}
			else {
				author=null;
			}
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
		return author;
	}
	public void updateAuthor(Author author){
		
		Session session=Configurations.getSession();
		try {
			session.beginTransaction();
			session.update(author);
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
