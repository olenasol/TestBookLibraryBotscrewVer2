package com.booklibrary.bookConsole;

import java.util.ArrayList;
import java.util.List;
import com.booklibrary.DAL.JournalMethods;
import com.booklibrary.models.Author;
import com.booklibrary.models.Book;
import com.booklibrary.models.Journal;

public class OperationJournalInterface implements IOperations{
	JournalMethods bm=new JournalMethods();
	
	public static boolean tryParseInt(String value) {  
	     try {  
	         Integer.parseInt(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}
	
	public void operationAdd() {
		List<String> listOfAuthors=new ArrayList<>();
		System.out.println("Please enter name of the new journal");
		String name=scanner.nextLine();
		System.out.println("Please enter number of issue");
		String issueNumberStr=scanner.nextLine();
		int issueNumber=Integer.parseInt(issueNumberStr);
		System.out.println("Please enter author of the new journal");
		listOfAuthors.add(scanner.nextLine());
		System.out.println("Do you want to add another author?(y/n)");
		String ans=scanner.nextLine();
		while(ans.equals("y")) {
			System.out.println("Please enter another author of the new journal");
			listOfAuthors.add(scanner.nextLine());
			System.out.println("Do you want to add another author?(y/n)");
			ans=scanner.nextLine();
		}
		List<Author> la=new ArrayList<>();
		for(String n:listOfAuthors) {
			if(am.getAuthorByName(n)==null) {
				Author a=new Author(n);
				la.add(a);
			}
			else {
				la.add(am.getAuthorByName(n));
			}
		}
		
		Journal journal=new Journal(name,la,issueNumber);
		for(Author author:la) {
			author.getListOfBooks().add(journal);
			if(am.getAuthorByName(author.getName())==null) {
				am.addAuthor(author);
			}
			else {
				am.updateAuthor(author);
			}
		}
		bm.addJournal(journal);;
		System.out.println("Journal was added successfully");
	}
	public void operationEdit() {
		System.out.println("Enter name of the journal to edit");
		String name=scanner.nextLine();
		List<Journal> lb=bm.getJournalsByName(name);
		if(lb.size()==0) {
			System.out.println("Journal not found");
		}
		else if(lb.size()==1) {
			System.out.println("Enter new name of the journal");
			String nameEditedBook=scanner.nextLine();
			System.out.println("Enter new issueNumber of the journal");
			String issueNumberStr=scanner.nextLine();
			int issueNumber=Integer.parseInt(issueNumberStr);
			Journal journal=lb.get(0);
			journal.setName(nameEditedBook);
			journal.setNumberOfIssue(issueNumber);
			bm.updateJournal(journal);
			System.out.println("Journal was successfully edited");
		}
		else {
			List<Integer> listOfIds=printList(lb);
			System.out.println("Choose number of journal to edit");
			int number=getCorrectNumber(listOfIds);
			Journal b=bm.getJournalById(number);
			System.out.println("Enter new name of the journal");
			String nameEditedJournal=scanner.nextLine();
			System.out.println("Enter new issueNumber of the journal");
			String issueNumberStr=scanner.nextLine();
			int issueNumber=Integer.parseInt(issueNumberStr);
			b.setName(nameEditedJournal);
			
			b.setNumberOfIssue(issueNumber);
			bm.updateJournal(b);;
			System.out.println("Journal was successfully edited");
		}
	}
	
	public void operationRemove() {
		System.out.println("Enter name of the journal");
		String name=scanner.nextLine();
		List<Journal> lb=bm.getJournalsByName(name);
		if(lb.size()==0) {
			System.out.println("Journal not found");
		}
		else if(lb.size()==1) {
			bm.deleteJournal(lb.get(0).getBookId());
			System.out.println("Journal was removed successfully");
		}
		else {
			List<Integer> listOfIds=new ArrayList<>();
			listOfIds=printList(lb);
			System.out.println("Choose number of journal to delete");
			int number=getCorrectNumber(listOfIds);
			bm.deleteJournal(number);
			System.out.println("Journal was removed successfully");
		}
	}
	
	public void operationGetAll() {
		List<Journal> l=bm.getAllJournals();
		for(Journal b:l) {
		   System.out.println(b);
		}
	}
	private static List<Integer> printList(List<Journal> lb) {
		List<Integer> listOfIds=new ArrayList<>();
		for(Journal b:lb) {
			System.out.println(b.getBookId()+" - " +b.toString());
			listOfIds.add(b.getBookId());
		}
		return listOfIds;
	}
	private static int getCorrectNumber(List<Integer> listOfIds) {
		String input=scanner.nextLine();
		while(!OperationInterface.tryParseInt(input)||!listOfIds.contains(Integer.parseInt(input))){
			System.out.println("Enter number in the list of journals");
			input=scanner.nextLine();
		}
		int number=Integer.parseInt(input);
		return number;		
	}

}
