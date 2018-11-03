package com.srl.srlbi.service;

import java.text.DecimalFormat;

public class Utilities {
	
	public static String format(double value) {
	    if (value < 0) {
	    	return "(-) "+format(-1*value);
	    } 
	    else if(value < 1000) {
	        return "Rs. "+format("###.00", value);
	    } else {
	        double hundreds = value % 1000;
	        int other = (int) (value / 1000);
	        return "Rs. "+format(",##", other) + ',' + format("000.00", hundreds);
	    }
	}

	private static String format(String pattern, Object value) {
	    return new DecimalFormat(pattern).format(value);
	}

}
