package com.zeejfps.zbot.ui;

import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

@SuppressWarnings("serial")
class BotMenuBar extends MenuBar {
	
	private Menu scriptsMenu;
	private Menu debugMenu;
	
	public BotMenuBar() {
		
		scriptsMenu = new Menu("Scripts");
		
			MenuItem item1 = new MenuItem("item1");
			scriptsMenu.add(item1);
			
			MenuItem item2 = new MenuItem("item2");
			scriptsMenu.add(item2);
			
			MenuItem item3 = new MenuItem("item3");
			scriptsMenu.add(item3);
			
			MenuItem item4 = new MenuItem("item4");
			scriptsMenu.add(item4);
		
		debugMenu = new Menu("Debug");
		
			MenuItem item5 = new MenuItem("item5");
			debugMenu.add(item5);
			
			MenuItem item6 = new MenuItem("item6");
			debugMenu.add(item6);
			
			MenuItem item7 = new MenuItem("item7");
			debugMenu.add(item7);
			
			MenuItem item8 = new MenuItem("item8");
			debugMenu.add(item8);
			
		add(scriptsMenu);
		add(debugMenu);
	}
	
	public Menu getScriptsMenu() {
		return scriptsMenu;
	}
	
	public Menu getDebugMenu() {
		return debugMenu;
	}

}
