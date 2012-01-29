package com.wildcatrobotics.dashboard;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

public class LoadingOverlay extends JPanel{
	
	int x,y,h,w;
	boolean drawOnce = false;
	public LoadingOverlay(int x,int y, int w, int h){
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
		this.setOpaque(false);
		this.setBounds(x,y,w,h);
	}
	
	
	
	
	
	public void paintComponent(Graphics g) {
		//if(!drawOnce){
		Graphics2D canvas = (Graphics2D)g;
		canvas.setColor(new Color(255,255,255,200));
		super.paintComponent(g);
		canvas.fillRect(0, 0,w,h);    
		canvas.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		int b = 1;
		for(int a =30; a>0;a--){
		canvas.setColor(new Color(0,0,0,1));
		canvas.fillRoundRect((w/2)-200-a/2, (h/2)-75-a/2, 400+a, 150+a, 20, 20);
		b= b +5;
		}
		canvas.setColor(Color.white);
		canvas.fillRoundRect((w/2)-200, (h/2)-75, 400, 150, 20, 20);
	

		
		
		
		System.out.print(w);
		drawOnce = true;
	
		
	
		
	//	}
	
	
	}
}
