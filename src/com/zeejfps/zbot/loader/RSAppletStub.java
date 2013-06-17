package com.zeejfps.zbot.loader;

import java.applet.AppletContext;
import java.applet.AppletStub;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.zeejfps.zbot.BotConstants;

public class RSAppletStub implements AppletStub {

	private static final Pattern PARAMETER_PATTERN = Pattern.compile("<param name=\"([^\\s]+)\"\\s+value=\"([^>]*)\">");
    private static final Pattern ARCHIVE_PATTERN = Pattern.compile("archive=(.*?)\\.jar");
    
	private final HashMap<String, String> parameters;
	
	
	public RSAppletStub() {
		parameters = getParametersFromURL(BotConstants.getBaseUrl());
	}
	
	@Override
	public void appletResize(int width, int height) {
		
	}

	@Override
	public AppletContext getAppletContext() {
		return null;
	}

	@Override
	public URL getCodeBase() {
		return BotConstants.getBaseUrl();
	}

	@Override
	public URL getDocumentBase() {
		return BotConstants.getBaseUrl();
	}

	@Override
	public String getParameter(String name) {
		return parameters.get(name);
	}

	@Override
	public boolean isActive() {
		return false;
	}
	
	/**
	 * This method will parse the Runescape URL passed to it and 
	 * will return a hash map that contains the parameters for the
	 * applet. Parameter with the name "archive" will return the gamepack
	 * name without the .jar at the end.
	 * 
	 * @param gameUrl The Base Runescape URL
	 * 
	 * @return HashMap the parameters hash map that holds the parameter name and value
	 */
	private static HashMap<String, String> getParametersFromURL(final URL gameUrl) {
		
		final HashMap<String, String> paramMap = new HashMap<String, String>();
		BufferedReader reader = null;
		
		try {
			
            String readLine; //Temp Variable
            
			reader = new BufferedReader(new InputStreamReader(gameUrl.openStream()));
			while((readLine = reader.readLine()) != null) {
				
				Matcher matcher;
				
				matcher = ARCHIVE_PATTERN.matcher(readLine);
				if (matcher.find()) {
					
					System.out.println("archive= " + matcher.group(1));
					paramMap.put("archive", matcher.group(1));
					
				} 
				
				matcher = PARAMETER_PATTERN.matcher(readLine);
				while(matcher.find()) {
					
					System.out.println("name= " + matcher.group(1) + " " + "value= " + matcher.group(2));
					paramMap.put(matcher.group(1), matcher.group(2));
					
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				
				if (reader != null) { reader.close();} //Makes sure the stream is closed even if it failes.
				
			} catch (IOException e) {
				e.printStackTrace();
			}	
		}		
		
		System.out.println("All parameters parsed!");
		return paramMap; //Returns the hashmap containing parameters.
		
	}//End getParameters() METHOD

}
