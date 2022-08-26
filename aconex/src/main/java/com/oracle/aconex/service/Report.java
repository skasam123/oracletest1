package com.oracle.aconex.service;

import java.util.List;

import com.oracle.aconex.vo.CustomerVO;

public class Report {

	/**
	 * TO Generate the Customized Report
	 * 
	 * @param customerlist - List of the customers Prints the Report of the
	 *                     customers
	 */
	public void report(List<CustomerVO> customerlist) {

		if (!customerlist.isEmpty()) {

			CustomersDataService customersData = new CustomersDataService();

			ContractCustomes contractCustomes = new ContractCustomes();
			contractCustomes.getCustomersByContractId(customersData, customerlist);

			GeoZoneCustomers geoZoneCustomers = new GeoZoneCustomers();
			geoZoneCustomers.getgeoZoneBuild(customersData, customerlist);

		} else
			System.out.println("No Customer Data Available to perform..!");
	}
}
