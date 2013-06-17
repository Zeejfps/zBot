package com.zeejfps.zbot.loader;

import java.applet.Applet;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.concurrent.ExecutionException;

import javax.swing.JPanel;
import javax.swing.SwingWorker;

import com.zeejfps.zbot.BotConstants;

/**
 * This class is responsible for loading the Runescape
 * Applet and then placing it onto a panel in the Gui;
 * 
 * @author zeejfps
 */
public class RSLoader extends SwingWorker<Applet, String>{

	private RSAppletStub appletStub; //AppletStub that contains the parameters
	private final JPanel gamePanel; //The Panel to add the Applet to.
	
	/**
	 * The constructor takes in a JPanel that it will place
	 * the Applet onto.
	 * 
	 * @param gamePanel Panel to add the applet to.
	 */
	public RSLoader(JPanel gamePanel) {
		
		this.gamePanel = gamePanel;
		
	}
	
	/**
	 * This method runs on a working thread and creates
	 * the AppletStub that loads all of the parameters.
	 * Then the method loads the client class and starts the applet.
	 */
	@Override
	protected Applet doInBackground() throws Exception {
		
		publish("Parseing Parameters...");
		
		appletStub = new RSAppletStub();
		Applet rsApplet = null;
		
		setProgress(10);
		publish("All Parameters Parsed!");
		
		URLClassLoader classLoader = createClassLoader();
		
		try {
			publish("Loading client...");
			rsApplet = (Applet)classLoader.loadClass("client").newInstance();
			setProgress(50);
			
			publish("Setting Stub...");
			rsApplet.setStub(appletStub);
			setProgress(60);
			
			publish("Initializing Applet");
			rsApplet.init();
			setProgress(70);
			
			publish("Starting Applet...");
			rsApplet.start();
			setProgress(100);
			
			publish("Applet Started!");
			
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return rsApplet;
	}
	
	/**
	 * Activated when the doInBackground is complete.
	 * This method removes the loading screen from the JPanel
	 * and adds the game Applet to it.
	 * 
	 * @see javax.swing.SwingWorker#done()
	 */
	@Override
	public void done() {
		
		try {
			gamePanel.setCursor(null);
			gamePanel.removeAll();
			gamePanel.add(get());
			gamePanel.revalidate();
			gamePanel.repaint();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Creates the class loader, used to load
	 * the client class.
	 * 
	 * @return URLClassLoader
	 */
	private URLClassLoader createClassLoader() {
		
		publish("Creating class loader...");
		String archive = BotConstants.getBaseLink() + appletStub.getParameter("archive") + ".jar";
		System.out.println("archive= " + archive);
		URLClassLoader ucl = null;
		
		try {
			ucl = new URLClassLoader(new URL[]{new URL(archive)}, getClass().getClassLoader());
			setProgress(15);
			publish("Class loader created!");
			return ucl;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		
		return ucl;
	}
	
	public RSAppletStub getAppletStub() {
		return appletStub;
	}
}
