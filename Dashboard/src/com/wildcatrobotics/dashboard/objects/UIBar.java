package com.wildcatrobotics.dashboard.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class UIBar extends BasicUIObject{

	
	public UIBar(int x, int y, int w, int h){
		super(x,y,w,h);
		
		
	}
	public void setup(){
		draw(this.getGraphics());
		
	}
	public BasicUIObject setUpdater(int a){
		this.a = a;
		return this;
	}
	
	public void setValue(double d){
		value = d;
		draw(this.getGraphics());
	}

	public void draw(Graphics g) {
		this.repaint();
	}

	public void paintComponent(Graphics g) {
		Graphics2D canvas = (Graphics2D)g;
		canvas.setColor(Color.BLACK);
		super.paintComponent(g);
		
		
		
		double temp = (value / (max-min));
		temp = max/100 - temp;
		canvas.setColor(Color.green);
		canvas.fillRect(1,1,w-1,h-1);
		
		
		canvas.setColor(Color.black);
		
		canvas.clearRect(1, 1, w-1, (int)(h*temp) );
		canvas.setColor(Color.black);
		canvas.drawRect(0, 0, w,h);

		
	}
	
}
