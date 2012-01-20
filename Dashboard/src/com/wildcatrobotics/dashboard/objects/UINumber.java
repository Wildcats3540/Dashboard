package com.wildcatrobotics.dashboard.objects;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class UINumber extends BasicUIObject {

	private int tSize = 30;
	private boolean isInt;
	
	public UINumber(int x, int y, int w, int h) {
		super(x, y, w, h);
		
	}

	
	public void setIsInt(boolean b){
		isInt = b;
	}
	


	
	public void paintComponent(Graphics g){

		Graphics2D canvas = (Graphics2D)g;
		canvas.setColor(Color.BLACK);
		super.paintComponent(g);
		
		
        Font font = new Font("times", Font.BOLD, tSize);

        canvas.setFont(font);
        
        double val = 0;
        
        
        if(isInt){
        	val = (int)getValue();
        }
        else{
        	val = getValue();
        }
        
        FontMetrics metrics = g.getFontMetrics(font);

        int hgt = metrics.getHeight();
        int adv = metrics.stringWidth(val+"");

        this.setSize(adv +30, hgt +10);
        int x = this.getWidth();
        int h = this.getHeight();
        g.setFont(font);
        int xPos = (x / 2 - adv / 2);
        int hPos = (h/2 - hgt  / 2) + 15;
        if (xPos < 1)
            xPos = 1;
        
        canvas.setColor(Color.black);
        canvas.drawString(val+"", xPos,0);
        System.out.println(val);
        
	}
	
	
}
