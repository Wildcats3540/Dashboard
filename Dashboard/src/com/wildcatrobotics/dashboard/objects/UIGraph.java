package com.wildcatrobotics.dashboard.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.wildcatrobotics.dashboard.net.DataManager;
import com.wildcatrobotics.dashboard.net.DataTypes;

public class UIGraph extends BasicUIObject{
	
	private int dataCount;
	private ArrayList<Double> data = new ArrayList<Double>();
	private boolean fill = false;
	public UIGraph(int x, int y,int w, int h, String name){
		super(x,y,w,h,name);
		dataCount = 100;
		
	}
	public UIGraph(int x, int y,int w, int h,String name, int dataCount){
		super(x,y,w,h,name);
		this.dataCount = dataCount;
		
	}
	

	public void setup(){
	}
	public void addData(double d){
		if(data.size()>=dataCount){
			data.remove(0);
		}
		data.add(new Double(d));
		draw(this.getGraphics());
	}
	
	public void setFilled(boolean f){
		fill = f;
	}

	public void setValue(double d){
		value = d;
		draw(this.getGraphics());
	}

	public void paintComponent(Graphics g) {
		Graphics2D canvas = (Graphics2D)g;
		canvas.setColor(Color.BLACK);
		super.paintComponent(g);
		
		canvas.drawRect(0, 0, w, h);
		
		if(!fill){
			int index = 0;
			final int inc = w / dataCount;
			
			for(int a = 0; a<data.size()-1;a++){
				canvas.drawLine(index, getGraphY(data.get(a)), index+inc, getGraphY(data.get(a+1)) );
				index += inc;
			}
		}
		drawName(g);
		
	}
	
	public int getGraphY(Double y){
		double df0 = 0-min;
		//double temp = ((-value)+((max-min)/2)/(max-min));
		double temp = (y+df0) / ((max+df0)-(min+df0));
		temp = h - (h * temp);
		return ((int) (temp));
		
	}
	
	
	public void update(){
	//	if(a!=DataTypes.NULL){
			double b = DataManager.getNumber(a);
			addData(b);
	 //System.out.println(b);
		//}
		
	}
	
	
	
}
