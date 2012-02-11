package com.wildcatrobotics.dashboard.objects;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.wildcatrobotics.dashboard.functions.UpdateManager;
import com.wildcatrobotics.dashboard.net.DataManager;
import com.wildcatrobotics.dashboard.net.DataTypes;
import com.wildcatrobotics.dashboard.net.NetManager;

public class BasicUIObject extends JPanel implements UIObject  {


	double value = 0,min=-1,max=1;
	
	int a = DataTypes.NULL;
	
	int x,y,w,h;
	
	String name = "";
	
	Color mainColor = Color.black, secondaryColor = Color.black;
	
	public BasicUIObject(int x, int y, int w, int h, String name){
		this.x = x;
		this.y = y;
		this.h = h;
		this.w = w;
		this.name = name;
		this.setBounds(x, y, w+1, h+1);

		setup();
		
	}
	
	
	
	public void setup(){
		//UpdateManager.add(this);
		//try{Thread.sleep(1000);}catch(Exception e){}
		new Fade().start();

	}
	
	/**
	 * Sets the key for the updater. Keys are defined in com.wildcatrobotics.dashboard.net.DataTypes 
	 * <Br>
	 * This method automatically adds this object to the update manager and will set the value when new updates from the netmanager are available.
	 * <br>
	 * Returns a instance of this class so this method can be "chained" onto the constructor
	 * @param Key
	 * @return Instance of BasicUIObject
	 */
	public BasicUIObject setUpdater(int s){
		this.a = s;
		UpdateManager.add(this);
		//System.out.println("SET TOADSFADSFSADFADSF" + a);
		return this;
	}
	/**
	 * Sets the value of the object. If the value is outside the bounds determined by <b>getMax()</b> or <b>getMin()</b> 
	 * the display will overflow outside of the bounds and likely not be displayed.
	 * 
	 * If <b>setUpdater()</b> has been set then the value of this object will be automatically handled by the update manager
	 * 
	 * @param double value to set the object
	 */
	public void setValue(double d) {
		value = d;
		draw(this.getGraphics());
	}

	/**
	 * returns the value that the object is currently set as
	 * 
	 * @return double, the value of the object
	 */
	@Override
	public double getValue() {
		return value;
	}
	
	/**
	 * Sets the value for the Main paint color. This method returns a instance of this class so it can be "chained" onto the constructor.
	 * @param Color
	 * @return and instance of BasicUIObject
	 */
	public BasicUIObject setMainColor(Color c){
		mainColor = c;
		return this;
	}
	/**
	 * Sets the color for the secondary paint color. This method returns a instance of this class so it can be "chained" onto the constructor.
	 * @param Color
	 * @return and instance of BasicUIObject
	 */
	public BasicUIObject setSecondColor(Color c){
		secondaryColor = c;
		return this;
	}
	
	/**
	 * used internaly to paint the name of this object
	 * @param g
	 */
	public void drawName(Graphics g){
		if(g!=null && name != null)
		g.drawString(name,2 , 11);
		
	}
	
	/**
	 * Starts the draw process of this object. This method should not be called directly
	 */
	public void draw(Graphics g) {
		this.repaint();
	}

	/**
	 * Sets the max value for this object
	 */
	public void setMax(double d) {
		max = d;
	}

	/**
	 * returns the max value for this object
	 */
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


	/**
	 * Called by the Updatemanager when updates are avaliable. Should not be called directly
	 */
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
				if(NetManager.isConnected())
					break;
				setValue(a);
				try{sleep((long) (b));}catch(Exception e){}
				b = b * 1.05;
			}
		}
	}
	
}
