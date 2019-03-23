package company;
import java.util.ArrayList;
import java.util.Calendar;

public class Company {
	private ArrayList<Employee> employees = new ArrayList<Employee>();
	public Company() {

		employees.add(new Employee("Alvin Spring", 14, new OurDate(2, 12, 2014), 150000));
		employees.add(new Employee("Grant Barge", 21, new OurDate(18, 5, 2009), 40000));
		employees.add(new Employee("Ross Chuttle", 23, new OurDate(22, 2, 2010), 43269));
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
	

	public Employee findSeniorEmployee() {	
		if (employees.size() == 0) return null; 		
		int seniorEmployeeIndex = 0; 
		Calendar calEarliestStartDate = (Calendar.getInstance());  
		
		OurDate odEarliestStartDate = employees.get(seniorEmployeeIndex).getStartDate();
		calEarliestStartDate.set(odEarliestStartDate.getYear(), 
				odEarliestStartDate.getMonth(), odEarliestStartDate.getDay());

		for (int employeeIndex = 1;  employeeIndex < employees.size(); employeeIndex++) {
		     OurDate thisStartDate = employees.get(employeeIndex).getStartDate();
		     Calendar calThisStartDate = Calendar.getInstance();  // need to load new instance..
		     calThisStartDate.set(thisStartDate.getYear(),   
						thisStartDate.getMonth(), thisStartDate.getDay());
		     if (calThisStartDate.before(calEarliestStartDate)){
		    	 seniorEmployeeIndex = employeeIndex;
		    	 calEarliestStartDate = calThisStartDate;
		     }
		}
		return employees.get(seniorEmployeeIndex);  
	}
	

	public void addEmployee(String name, int employeeNumber, OurDate date, double salary) {
		if (!isMaximumEmployees())
		     employees.add( new Employee(name, employeeNumber, date, salary));
		else 
			System.out.println("Attempt to exceed maximum Employee array size");
	}

}// end class 
