package com.reportgenerator.model;

import java.util.HashMap;

public class CustomerIDforGeoZoneReport {

	HashMap<String, Integer> geoZoneReportMap = new HashMap<String, Integer>();

	public Integer getUniqueCustomers(String geoZone ) {
		return geoZoneReportMap.get(geoZone);
	}

	public void setUniqueCustomers(String geoZone, Integer value) {
		this.geoZoneReportMap.put(geoZone, value);
	}

}
