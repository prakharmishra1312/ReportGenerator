package com.reportgenerator.model;

import java.util.HashMap;

public class CustomerIDforContractIDReport {

	HashMap<Integer, Integer> contractIDReportMap = new HashMap<Integer, Integer>();

	public Integer getUniqueCustomers(Integer contractID ) {
		return contractIDReportMap.get(contractID);
	}

	public void setUniqueCustomers(Integer contractID, Integer value) {
		this.contractIDReportMap.put(contractID, value);
	}

}
