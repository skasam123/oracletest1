package com.oracle.aconex;

import java.util.List;

import com.oracle.aconex.constants.Appconstants;
import com.oracle.aconex.service.Customers;
import com.oracle.aconex.service.Report;
import com.oracle.aconex.vo.CustomerVO;


public class Application {

	public static void main(String[] args) {

		ReadFile readFile = new ReadFile();
		String dataString = readFile.readFile(Appconstants.DATA_FILE);

		Customers customers = new Customers();
		List<CustomerVO> customerlist = customers.getCustomers(dataString);

		Report report = new Report();
		report.report(customerlist);

	}
}
