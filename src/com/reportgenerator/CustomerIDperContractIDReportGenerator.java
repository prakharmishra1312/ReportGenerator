package com.reportgenerator;

import com.reportgenerator.model.ProjectData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.reportgenerator.model.CustomerIDforContractIDReport;

public class CustomerIDperContractIDReportGenerator {

	public CustomerIDforContractIDReport generateReport(ProjectData[] input) {
		
		CustomerIDforContractIDReport report = null;
		
		
		if (input.length > 0){
			HashSet<String>  customerContractSet = new HashSet<String>();
			
			report = new CustomerIDforContractIDReport();
			
			for(ProjectData projectData : input) {
				final Integer contractId  = projectData.getContractId();
				String setKey = contractId+"-"+projectData.getCustomerId();
				if(!customerContractSet.contains(setKey)) {
					customerContractSet.add(setKey);
					if(report.getUniqueCustomers(contractId)!=null) {
						final Integer value = report.getUniqueCustomers(contractId)+1;
						report.setUniqueCustomers(contractId, value);
					}else {
						report.setUniqueCustomers(contractId, 1);
					}
				}
			}
			
		}
		
		
		return report;
		
	}

}
