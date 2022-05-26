package com.reportgenerator.test;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

import com.reportgenerator.model.ProjectData;
import com.reportgenerator.model.CustomerIDforContractIDReport;
import com.reportgenerator.CustomerIDperContractIDReportGenerator;

public class CustomerIDperContractIDReportGeneratorTest {
	CustomerIDperContractIDReportGenerator generator = new CustomerIDperContractIDReportGenerator();

	@Test
	public void given_EmptyInput_When_calculateReport_Then_GenerateNull() {
		
		ProjectData input[] = {};
		CustomerIDforContractIDReport report = generator.generateReport(input);
		assertNull(report);
	}
	
	@Test
	public void givenSingleInputWhenGenerate() {
		ProjectData input[] = new ProjectData[1];
		input[0] = new ProjectData(2343225,2345,"us_east","RedTeam","ProjectApple","3445s");
		CustomerIDforContractIDReport report = generator.generateReport(input);
		assertEquals(1, report.getUniqueCustomers(2345));
	}
	
	
	@Test
	public void testForSameContractIDDifferentCustomerID() {
		
		ProjectData input[] = new ProjectData[2];
		input[0] = new ProjectData(2343225,2345,"us_east","RedTeam","ProjectApple","3445s");
		input[1] = new ProjectData(2343226,2345,"us_east","RedTeam","ProjectApple","3445s");
		CustomerIDforContractIDReport report = generator.generateReport(input);
		assertEquals(2, report.getUniqueCustomers(2345));;
	}
	
	@Test
	public void testForDifferentContractIDSameCustomerID() {
		
		ProjectData input[] = new ProjectData[2];
		input[0] = new ProjectData(2343225,2345,"us_east","RedTeam","ProjectApple","3445s");
		input[1] = new ProjectData(2343225,2346,"us_east","RedTeam","ProjectApple","3445s");
		CustomerIDforContractIDReport report = generator.generateReport(input);
		assertEquals(1, report.getUniqueCustomers(2345));
		assertEquals(1, report.getUniqueCustomers(2346));
	}
	
	
	@Test
	public void testForDifferentContractIDDifferentCustomerID() {
		
		ProjectData input[] = new ProjectData[4];
		input[0] = new ProjectData(2343225,2345,"us_east","RedTeam","ProjectApple","3445s");
		input[1] = new ProjectData(2343225,2346,"us_east","RedTeam","ProjectApple","3445s");
		input[2] = new ProjectData(2343226,2345,"us_east","RedTeam","ProjectApple","3445s");
		input[3] = new ProjectData(2343227,2345,"us_east","RedTeam","ProjectApple","3445s");
		
		CustomerIDforContractIDReport report = generator.generateReport(input);
		assertEquals(3, report.getUniqueCustomers(2345));
		assertEquals(1, report.getUniqueCustomers(2346));
		assertNull(report.getUniqueCustomers(2347));
	}
	
	
	
	
}
