package com.zeejfps.zbot.ui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
class ContentPanel extends JPanel {

	private JTabbedPane tabPane;
	private Logger logger;
	
	public ContentPanel() {
		
		super(new BorderLayout());
		
		logger = new Logger();
		tabPane = new JTabbedPane();
		
			JPanel homeTab = new JPanel(new BorderLayout());
			homeTab.setPreferredSize(new Dimension(765, 503));
			
			JLabel homeLabel = new JLabel("This is the home screen");
			homeLabel.setVerticalAlignment(JLabel.CENTER);
			homeLabel.setHorizontalAlignment(JLabel.CENTER);
			
			homeTab.add(homeLabel, BorderLayout.CENTER);
			
		tabPane.addTab("Home Tab", homeTab);
		tabPane.addTab("Client", new GameTab());
		
		add(tabPane, BorderLayout.PAGE_START);
		
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
	
	public JTabbedPane getTabPane() {
		return tabPane;
	}
	
	public Logger getLogger() {
		return logger;
	}
	
}
