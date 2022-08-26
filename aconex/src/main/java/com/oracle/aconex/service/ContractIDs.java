package com.oracle.aconex.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.oracle.aconex.vo.CustomerVO;

public class ContractIDs {

	/**
	 * To get the contractId's
	 * 
	 * @param list of customers
	 * @return the set of ContractId's
	 */
	public Set<String> getContractsIDs(List<CustomerVO> list) {
		return list.stream().map(CustomerVO::getContractId).collect(Collectors.toSet());
	}
}
