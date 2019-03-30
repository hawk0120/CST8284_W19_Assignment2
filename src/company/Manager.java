package company;

public class Manager extends Employee {
	private String title;
	
	public Manager() {
	} // Constructor
	
	public Manager(String name, int employeeNumber, OurDate startDate, double salary, String title) {
		super( name,
			employeeNumber,
			startDate,
			salary);
		this.setTitle(title);
	} 
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.loadExtraInfo();
		this.title = title;
		
	}
	
	@Override
	public void loadExtraInfo() {
		if (title == null) {
			System.out.println("What is the Managers Title: ");
			
		} else {
			title = "Manager";
		}
	}
	
}// End of class
