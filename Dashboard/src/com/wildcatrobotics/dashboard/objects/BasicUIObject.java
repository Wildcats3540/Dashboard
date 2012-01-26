package com.wildcatrobotics.dashboard.objects;

import java.awt.Graphics;

import javax.swing.JPanel;

import com.wildcatrobotics.dashboard.functions.UpdateManager;
import com.wildcatrobotics.dashboard.net.DataManager;
import com.wildcatrobotics.dashboard.net.DataTypes;

public class BasicUIObject extends JPanel implements UIObject  {


	double value = 0,min=0,max=100;
	
	int a = DataTypes.NULL;
	
	int x,y,w,h;
	
	public BasicUIObject(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
		this.setBounds(x, y, w+1, h+1);
		setup();
		
	}
	
	public void setup(){
		UpdateManager.add(this);
	}
	
	public BasicUIObject setUpdater(int a){
		this.a = a;
		return this;
	}

	public void setValue(double d) {
		value = d;
		draw(this.getGraphics());
		
	}

	@Override
	public double getValue() {
		return value;
	}

	@Override
	public void draw(Graphics g) {

		this.repaint();
			
	}

	@Override
	public void setMax(double d) {
		max = d;
	}

	@Override
	public double getMax() {
		return max;
	}

	@Override
	public void setMin(double d) {
		min = d;
	}

	@Override
	public double getMin() {
		return min;
	}

	
	public void update(){
		if(a!=DataTypes.NULL)
		 setValue(DataManager.getNumber(a));
	}
	
	
}
