package test;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

import com.reportgenerator.model.ProjectData;
import com.reportgenerator.model.CustomerIDforContractIDReport;
import com.reportgenerator.CustomerIDperContractIDReportGenerator;

public class CustomerIDperContractIDReportGeneratorTest {

	@Test
	public void testForEmptyInput() {
		CustomerIDperContractIDReportGenerator generator = new CustomerIDperContractIDReportGenerator();
		ProjectData input[] = {};
		CustomerIDforContractIDReport[] report = generator.generateReport(input);
		
		assertNull(report);
	}
	
	@Test
	public void testForSingleInput() {
		CustomerIDperContractIDReportGenerator generator = new CustomerIDperContractIDReportGenerator();
		ProjectData input[] = new ProjectData[1];
		input[0] = new ProjectData(2343225,2345,"us_east","RedTeam","ProjectApple","   d3445s");
		CustomerIDforContractIDReport[] report = generator.generateReport(input);
		assertEquals(1, report[0].getUniqueCustomers());
	}
	
	
	@Test
	public void testForSameContractIDDifferentCustomerID() {
		CustomerIDperContractIDReportGenerator generator = new CustomerIDperContractIDReportGenerator();
		ProjectData input[] = new ProjectData[2];
		input[0] = new ProjectData(2343225,2345,"us_east","RedTeam","ProjectApple","   d3445s");
		input[1] = new ProjectData(2343226,2345,"us_east","RedTeam","ProjectApple","   d3445s");
		CustomerIDforContractIDReport[] report = generator.generateReport(input);
		assertEquals(2, report[0].getUniqueCustomers());
	}
	
	@Test
	public void testForDifferentContractIDSameCustomerID() {
		CustomerIDperContractIDReportGenerator generator = new CustomerIDperContractIDReportGenerator();
		ProjectData input[] = new ProjectData[1];
		input[0] = new ProjectData(2343225,2345,"us_east","RedTeam","ProjectApple","   d3445s");
		input[0] = new ProjectData(2343225,2346,"us_east","RedTeam","ProjectApple","   d3445s");
		CustomerIDforContractIDReport[] report = generator.generateReport(input);
		assertEquals(2, report[0].getUniqueCustomers());
	}
	
}
