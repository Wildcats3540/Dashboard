package com.wildcatrobotics.dashboard.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class UI2DAxisPosition extends BasicUIObject{ 
	double AxisX = 0;
	double AxisY = 0;
	double XMax = 0;
	double XMin = 0;
	double YMax = 0;
	double YMin = 0;
	
	public UI2DAxisPosition(int x, int y, int w, int h) {
		super(x, y, w, h);
	}
	
	public void setValue(double AxisX, double AxisY){
		this.AxisX = AxisX;
		this.AxisY = AxisY;
		draw(this.getGraphics());
	}

	public double getXMax() {return XMax;}
	public double getXMin() {return XMin;}
	public double getYMax() {return YMax;}
	public double getYMin() {return YMin;}	

	public void setXMax(double xMax) {XMax = xMax;}
	public void setXMin(double xMin) {XMin = xMin;}
	public void setYMax(double yMax) {YMax = yMax;}
	public void setYMin(double yMin) {YMin = yMin;}

	public void paintComponent(Graphics g) {
		Graphics2D canvas = (Graphics2D)g;
		canvas.setColor(Color.BLACK);
		super.paintComponent(g);
		
		canvas.drawRect(0, 0, w,h);
		//canvas.drawRect(((w/2)-5), ((h/2)-5), 10, 10);
		canvas.drawLine(((w/2)-5), (h/2), ((w/2)+5), (h/2));
		canvas.drawLine((w/2), ((h/2)-5), (w/2), ((h/2)+5));
		
		double xPercent = AxisX / (getXMax()- getXMin());
		int xLoc = w * (int)xPercent;
		double yPercent = AxisY / (getYMax()- getYMin());
		int yLoc = h * (int)yPercent;
		
		canvas.drawLine((xLoc-5), yLoc, (xLoc+5), yLoc);
		canvas.drawLine(xLoc, (yLoc-5), xLoc, (yLoc+5));
	}
}