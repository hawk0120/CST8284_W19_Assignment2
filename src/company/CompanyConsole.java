package company;

import java.util.Scanner;

/**
 * Class CompanyConsole: launches program
 * @author Carolyn MacIsaac, with modifications by Dave Houtman
 * CST8284 
 * Assignment 1: Company Management Tool prototype
 * Release Date: February 11 2019
 */

public class CompanyConsole {
	
	// named constants, used in the menu below
	private static final int ADDEMPLOYEE = 1;
	private static final int DISPLAYEMPLOYEES = 2;
	private static final int DISPLAYSENIOREMPLOYEE = 3;
	private static final int EXIT = 9;
	
	// a variable to hold a company object, itself made up of employees
	private Company startUp;
	
	// used for menu input
	Scanner in = new Scanner(System.in);
	
	// default startup object for the application
	public CompanyConsole() {
		startUp = new Company();
	}

	// starting point of execution for the program; loads a new instance of this
	// class, and runs the menu for user input
	public static void main (String [] args) {	
		CompanyConsole console = new CompanyConsole();
		console.menu();	
	}
	
	// the main interface for the application; the user's choices drive program
	// execution
	public void menu(){	
		int choice;
		do{
		
			System.out.println("********************************************************");
			System.out.println(CompanyConsole.ADDEMPLOYEE + ".  ADD EMPLOYEE");
			System.out.println(CompanyConsole.DISPLAYEMPLOYEES+ ".  DISPLAY EMPLOYEES");
			System.out.println(CompanyConsole.DISPLAYSENIOREMPLOYEE+ ".  DISPLAY SENIOR EMPLOYEE");
			System.out.println(CompanyConsole.EXIT + ".  EXIT ");
			System.out.println("*******************************************************\n");
			
			System.out.print("SELECTION: ");
			
			choice = in.nextInt();
			in.nextLine(); //get rid of newline character in buffer
			
			switch(choice){
				case CompanyConsole.ADDEMPLOYEE:
					addEmployee();
					break;
				case CompanyConsole.DISPLAYEMPLOYEES:
					displayEmployees();
					break;
				case CompanyConsole.DISPLAYSENIOREMPLOYEE:
					displaySeniorEmployee();
					break;
				case CompanyConsole.EXIT:
					System.out.println("Goodbye");
					break;
				default:
					System.out.println("INVALID CHOICE; PLEASE RE-ENTER");
			}	
		} while(choice != CompanyConsole.EXIT); //end do and exit program
	}
	private void displaySeniorEmployee() {
		if(startUp.getEmployees().length == 0){
			System.out.println("There are no employees\n");
		}
		else{
			Employee e = startUp.findSeniorEmployee();
			System.out.println("SENIOR EMPLOYEE:\n" +e.toString());
		}
	}
	private void displayEmployees() {
		System.out.println("NAME\t\t\tEMPLOYEE NO.\tSTART DATE\tSALARY\n");	
		for(int i = 0; i < startUp.currentNumberEmployees(); i++)
			if (startUp.getEmployees()[i] !=null)
			   System.out.println(startUp.getEmployees()[i]);	
	}
	private void addEmployee() {	
		if(startUp.isMaximumEmployees()) 
			System.out.println("Attempt to exceed maximum Employee array size;\n" +
		                       "can't add another employee");
		else{  
			
			System.out.println("ENTER NEW EMPLOYEE INFORMATION:\n");
			System.out.print("NAME: ");
			String name = in.nextLine();
			
			System.out.print("EMPLOYEE NUMBER: ");
			int employeeNumber = in.nextInt();
			
			System.out.println("HIRING DATE");
			System.out.print("YEAR: ");
			int year = in.nextInt();
			
			System.out.print("MONTH: ");
			int month = in.nextInt();
			
			System.out.print("DAY: ");
			int day = in.nextInt();
			
			System.out.println("SALARY: ");
			double salary = in.nextDouble();
			
			startUp.addEmployee(name, employeeNumber, new OurDate(day, month, year), salary);
				
		}//end else
	}
	
}//END CLASS COMPANYCONSOLE
