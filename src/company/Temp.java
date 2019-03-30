package company;

public class Temp extends Employee {
	private OurDate endContractDate;
	
	public Temp() {
		this("Alvin Spring", 14, new OurDate(2, 12, 2014), 150000.0, new OurDate(31, 03, 2014));
	}
	
	public Temp(String name, int employeeNumber, OurDate startDate, double salary, OurDate endConstractDate) {
		super( name,
				employeeNumber,
				startDate,
				salary);
		this.setEndContractDate(endConstractDate);
	}

	public OurDate getEndContractDate() {
		return endContractDate;
	}
	
	public void setEndContractDate(OurDate endContractDate) {
		this.endContractDate = endContractDate;
	}
	@Override
	public void loadExtraInfo() {
		
	}
	
	
} // End of class

