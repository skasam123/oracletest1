package com.oracle.aconex.validator;

import com.oracle.aconex.constants.Appconstants;
import com.oracle.aconex.vo.GeoZonesVO.GEOZONES;

public class Validator {

	public boolean isValid(String[] arr) {
		return (geoZoneValidator(arr) && customerIdValidator(arr) && projectCode(arr) && buildDuration(arr));
	}
	
	/*GeoZone Validator*/
	private boolean geoZoneValidator(String[] arr) {
		for (GEOZONES geoZone : GEOZONES.values()) {
			if (arr[2] != null && geoZone.name().equalsIgnoreCase(arr[2])) {
				return true;
			}
		}
		return false;

	}	
	
	/*CustomerId Validator*/
	private boolean customerIdValidator(String[] arr) {
		String customerId = arr[0];
		if (customerId == null || customerId.isEmpty() || customerId.length() != 7)
			return false;
		try {
			Double.parseDouble(customerId);
		} catch (NumberFormatException exception) {
			return false;
		}
		return true;
	}
	
	/*projectCode Validator*/
	private boolean projectCode(String[] arr) {
		String projectCode = arr[4];
		if (projectCode == null || projectCode.isEmpty()) {
			return false;
		}else if(projectCode.startsWith(Appconstants.PROJECT)) {
			return true;
		}
		return false;
	}
	
	
	/*buildDuration Validator*/
	private boolean buildDuration(String[] arr) {
		String duration = arr[5];
		if (duration == null || duration.isEmpty()) {
			return false;
		}
		duration = duration.replace("s", "").trim();
		try {
			Double.parseDouble(duration);
		} catch (NumberFormatException exception) {
			return false;
		}
		return true;
	}
	
	
}
