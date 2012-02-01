package com.wildcatrobotics.dashboard.objects;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.wildcatrobotics.dashboard.functions.UpdateManager;
import com.wildcatrobotics.dashboard.net.DataManager;
import com.wildcatrobotics.dashboard.net.DataTypes;

public class BasicUIObject extends JPanel implements UIObject  {


	double value = 0,min=-1,max=1;
	
	int a = DataTypes.NULL;
	
	int x,y,w,h;
	
	Color mainColor = Color.black, secondaryColor = Color.black;
	
	public BasicUIObject(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
		this.setBounds(x, y, w+1, h+1);

		setup();
		
	}
	
	public void setup(){
		//UpdateManager.add(this);
		//try{Thread.sleep(1000);}catch(Exception e){}
		new Fade().start();

	}
	
	public BasicUIObject setUpdater(int s){
		this.a = s;
		UpdateManager.add(this);
		//System.out.println("SET TOADSFADSFSADFADSF" + a);
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
	
	public BasicUIObject setMainColor(Color c){
		mainColor = c;
		return this;
	}
	
	public BasicUIObject setSecondColor(Color c){
		secondaryColor = c;
		return this;
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
	//	if(a!=DataTypes.NULL){
			double b = DataManager.getNumber(a);
			setValue(b);
	 //System.out.println(b);
		//}
		
	}
	
	class Fade extends Thread{
		public void run(){
			double inc = (max-min)/100;
			double b = 1.7;
			for(double a = max; a>=min; a-=inc){
				setValue(a);
				try{sleep((long) (b));}catch(Exception e){}
				b = b * 1.05;
			}
		}
	}
	
}
