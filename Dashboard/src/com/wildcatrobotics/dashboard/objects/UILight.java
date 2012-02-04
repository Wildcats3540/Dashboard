package com.wildcatrobotics.dashboard.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class UILight extends BasicUIObject{

	public UILight(int x, int y, int w, int h, String name) {
		super(x, y, w, h, name);
		// TODO Auto-generated constructor stub
	}
	
	public BasicUIObject setUpdater(int a){
		this.a = a;
		return this;
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D canvas = (Graphics2D)g;
		canvas.setColor(Color.RED);
		super.paintComponent(g);
		
		if(value==1) canvas.setColor(Color.GREEN);
			
		canvas.fillRect(1,1,w-1,h-1);
		canvas.setColor(Color.BLACK);
		canvas.drawRect(0, 0, w,h);

	}
}
