package com.wildcatrobotics.dashboard.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UICamera extends BasicUIObject{


	boolean connected = false;
	JPanel cp = new JPanel();
	JTextField ip = new JTextField();
	JLabel l = new JLabel("<html><span style=\"font-size:15px\">Connecting...</font>");
	//l.setBounds(50,25,200,50);

	//ImageIcon icon = new ImageIcon(getClass().getResource("ajax-loader1.gif"),"");;
	// JLabel activity = new JLabel(icon);

	BufferedImage img = null;

	public UICamera(int x, int y, int w, int h, String name) {
		super(x, y, w, h, name);
		this.setLayout(null);
		cp.setBounds(w/2 - 150, h/2 - 75, 300,150);
		cp.setLayout(null);
		l.setBounds(70, 10, 200, 25);
		ip.setBounds(75, 50, 200, 25);
		ip.setText("");
		cp.add(ip);
		cp.add(l);
		this.add(cp);
		new CameraFeed().start();


	}


	public void paintComponent(Graphics g) {
		Graphics2D canvas = (Graphics2D)g;
		canvas.setColor(Color.gray);
		super.paintComponent(g);
		this.setBackground(Color.black);
		if(img!=null){
		/*	BufferedImage bimg = img;
			Graphics imgG = bimg.createGraphics();
			imgG.drawImage(img, 0, 0, w, h, this);*/
			canvas.drawImage(img,0,0,w,h,this);
		}
	}
	class CameraFeed extends Thread{
		public void run(){
			while(true){
				try{
					HttpURLConnection ul= (HttpURLConnection) new URL(ip.getText()).openConnection();
					BufferedImage i = ImageIO.read(new BufferedInputStream(ul.getInputStream()));
					img = i;
					if(cp.isVisible())
					cp.setVisible(false);
					repaint();
				}
				catch(Exception e){
					if(!cp.isVisible())
					cp.setVisible(true);
					repaint();
				}

			}
		}
	}
}
