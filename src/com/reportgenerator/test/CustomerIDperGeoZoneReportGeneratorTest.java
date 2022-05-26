package com.reportgenerator.test;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.*;

import com.reportgenerator.model.ProjectData;
import com.reportgenerator.model.CustomerIDforGeoZoneReport;
import com.reportgenerator.CustomerIDperGeoZoneReportGenerator;

public class CustomerIDperGeoZoneReportGeneratorTest {

	CustomerIDperGeoZoneReportGenerator generator = new CustomerIDperGeoZoneReportGenerator();
	@Test
	public void testForEmptyInput() {
		ProjectData input[] = {};
		CustomerIDforGeoZoneReport report = generator.generateReport(input);
		assertNull(report);
	}
	
	@Test
	public void testForSingleInput() {
		ProjectData input[] = new ProjectData[1];
		input[0] = new ProjectData(2343225,2345,"us_east","RedTeam","ProjectApple","3445s");
		CustomerIDforGeoZoneReport report = generator.generateReport(input);
		assertEquals(1, report.getUniqueCustomers("us_east"));
	}
	
	
	@Test
	public void testForSameGeoZoneDifferentCustomerID() {
		ProjectData input[] = new ProjectData[2];
		input[0] = new ProjectData(2343225,2345,"us_east","RedTeam","ProjectApple","3445s");
		input[1] = new ProjectData(2343226,2345,"us_east","RedTeam","ProjectApple","3445s");
		CustomerIDforGeoZoneReport report = generator.generateReport(input);
		assertEquals(2, report.getUniqueCustomers("us_east"));;
	}
	
	@Test
	public void testForDifferentGeoZoneSameCustomerID() {
		ProjectData input[] = new ProjectData[2];
		input[0] = new ProjectData(2343225,2345,"us_east","RedTeam","ProjectApple","3445s");
		input[1] = new ProjectData(2343225,2346,"us_west","RedTeam","ProjectApple","3445s");
		CustomerIDforGeoZoneReport report = generator.generateReport(input);
		assertEquals(1, report.getUniqueCustomers("us_east"));
		assertEquals(1, report.getUniqueCustomers("us_west"));
	}
	
	
	@Test
	public void testForDifferentGeoZoneDifferentCustomerID() {
		
		ProjectData input[] = new ProjectData[4];
		input[0] = new ProjectData(2343225,2345,"us_west","RedTeam","ProjectApple","3445s");
		input[1] = new ProjectData(2343225,2346,"us_east","RedTeam","ProjectApple","3445s");
		input[2] = new ProjectData(2343226,2345,"us_west","RedTeam","ProjectApple","3445s");
		input[3] = new ProjectData(2343227,2345,"us_west","RedTeam","ProjectApple","3445s");
		
		CustomerIDforGeoZoneReport report = generator.generateReport(input);
		assertEquals(3, report.getUniqueCustomers("us_west"));
		assertEquals(1, report.getUniqueCustomers("us_east"));
		assertNull(report.getUniqueCustomers("ap_east"));
	}
	
	
	
	
}
