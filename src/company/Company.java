package company;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;

public class Company {
	private ArrayList<Employee> employees = new ArrayList<Employee>();

	public Company() {
		Staff staff = new Staff("Ross Chuttle", 23, new OurDate(22, 02,2010), 43269.0, "Finance");
		employees.add(staff);
		Manager manager = new Manager("Alvin Spring", 14, new OurDate(22, 12,2014), 15000.0, "Vice President");
		employees.add(manager);
		Temp temp = new Temp("Bob Ross", 2, new OurDate(10, 10, 1999), 40000.0, new OurDate(31, 03, 2019));
		employees.add(temp);
		//Instantiated new Employees for testing findEmployee
	}

	public int currentNumberEmployees() {
		return employees.size();
	}

	public boolean isMaximumEmployees() {
		return false;
	}

	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public Employee findEmployee(int empNumber) {
		if (employees.size() == 0) {
			return null;
		} 
		for (Employee searchEmployee : employees) {
			if (searchEmployee.getEmployeeNumber() == empNumber) {
				return searchEmployee;
			}
		}
		
		return null;
		}
	
	public Employee deleteEmployee(int empNumber) {
		if (employees.size() == 0) {
			return null;
		}
		for (Employee del : employees) {
			if (del.getEmployeeNumber() == empNumber) {
				employees.remove(del);
				return null;
			}
		}
		
		return null;
	}

	public Employee findSeniorEmployee() {
		if (employees.size() == 0) {
			System.out.println("There are no Employees");
			return null;
		}	
		int seniorEmployeeIndex = 0;
		Calendar calEarliestStartDate = (Calendar.getInstance());

		OurDate odEarliestStartDate = employees.get(seniorEmployeeIndex).getStartDate();
		calEarliestStartDate.set(odEarliestStartDate.getYear(), odEarliestStartDate.getMonth(),
				odEarliestStartDate.getDay());

		for (int employeeIndex = 1; employeeIndex < employees.size(); employeeIndex++) {
			OurDate thisStartDate = employees.get(employeeIndex).getStartDate();
			Calendar calThisStartDate = Calendar.getInstance(); // need to load new instance..
			calThisStartDate.set(thisStartDate.getYear(), thisStartDate.getMonth(), thisStartDate.getDay());
			if (calThisStartDate.before(calEarliestStartDate)) {
				seniorEmployeeIndex = employeeIndex;
				calEarliestStartDate = calThisStartDate;
			}
		}
		return employees.get(seniorEmployeeIndex);
	}

	public Employee addEmployee(String name, int employeeNumber, OurDate date, double salary, int emptype) {		
		switch(emptype) {
		case 1:
			Manager manager = new Manager(name, employeeNumber, date, salary, null);
			employees.add(manager);
			return manager;
		case 2:
			Staff staff = new Staff(name, employeeNumber, date, salary, null);
			employees.add(staff);
			return staff;			
		case 3:
			Temp temp = new Temp(name, employeeNumber, date, salary, new OurDate());
			employees.add(temp);
			return temp;
		}
		return null;		

	}

}// end class
