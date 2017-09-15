package com.booklibrary.bookConsole;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import com.booklibrary.DAL.*;
import com.booklibrary.loginLogic.RegisterMethods;
import com.booklibrary.models.*;

public class BookMain {
	
	private static boolean isUserLoggedIn;
	
	private static boolean loginMethod(int k) {
		return true;
	}
	
	public static void main(String[] args) {
		while(!isUserLoggedIn) {
			isUserLoggedIn=LoginInterface.loginUser();
		}
		
		int operation=0;
		Scanner scanner=new Scanner(System.in);
		while(operation!=5) {
			System.out.println("Choose operation : 1 - add, 2 -edit, 3-remove,4-get all books, 5-quit");
			String input=scanner.nextLine();
			while(!OperationInterface.tryParseInt(input)){
				System.out.println("Enter a valid number");
				input=scanner.nextLine();
			}
			operation=Integer.parseInt(input);
			OperationInterface op=new OperationInterface();
			switch(operation){
				case 1:op.operationAdd();
					   break;
				case 2:op.operationEdit();break;
				case 3:op.operationRemove();
				       break;
				case 4:op.operationGetAll();
					   break;
				case 5:System.exit(0);break;
				default:System.out.println("Please, enter valid operation");
			}
		}
	}

}
