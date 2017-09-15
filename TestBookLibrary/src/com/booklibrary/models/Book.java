package com.booklibrary.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Book {
	@Id@GeneratedValue
	private int bookId;
	private String name;
	@ManyToMany(fetch=FetchType.EAGER)
	private List<Author> listOfAuthors=new ArrayList<>();
	
	public Book() {}
	public Book(String name,List<Author> author) {
		this.name=name;
		this.listOfAuthors=author;
	}
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public List<Author> getListOfAuthors() {
		return listOfAuthors;
	}
	public void setListOfAuthors(List<Author> listOfAuthors) {
		this.listOfAuthors = listOfAuthors;
	}
	public String toString() {
		return "\""+this.name+"\""+" "+this.listOfAuthors;
	}
	
}
