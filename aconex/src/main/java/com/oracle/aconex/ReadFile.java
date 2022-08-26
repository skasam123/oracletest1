package com.oracle.aconex;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;


public class ReadFile {

	/**
	 * Read the file and generate the String to parse
	 * 
	 * @param filePath - path of the file
	 * @returns the customer data string
	 */
	public String readFile(String filePath) {
		String customerData = null;
		try {
//			URL url = getClass().getResource(filePath);
			URL url = getClass().getClassLoader().getResource("CustomersData.txt");
			if (url != null) {
				File file = new File(url.getPath());
				customerData = Files.readString(file.toPath());
			} else {
				System.out.println("File is unavailable...!");
				return customerData;
			}
		} catch (Exception e) {
			System.out.println("File is unavailable..!");
			return customerData;
		}
		return customerData;
	}
}
