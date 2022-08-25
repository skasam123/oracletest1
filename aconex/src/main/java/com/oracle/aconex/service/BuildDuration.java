package com.oracle.aconex.service;

import java.util.List;
import java.util.ListIterator;

import com.oracle.aconex.vo.CustomerVO;

public class BuildDuration {

	
	/*To get the Avg Build based on the input string*/
	public int getAvgBuild(String s, List<CustomerVO> list) {
		
		int avg = 0;
		int count = 0;

		ListIterator<CustomerVO> iterator = list.listIterator();
		
		while (iterator.hasNext()) {
			CustomerVO team = iterator.next();
			if (s.equalsIgnoreCase(team.getGeozone())) {
				count++;
				avg = ((team.getBuildduration()) + avg);
			}
		}
		
		if (count > 0)
			avg = avg / count;

		return avg;
	}

}
