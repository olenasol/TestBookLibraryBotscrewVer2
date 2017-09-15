package com.booklibrary.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Author {
	@Id@GeneratedValue
	private int authorId;
	private String name;
	@ManyToMany(fetch = FetchType.EAGER,mappedBy="listOfAuthors") 
	private List<Book> listOfBooks=new ArrayList<>();
	public Author(){}
	public Author(String name){
		this.name=name;
	}
	public int getAuthorId() {
		return authorId;
	}
	public void setAuthorId(int authorId) {
		this.authorId = authorId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Book> getListOfBooks() {
		return listOfBooks;
	}
	public void setListOfBooks(List<Book> listOfBooks) {
		this.listOfBooks = listOfBooks;
	}
	public String toString() {
		return this.name;
	}
}
