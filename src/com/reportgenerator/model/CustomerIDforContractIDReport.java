package com.reportgenerator.model;

public class CustomerIDforContractIDReport {

	private Integer contractID;
	private Integer uniqueCustomers;

	public Integer getUniqueCustomers() {
		return uniqueCustomers;
	}

	public void setUniqueCustomers(Integer value) {
		this.uniqueCustomers = value;
	}

	public Integer getContractID() {
		return contractID;
	}

	public void setContractID(Integer contractID) {
		this.contractID = contractID;
	}

}
