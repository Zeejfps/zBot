package com.zeejfps.zbot.ui;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import com.zeejfps.zbot.BotConstants;

public class Gui implements Runnable {

	private JFrame botWindow;
	private ContentPanel contentPanel;
	
	public Gui() {
		
		SwingUtilities.invokeLater(this);
		
	}
	
	@Override
	public void run() {
		
		createAndShowGui();
		
	}

	private void createAndShowGui() {
		
		botWindow = new JFrame(BotConstants.getName() + " " + BotConstants.getVersion());
		botWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		botWindow.setMenuBar(new BotMenuBar());
		
		contentPanel = new ContentPanel();
		botWindow.setContentPane(contentPanel);
		
		botWindow.pack();
		botWindow.setResizable(false);
		botWindow.setVisible(true);
		
	}
	
	public JFrame getBotWindow() {
		return botWindow;
	}
	
	public ContentPanel getContentPanel() {
		return contentPanel;
	}
	
	public JTextArea getLogger() {
		return contentPanel.getLogger();
	}
	
}//End Gui CLASS
