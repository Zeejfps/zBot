package com.zeejfps.zbot.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.zeejfps.zbot.loader.RSLoader;

@SuppressWarnings("serial")
class GamePanel extends JPanel {

	private final RSLoader loader;

	public GamePanel() {
		super(new BorderLayout());
		
		setBackground(Color.BLACK);
		
		ImageIcon img = getImage();
		
		JLabel loadingImage = new JLabel();
		loadingImage.setIcon(img);
		loadingImage.setHorizontalAlignment(JLabel.CENTER);
		loadingImage.setVerticalAlignment(JLabel.CENTER);
		
		add(loadingImage, BorderLayout.CENTER);

		loader = new RSLoader(this);
		loader.execute();
	}
	
	
	private ImageIcon getImage() {
		
		try {
			
			URL imageUrl = new URL("http://www.runescape.com/img/rsp777/oldschool_ani.gif");
			return new ImageIcon(imageUrl);
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public Dimension getPreferredSize() {
		return new Dimension(765, 503);
	}
	
}
