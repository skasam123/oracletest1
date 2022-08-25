package com.oracle.aconex;

import java.util.List;

import com.oracle.aconex.constants.Appconstants;
import com.oracle.aconex.service.Customers;
import com.oracle.aconex.service.Report;
import com.oracle.aconex.vo.CustomerVO;

/* Generating the File from the path and passing the 
 * Customer's List to generate the Report
  */

public class Application {
//	  private static final Logger logger = LogManager.getLogger(Application.class);  

	public static void main(String[] args) {
//		BasicConfigurator.configure();

		
		
		ReadFile readFile = new ReadFile();
		String dataString = readFile.readFile(Appconstants.ORACLE_TEST);
		
		Customers customers = new Customers();
		List<CustomerVO> customerlist = customers.getCustomers(dataString);
		
		Report report = new Report();
		report.report(customerlist);

	}
}
