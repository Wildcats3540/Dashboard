package com.wildcatrobotics.dashboard.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class UI2DAxisPosition extends BasicUIObject{ 
	double AxisX = 0;
	double AxisY = 0;
	public UI2DAxisPosition(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public void setValue(double AxisX, double AxisY){
		this.AxisX = AxisX;
		this.AxisY = AxisY;
		draw(this.getGraphics());
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D canvas = (Graphics2D)g;
		canvas.setColor(Color.BLACK);
		super.paintComponent(g);
		
		canvas.drawRect(0, 0, w,h);
		//canvas.drawRect(((w/2)-5), ((h/2)-5), 10, 10);
		canvas.drawLine(((w/2)-5), (h/2), ((w/2)+5), (h/2));
		canvas.drawLine((w/2), ((h/2)-5), (w/2), ((h/2)+5));
	}
}