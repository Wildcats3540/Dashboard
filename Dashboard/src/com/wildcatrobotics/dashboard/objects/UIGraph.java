package com.wildcatrobotics.dashboard.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class UIGraph extends BasicUIObject{
	
	private int dataCount;
	private ArrayList<Double> data = new ArrayList<Double>();
	private boolean fill = false;
	public UIGraph(int x, int y,int w, int h){
		super(x,y,w,h);
		dataCount = 100;
		
	}
	public UIGraph(int x, int y,int w, int h, int dataCount){
		super(x,y,w,h);
		this.dataCount = dataCount;
		
	}
	public void setup(){
		draw(this.getGraphics());

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

	public void draw(Graphics g) {
		this.repaint();
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
				//System.out.println("DRAWING");
				canvas.drawLine(index, getGraphY(data.get(a)), index+inc, getGraphY(data.get(a+1)) );
				index += inc;
			}
		}
		
	}
	
	public int getGraphY(Double y){
		double temp = (y.doubleValue()) / (getMax()-getMin());
		//System.out.println("O:"+temp);

		temp = h*temp;
		temp = h - temp;
		//System.out.println(temp);
		return (int)temp;
		
	}
}
