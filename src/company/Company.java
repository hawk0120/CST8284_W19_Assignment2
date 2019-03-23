package company;
import java.util.Calendar;

public class Company {

	private Employee[] employees;
	private static final int MAXNUMEMPLOYEES = 10;
	private static int numberEmployees = 0;
	public Company() {
		employees = new Employee[MAXNUMEMPLOYEES];

		addEmployee("Alvin Spring", 14, new OurDate(2, 12, 2014), 150000);
		addEmployee("Grant Barge", 21, new OurDate(18, 5, 2009), 40000);
		addEmployee("Ross Chuttle", 23, new OurDate(22, 2, 2010), 43269);
	}

	public int currentNumberEmployees() {
		return numberEmployees;
	}
	public boolean isMaximumEmployees() {
		return (numberEmployees >= MAXNUMEMPLOYEES);
	}

	public Employee[] getEmployees() {
		return employees;
	}
	

	public Employee findSeniorEmployee() {
		
		if (numberEmployees==0) return null; 		
		int seniorEmployeeIndex = 0; 
		Calendar calEarliestStartDate = (Calendar.getInstance());  
		
		OurDate odEarliestStartDate = employees[seniorEmployeeIndex].getStartDate();
		calEarliestStartDate.set(odEarliestStartDate.getYear(), 
				odEarliestStartDate.getMonth(), odEarliestStartDate.getDay());

		for (int employeeIndex = 1;  employeeIndex < numberEmployees; employeeIndex++) {
		     OurDate thisStartDate = employees[employeeIndex].getStartDate();
		     Calendar calThisStartDate = Calendar.getInstance();  // need to load new instance..
		     calThisStartDate.set(thisStartDate.getYear(),   
						thisStartDate.getMonth(), thisStartDate.getDay());
		     if (calThisStartDate.before(calEarliestStartDate)){
		    	 seniorEmployeeIndex = employeeIndex;
		    	 calEarliestStartDate = calThisStartDate;
		     }
		}
		return employees[seniorEmployeeIndex];  
	}
	

	public void addEmployee(String name, int employeeNumber, OurDate date, double salary) {
		if (!isMaximumEmployees())
		     employees[numberEmployees++] = new Employee(name, employeeNumber, date, salary);
		else 
			System.out.println("Attempt to exceed maximum Employee array size");
	}

}// end class 
