package com.wildcatrobotics.dashboard.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class UICamera extends BasicUIObject{

	public UICamera(int x, int y, int w, int h, String name) {
		super(x, y, w, h, name);
	}
	
	
	public void paintComponent(Graphics g) {
		Graphics2D canvas = (Graphics2D)g;
		canvas.setColor(Color.BLACK);
		super.paintComponent(g);
		
	
		//if()
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	BufferedImage img;
	class CameraFeed extends Thread{
		public void run(){
			while(true){
			}
			
			
			
			
			
		}
	}

	
	
	
}
