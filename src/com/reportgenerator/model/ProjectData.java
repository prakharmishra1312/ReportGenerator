package com.reportgenerator.model;

public class ProjectData {


	private int customerId;
	private int contractId;
	private String geozone;
	private String teamcode;
	private String projectCode;
	private String buildDuration;
	
	
	public int getCustomerId() {
		return customerId;
	}


	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}


	public int getContractId() {
		return contractId;
	}


	public void setContractId(int contractId) {
		this.contractId = contractId;
	}


	public String getGeozone() {
		return geozone;
	}


	public void setGeozone(String geozone) {
		this.geozone = geozone;
	}


	public String getTeamcode() {
		return teamcode;
	}


	public void setTeamcode(String teamcode) {
		this.teamcode = teamcode;
	}


	public String getProjectCode() {
		return projectCode;
	}


	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}


	public String getBuildDuration() {
		return buildDuration;
	}


	public void setBuildDuration(String buildDuration) {
		this.buildDuration = buildDuration;
	}



	public ProjectData(int customerId, int contractId, String geozone, String teamcode, String projectCode, String buildDuration) {
		this.customerId = customerId;
		this.contractId = contractId;
		this.geozone = geozone;
		this.teamcode = teamcode;
		this.projectCode = projectCode;
		this.buildDuration = buildDuration;
				
		
	}

}
