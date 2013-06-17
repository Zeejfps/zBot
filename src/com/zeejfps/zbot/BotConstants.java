package com.zeejfps.zbot;

import java.net.MalformedURLException;
import java.net.URL;

public class BotConstants {

	private static final String BASE_LINK = "http://oldschool45.runescape.com/";
	private static final String NAME = "zBot";
	private static final double VERSION = 0.1;
	
	public static URL getBaseUrl() {
		
		URL url = null;
		
		try {
			url = new URL(BASE_LINK);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return url;
	}
	
	public static String getBaseLink() {
		return BASE_LINK;
	}
	
	public static String getName() {
		return NAME;
	}
	
	public static double getVersion() {
		return VERSION;
	}
	
}
