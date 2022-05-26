package com.reportgenerator;

import java.util.HashSet;


import com.reportgenerator.model.CustomerIDforGeoZoneReport;
import com.reportgenerator.model.ProjectData;

public class CustomerIDperGeoZoneReportGenerator {

	
	public CustomerIDforGeoZoneReport generateReport(ProjectData[] input) {
		
		CustomerIDforGeoZoneReport report = null;
		
		
		if (input.length > 0){
			HashSet<String>  customerContractSet = new HashSet<String>();
			
			report = new CustomerIDforGeoZoneReport();
			
			for(ProjectData projectData : input) {
				final String geozone  = projectData.getGeozone();
				String setKey = geozone+"-"+projectData.getCustomerId();
				if(!customerContractSet.contains(setKey)) {
					customerContractSet.add(setKey);
					if(report.getUniqueCustomers(geozone)!=null) {
						final Integer value = report.getUniqueCustomers(geozone)+1;
						report.setUniqueCustomers(geozone, value);
					}else {
						report.setUniqueCustomers(geozone, 1);
					}
				}
			}
			
		}
		
		
		return report;
		
	}
	
}
