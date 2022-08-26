package com.oracle.aconex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Map.Entry;

import com.oracle.aconex.constants.Appconstants;
import com.oracle.aconex.vo.CustomerVO;
import com.oracle.aconex.vo.GeoZonesVO.GEOZONES;

public class GeoZoneCustomers {

	public void getgeoZoneBuild(CustomersDataService customersData, List<CustomerVO> customerlist) {
		BuildDurationService buildDuration = new BuildDurationService();

		HashMap<String, Set<String>> geoZoneCustomersmap = new HashMap<>();
		for (GEOZONES zone : GEOZONES.values()) {
			Set<String> customerIds = customersData.getCustomerIdsByGeoZone(zone.toString(), customerlist);
			if (!customerIds.isEmpty()) {
				geoZoneCustomersmap.put(zone.toString(), customerIds);
			}
		}

		System.out.println(Appconstants.NO_OF_CUSTOMERID + "Each geoZone");
		for (Entry<String, Set<String>> entry : geoZoneCustomersmap.entrySet()) {
			System.out.println(Appconstants.NO_OF_CUSTOMERID + entry.getKey() + " are:  " + entry.getValue().size());
		}

		System.out.println("CustomerID'S" + "For each geoZone");
		for (Entry<String, Set<String>> entry : geoZoneCustomersmap.entrySet()) {
			System.out
					.println("The number of customers for " + entry.getKey() + " are:- " + entry.getValue().toString());
		}

		System.out.println("The avg build duration" + "For each geoZone");
		for (GEOZONES geoZone : GEOZONES.values()) {
			int avg = buildDuration.getAvgBuild(geoZone.toString(), customerlist);
			System.out.println("The avg build duration " + avg + " for " + geoZone.toString());
		}
	}
}
