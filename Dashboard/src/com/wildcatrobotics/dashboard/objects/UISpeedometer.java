package com.wildcatrobotics.dashboard.objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class UISpeedometer extends BasicUIObject{

	double nh, centerX, centerY,r;
	
	public UISpeedometer(int x, int y,int r, String name){
		super(x,y,(r*2),(r), name);
	
		centerX = r;
		centerY = r;
		this.r  = r;
		max = 100;
		min = 0;
		
	}

	public void setValue(double d){
		value = d;
		draw(this.getGraphics());
	}


    Font font = new Font("times", Font.BOLD, 30);

    FontMetrics metrics = null;
	public void paintComponent(Graphics g) {
		metrics = g.getFontMetrics(font);
		Graphics2D canvas = (Graphics2D)g;
		canvas.setColor(Color.BLACK);
		super.paintComponent(g);

		canvas.drawOval(0,0, w,  (int) (r*2));
		canvas.drawLine(0, (int) r, w,h);


		for(double a = 0; a<=180; a+=10){

			double t1 = r - 10;
			double t2 = 0;
			if(a%15 == 0)
				t2 = r - 50;
			else
				t2 = r-30;
				
			double b = Math.toRadians(a);

			
			double sin = Math.sin(b);
			double cos  = Math.cos(b);
			
			double tx = cos * t1;
			double ty = sin * t1;
			double bx = cos * t2;
			double by = sin * t2;

			canvas.drawLine((int)(tx + r), (int)(centerY - ty)+1,(int) (bx+ r),(int)( centerY - by)+1);
			
			
			
		}

		double percent =  (value)/(max-min);
		
		double t3 = r - 10;
		double tempX = 180 - (180 * percent);
		double tempY = 180 - (180 * percent);
		
		
		tempX = Math.cos(Math.toRadians(tempX)) * t3;
		tempY = Math.sin(Math.toRadians(tempY)) * t3;
		

		canvas.setColor(Color.red);
		canvas.drawLine((int)r, (int)r-5, (int) ((int)tempX + r),(int) (centerY - tempY));
		
		
        int val = (int)getValue();

        canvas.setFont(font);
        
        
        int adv = metrics.stringWidth(val+"");

        int tx = this.getWidth();
        int xPos = (tx / 2 - adv / 2);
        
        
		canvas.drawString(val+"",(float) xPos,(float) r-30);
		

	}

	/*private void drawRadius(Graphics2D g2, double percent,
			int minRadius, int maxRadius) {
		//... percent parameter is the fraction (0.0 - 1.0) of the way
		//    clockwise from 12.   Because the Graphics2D methods use radians
		//    counterclockwise from 3, a little conversion is necessary.
		//    It took a little experimentation to get this right.
		double radians = (0.5 - percent) * TWO_PI;
		double sine   = Math.sin(radians);
		double cosine = Math.cos(radians);

		int dxmin = centerX + (int)(minRadius * sine);
		int dymin = centerY + (int)(minRadius * cosine);

		int dxmax = centerX + (int)(maxRadius * sine);
		int dymax = centerY + (int)(maxRadius * cosine);
		g2.drawLine(dxmin, dymin, dxmax, dymax);
	}*/
}