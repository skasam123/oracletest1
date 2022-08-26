package com.oracle.aconex.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.oracle.aconex.vo.CustomerVO;

public class CustomersDataService {

	/**
	 * To get the CustomerId's by each geoZone
	 * 
	 * @param geoZone
	 * @param list
	 * @return
	 */
	public Set<String> getCustomerIdsByGeoZone(String geoZone, List<CustomerVO> list) {

		return list.stream().filter(customer -> customer.getGeozone().equalsIgnoreCase(geoZone))
				.map(CustomerVO::getCustomerId).collect(Collectors.toSet());

	}

	/**
	 * To get the CustomerId's by each ContractId
	 * 
	 * @param contractID
	 * @param list
	 * @return
	 */
	public Set<String> getCustomerIdsByContractId(String contractID, List<CustomerVO> list) {

		return list.stream().filter(customer -> customer.getContractId().equalsIgnoreCase(contractID))
				.map(CustomerVO::getCustomerId).collect(Collectors.toSet());

	}
}
