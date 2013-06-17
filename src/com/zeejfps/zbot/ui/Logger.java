package com.zeejfps.zbot.ui;

import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Logger extends JTextArea {

	public Logger() {
		
		setEditable(false);
		
	}
	
	public void log(String str) {
		
		append(str + "\n");
		
	}
	
}
