package com.wildcatrobotics.dashboard.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Hashtable;

public class UILight extends BasicUIObject{

	
	
	
	Hashtable<Integer, Color>colors = new Hashtable<Integer, Color>();
	
	
	
	
	
	
	public UILight(int x, int y, int w, int h, String name) {
		super(x, y, w, h, name);
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void setColors(Hashtable<Integer, Color>ht){
		colors.putAll(ht);
	}
	
	
	
	public void paintComponent(Graphics g) {
		Graphics2D canvas = (Graphics2D)g;
		super.paintComponent(g);
		
		try{
			canvas.setColor(colors.get(new Integer((int)value)));	
		}
		catch(Exception e){
			canvas.setColor(Color.red);
		}
		canvas.fillRect(1,1,w-1,h-1);
		canvas.drawRect(0, 0, w,h);

	}
}
