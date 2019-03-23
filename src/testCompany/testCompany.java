package testCompany;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/*Course Name: CST8284
 * Student Name: Brady Hawkins
 * Assignment title: CST8284_W19_Assign02_EmployementManagementSystem
 * Assignment due date: February 11, 2019
 *
 *JUnit tests
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import company.Employee;
import company.OurDate;

class TestEmployee {
		Employee e = new Employee();
		Employee f = new Employee();
		
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.out.println("Starting Tests........");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		System.out.println("Finished testing.....");
	}

	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Before test........");
	}

	@AfterEach
	void tearDown() throws Exception {
		System.out.println("After Test.....");
		e = null;
		f = null;
	}

	@Test
	public void testEmployeeEquals() {
		e = new Employee ("foo", 3, null, 20.0);
		f = new Employee ("foo", 3, null, 20.0);
		assertEquals(e, e);
	}
	
	@Test
	public void testEmployeeNotEquals() {
		f = new Employee ("Baz", 3, null, 20.0);
		e = new Employee ("foo", 5, null, 1500.0);
		assertEquals(e, f);
	}
	
	@Test
	public void testDefaultDateConstructor() {
			
		OurDate a = new OurDate();
		assertEquals(a, a);
	}
	
	@Test
	public void testOverLoadedOurDateDateConstructor() {
		OurDate a  = new OurDate(2, 11, 2019);
		assertEquals(a, a);
	}
	
}// END JUNT CLASS
