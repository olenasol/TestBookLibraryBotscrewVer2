package com.booklibrary.models;

import java.util.List;

import javax.persistence.Entity;

@Entity
public class Journal extends Book {
	private int numberOfIssue;
	
	public Journal() {}
	public Journal(String name,List<Author> author,int version) {
		super(name,author);
		this.numberOfIssue=version;
	}
	
	public int getNumberOfIssue() {
		return numberOfIssue;
	}

	public void setNumberOfIssue(int numberOfIssue) {
		this.numberOfIssue = numberOfIssue;
	}
	public String toString() {
		return super.toString()+" ver."+this.numberOfIssue;
	}
}
