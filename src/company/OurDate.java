/*Course Name: CST8284
 * Student Name: Brady Hawkins
 * Assignment title: CST8284_W19_Assign01_EmployementManagementSystem
 * Assignment due date: February 11, 2019
 * 
 * 
 * Represents a date
 */

package company;

import java.util.Calendar;

public class OurDate {
	
	private static final Calendar CAL = Calendar.getInstance();
	private int day;
	private int month;
	private int year;
	
	public OurDate() {
	this.day = CAL.get(Calendar.DATE);
	this.month = CAL.get(Calendar.MONTH);
	this.year = CAL.get(Calendar.YEAR);
	}


	public OurDate(int day, int month, int year) {
		this.setDay(day);
		this.setMonth(month);
		this.setYear(year);
	} 
	
	public int getDay() {
		return day;
	}
	
	private void setDay(int day) {
		this.day = day;
	}
	
	public int getMonth() {
		return month;
	}
	
	private void setMonth(int month) {
		this.month = month;
	}
	
	public int getYear() {
		return year;
	}
	
	private void setYear(int year) {
		this.year = year;
	}
	@Override	
	public String toString() {
		return day + "/" + month + "/" + year;
	}
	@Override
	public boolean equals(Object obj) {

		return obj instanceof OurDate;
	}	
	
} //End of class
