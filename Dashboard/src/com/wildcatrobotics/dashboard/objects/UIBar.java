package com.wildcatrobotics.dashboard.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class UIBar extends BasicUIObject{

	
	Color mainColor = Color.green;
	
	public UIBar(int x, int y, int w, int h, String name){
		super(x,y,w,h, name);
		
		
	}
	public BasicUIObject setMainColor(Color c){
		mainColor = c;
		return this;
	}
	public void setValue(double d){
		value = d;
		draw(this.getGraphics());
	}

	public void paintComponent(Graphics g) {
		Graphics2D canvas = (Graphics2D)g;
		canvas.setColor(Color.BLACK);
		super.paintComponent(g);
		
		double df0 = 0-min;
		//double temp = ((-value)+((max-min)/2)/(max-min));
		double temp = (value+df0) / ((max+df0)-(min+df0));
		temp =h- (h *temp  );
		
		canvas.setColor(mainColor);
		canvas.fillRect(0,0,w,h);
		canvas.setColor(secondaryColor);
		canvas.clearRect(1, 1, w-1, (int) (temp));
		canvas.drawRect(0, 0, w,h);

		
	}
	
}
