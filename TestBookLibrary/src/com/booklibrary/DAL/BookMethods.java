package com.booklibrary.DAL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.booklibrary.models.Book;


public class BookMethods {
	@SuppressWarnings("unchecked")
	public List<Book> getAllBooks(){
		List<Book> listOfBooks=new ArrayList<>();
		Session session=Configurations.getSession();
		try {
			session.beginTransaction();
			listOfBooks=session.createQuery("FROM Book").list(); 
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
		Collections.sort(listOfBooks, (a,b)->a.getName().compareTo(b.getName()));
		return listOfBooks;
	}
	public Book getBookById(int id){
		Session session=Configurations.getSession();
		Book book=null;
		try {
			session.beginTransaction();
			book=(Book)session.get(Book.class, id);
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
		return book;
	}
	
	public List<Book> getBooksByName(String bookName){
		List<Book> listOfBooks=new ArrayList<>();
		Session session=Configurations.getSession();
		try {
			session.beginTransaction();
			listOfBooks=session.createQuery("FROM Book where name=\'"+bookName+"\'").list(); 
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
		return listOfBooks;
	}
	
	public void addBook(Book book){
		Session session=Configurations.getSession();
		try {
			session.beginTransaction();
			session.save(book);
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
	public  void deleteBook(int id){
		Book book=getBookById(id);
		Session session=Configurations.getSession();
		try {
			session.beginTransaction();
			session.delete(book);
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
	public void updateBook(Book book){
		Book book2=new Book();
		book2.setBookId(book.getBookId());
		book2.setName(book.getName());
		book2.setListOfAuthors(book.getListOfAuthors());
		Session session=Configurations.getSession();
		try {
			session.beginTransaction();
			session.update(book2);
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
