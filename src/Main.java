

import Database.DbConnection;
import userInput.GetData;
import Members.*;

public class Main {
	public static void main(String args[]) {
		// Variables.
		boolean loop = true;

		// ESTABLISH DB CONNECTION.
		DbConnection.DbConnect();

		// WELCOMING MESSAGE.
		System.out.println("• Welocme to FACULTY Application •\n");
		while(loop) {
		System.out.println("Enter your choice :\n" + "---------------------\n"
		+ "[1] Add new Student\n[2] Add new Professor\n"
		+ "[3] Remove Student\n[4] Remove Professor\n" + "[5] Show all Students\n[6] Show All Professors\n"
				+ "[0] Exit");

		// GETTING USER CHOICE.
		int choice = GetData.GetInt();

		switch(choice) {
		// Termination.
		case 0:		
			System.out.println("Thanks for using FACULTY application.");
			System.exit(0);
			break;
		// Add new Student.
		case 1:		
			Student.DB_add();
			break;
		// Add new Professor.	
		case 2:		
			Professor.DB_add();
			break;
		// Remove Student.	
		case 3:
			Student.DB_remove();
			break;
		// Remove Professor.	
		case 4:
			Professor.DB_remove();
			break;
		// Show All Students.
		case 5:
			Student.DB_showAll();
			break;
		// Show All Professors.	
		case 6:
			Professor.DB_showAll();
			break;
		// INVALID INPUT.	
		default:	
			System.out.println("Sorry, Invalid choice !");
		}
		
		// ASK FOR REPEAT.
		System.out.println("\nDo another opearation ? [Y / N]");
		String ch = GetData.GetString();
		switch(ch){
		case "Y":
		case "y":
			loop = true;
			break;
		case "N" :
		case "n" :
			loop = false;
			System.out.println("\nThanks for using FACULTY application.");
			break;
		default:
			loop = false;
			System.out.println("\nSorry, Invalid Input !\nThanks for using FACULTY application.");
		}
	}
	}
}
