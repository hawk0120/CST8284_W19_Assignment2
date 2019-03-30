package company;

public class Staff extends Employee {
	
	private String department;
	
	public Staff() {
		this("Ross Chuttle", 23, new OurDate(22, 02,2010), 43269.0, "Finance");
	}
	
	public Staff(String name, int employeeNumber, OurDate startDate, double salary, String department) {
		super(name,
			employeeNumber,
			startDate,
			salary);
		this.setDepartment(department);
	}
	
	public String getDepartment() {
		return department;
	}
	
	public void setDepartment(String department) {
		this.department = department;
	}
	
	public void loadExtraInfo() {
		
		
	};
	
	
} // End of class
