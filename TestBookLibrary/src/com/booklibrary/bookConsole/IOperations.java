package com.booklibrary.bookConsole;

import java.util.Scanner;

import com.booklibrary.DAL.AuthorMethods;

public interface IOperations {
	 Scanner scanner=new Scanner(System.in);
	 AuthorMethods am=new AuthorMethods();
	 void operationAdd();
	 void operationGetAll();
	 void operationEdit();
	 void operationRemove();
}
