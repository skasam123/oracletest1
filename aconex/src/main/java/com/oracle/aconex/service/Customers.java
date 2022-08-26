package com.oracle.aconex.service;

import java.util.ArrayList;
import java.util.List;

import com.oracle.aconex.constants.Appconstants;
import com.oracle.aconex.validator.Validator;
import com.oracle.aconex.vo.CustomerVO;

public class Customers {

	/**
	 * Build the customers from the file string
	 * 
	 * @param str -customerdata string to parse
	 * @returns the List of customerData
	 */
	public List<CustomerVO> getCustomers(String str) {

		List<CustomerVO> customerList = new ArrayList<>();

		if (str != null && !str.isBlank() && !str.isEmpty()) {

			String[] lines = str.split(Appconstants.SPLIT_BY_NEW_LINE);
			Validator validator = new Validator();

			for (String line : lines) {
				String[] arr = line.split(Appconstants.SPLIT_BY_COMMA);
				if (validator.isValid(arr)) {
					CustomerVO customer = new CustomerVO();
					customer.setCustomerId(arr[0]);
					customer.setContractId(arr[1]);
					customer.setGeozone(arr[2]);
					customer.setTeamcode(arr[3]);
					customer.setProjectcode(arr[4]);
					customer.setBuildduration(arr[5]);
					customerList.add(customer);
				}
			}

		}
		return customerList;
	}
}
