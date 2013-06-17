package com.zeejfps.zbot.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
class ContentPanel extends JPanel {

	private GamePanel gamePanel;
	private Logger logger;
	
	public ContentPanel() {
		
		super(new BorderLayout());
		
		gamePanel = new GamePanel();		
		add(gamePanel, BorderLayout.NORTH);
		
		logger = new Logger();
				
		logger.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		logger.setEditable(false);
		
		JScrollPane scrollPane = new JScrollPane(logger, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBorder(BorderFactory.createTitledBorder("Logger:"));
		
		add(scrollPane, BorderLayout.CENTER);
		
		
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(765, 653);
	}
	
	public GamePanel getGamePanel() {
		return gamePanel;
	}
	
	public Logger getLogger() {
		return logger;
	}
	
}
