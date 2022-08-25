package com.oracle.aconex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import com.oracle.aconex.constants.Appconstants;
import com.oracle.aconex.vo.CustomerVO;
import com.oracle.aconex.vo.GeoZonesVO.GEOZONES;

public class Report {
	
	
	
/* Generate the Customized Report*/
	public void report(List<CustomerVO> customerlist) {

		if (!customerlist.isEmpty()) {

			ContractIDs contractIDs = new ContractIDs();
			Set<String> contractIds = contractIDs.getContractsIDs(customerlist);

			BuildDuration buildDuration = new BuildDuration();
			CustomersData customersData = new CustomersData();

			/* Number of CustomerId's for each ContractId*/

			System.out.println(Appconstants.NO_OF_CUSTOMERID + "Each contract ID");			
			for (String contractId : contractIds) {
				Set<String> res = customersData.getCustomerIdsByContractId(contractId, customerlist);
				System.out.println(Appconstants.NO_OF_CUSTOMERID + contractId + " are:-" + res.size());

			}

			HashMap<String, Set<String>> geoZoneCustomersmap = new HashMap<>();
			for (GEOZONES zone : GEOZONES.values()) {
				Set<String> customerIds = customersData.getCustomerIdsByGeoZone(zone.toString(), customerlist);
				if (!customerIds.isEmpty()) {
					geoZoneCustomersmap.put(zone.toString(), customerIds);
				}
			}

			/* Number of CustomerId's for each GeoZone*/
			System.out.println(Appconstants.NO_OF_CUSTOMERID + "For each geoZone");
			for (Entry<String, Set<String>> entry : geoZoneCustomersmap.entrySet()) {
				System.out.println(Appconstants.NO_OF_CUSTOMERID + entry.getKey() + "are:-" + entry.getValue().size());
			}
			
			/*CustomerId's for each GeoZone*/
			System.out.println("CustomerID'S" + "For each geoZone");
			for (Entry<String, Set<String>> entry : geoZoneCustomersmap.entrySet()) {
				System.out.println(
						"The number of customers for " + entry.getKey() + ", are = " + entry.getValue().toString());
			}

			/*The avg build duration for each GeoZone*/
			System.out.println("The avg build duration" + "For each geoZone");
			for (GEOZONES geoZone : GEOZONES.values()) {
				int avg = buildDuration.getAvgBuild(geoZone.toString(), customerlist);
				System.out.println("The avg build duration " + avg + " for " + geoZone.toString());

			}
		} else
			System.out.println("No Customer Data Available to perform..!");
	}
}
