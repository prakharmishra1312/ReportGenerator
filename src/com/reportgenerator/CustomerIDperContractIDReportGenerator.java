package com.reportgenerator;

import com.reportgenerator.model.ProjectData;

import java.util.ArrayList;
import java.util.HashSet;

import com.reportgenerator.model.CustomerIDforContractIDReport;

public class CustomerIDperContractIDReportGenerator {

	public CustomerIDforContractIDReport[] generateReport(ProjectData[] input) {
		
		CustomerIDforContractIDReport[] report = null;
		
		
		if (input.length > 0){
			HashSet<String>  customerContractSet = new HashSet<String>();
			ArrayList<CustomerIDforContractIDReport> reportList = new ArrayList<CustomerIDforContractIDReport>();
			for(ProjectData projectData : input) {
				String setKey = projectData.getContractId()+"-"+projectData.getCustomerId();
				if(!customerContractSet.contains(setKey)) {
					customerContractSet.add(setKey);
					
				}
			}
			
		}
		
		
		return report;
		
	}

}
