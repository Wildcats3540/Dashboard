package com.wildcatrobotics.dashboard.objects;

import java.awt.Graphics;

import javax.swing.JTextField;

import com.wildcatrobotics.dashboard.functions.UpdateManager;
import com.wildcatrobotics.dashboard.net.DataManager;
import com.wildcatrobotics.dashboard.net.DataTypes;

public class UITextField  extends JTextField implements UIObject{

	double min=-1,max=1;
	String value = "";
	
	int a = DataTypes.NULL;
	
	int x,y,w,h;
	
	
	public UITextField(int x, int y, int w, int h) {
		
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		
		this.setBounds(x, y, w, h);

		
	}

	@Override
	public void setValue(double d) {
	}
	
	public void setValue(String s){
		value = s;
		this.setText(s); 
	}

	@Override
	public double getValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String getValuString(){
		return value;
	}
	
	public UITextField setUpdater(int a){
		this.a = a;
		UpdateManager.add(this);
		return this;
	}
	
	@Override
	public void setMax(double d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getMax() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setMin(double d) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public double getMin() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		setValue(DataManager.get(a).toString());
	}

}
