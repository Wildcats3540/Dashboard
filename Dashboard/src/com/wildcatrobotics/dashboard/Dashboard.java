package com.wildcatrobotics.dashboard;

import java.awt.Color;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.wildcatrobotics.dashboard.net.DataTypes;
import com.wildcatrobotics.dashboard.net.NetManager;
import com.wildcatrobotics.dashboard.objects.UI2DAxisPosition;
import com.wildcatrobotics.dashboard.objects.UIBar;
import com.wildcatrobotics.dashboard.objects.UIColorChanger;
import com.wildcatrobotics.dashboard.objects.UIGraph;
import com.wildcatrobotics.dashboard.objects.UISpeedometer;
import com.wildcatrobotics.dashboard.objects.UITextField;
import com.wildcatrobotics.dashboard.sockettest.Ping;
import com.wildcatrobotics.dashboard.util.NetworkConversionHelper;

public class Dashboard {

	JFrame f = new JFrame("Dashboard");
	JPanel p = new JPanel();
	JPanel cameraT = new JPanel();
	
	public static final String ip = "10.35.40.2";
	public static final int port = 7777;
	
	public static double data = 0;
	public static void main(String args[]){
		new Dashboard().start();
	}
	
private int z = 0;
	public void start(){
		new NetManager().start();
		f.setSize(1024, 710);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(p);
		
		
		setup();
		
		f.setVisible(true);
		/*while(true){
			if (z>0)
			{
		
			accelly.addData(1);
			}
			else
			{
			accelly.addData(-1);
			}
			if (z== 10)
			z = -10;
			z++;
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		}

	

	public void setup(){
		UIBar throttle1 = (UIBar) new UIBar(700,50,5,100).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS3).setMainColor(Color.orange);
		UIBar throttle2 = (UIBar) new UIBar(720,50,5,100).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS3).setMainColor(Color.orange);
		UIBar speed1    = (UIBar) new UIBar(675,50,25,100).setUpdater(DataTypes.DATA_DIGITAL_1);
		UIBar speed2    = (UIBar) new UIBar(726,50,25,100).setUpdater(DataTypes.DATA_DIGITAL_2);
		UITextField tf1 = new UITextField(800,300,200,25).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS3);
		UIGraph accelly = (UIGraph) new UIGraph(300,500,400,100).setUpdater(DataTypes.DATA_DIGITAL_1);

		UITextField tf2 = new UITextField(800,350,200,25);
		accelly.setMax(4);
	    accelly.setMin(-4);
		
		   
		f.add(throttle2);
		f.add(throttle1);
		f.add(speed2);
		f.add(speed1);
		f.add(tf1);
		f.add(accelly);
		f.add(tf2);
		
		
		
		
		f.add(new JPanel());
		
	}
	
	
}
