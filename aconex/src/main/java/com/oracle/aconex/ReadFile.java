package com.oracle.aconex;

import java.io.File;
import java.net.URL;
import java.nio.file.Files;


public class ReadFile {

	
/*	Read the file and generate the String to parse*/
	
	public String readFile(String filePath) {
		String customerData = null;
		try {
			URL url = getClass().getResource(filePath);
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
