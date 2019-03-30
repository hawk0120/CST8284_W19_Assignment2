package company;

import java.util.ArrayList;
import java.util.Calendar;

public class Company {
	private ArrayList<Employee> employees = new ArrayList<Employee>();

	public Company() {}

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
		int j = 0;
		for (int i = 0; empNumber != employees.get(i).getEmployeeNumber(); i++) {
			j++;
		}
		return employees.get(j);
	}

	public Employee deleteEmployee(int empNumber) {
		Employee del = new Staff();
		del = findEmployee(empNumber);
		employees.remove(del);
		return del;
	}

	public Employee findSeniorEmployee() {
		if (employees.size() == 0)
			return null;
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
