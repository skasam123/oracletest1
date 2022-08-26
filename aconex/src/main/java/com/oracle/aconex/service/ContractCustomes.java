package com.oracle.aconex.service;

import java.util.List;
import java.util.Set;

import com.oracle.aconex.constants.Appconstants;
import com.oracle.aconex.vo.CustomerVO;

public class ContractCustomes {

	public void getCustomersByContractId(CustomersDataService customersData, List<CustomerVO> customerlist) {

		ContractIDs contractIDs = new ContractIDs();
		Set<String> contractIds = contractIDs.getContractsIDs(customerlist);

		System.out.println(Appconstants.NO_OF_CUSTOMERID + "Each contract ID");
		for (String contractId : contractIds) {
			Set<String> res = customersData.getCustomerIdsByContractId(contractId, customerlist);
			System.out.println(Appconstants.NO_OF_CUSTOMERID + contractId + " are: " + res.size());
		}

	}

}
