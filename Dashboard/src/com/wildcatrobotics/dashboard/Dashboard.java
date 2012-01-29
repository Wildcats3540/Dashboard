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
import com.wildcatrobotics.dashboard.objects.UIDial;
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

		p.setLayout(null);
		p.setBounds(0, 0, f.getWidth(), f.getHeight());
		
		setup();
		f.add(p);
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
		UIBar throttle1 = (UIBar) new UIBar(700,50,5,150).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS3).setMainColor(Color.orange);
		UIBar throttle2 = (UIBar) new UIBar(720,50,5,150).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS3).setMainColor(Color.orange);
		UIBar speed1    = (UIBar) new UIBar(675,50,25,150).setUpdater(DataTypes.DATA_DIGITAL_1);
		UIBar speed2    = (UIBar) new UIBar(726,50,25,150).setUpdater(DataTypes.DATA_DIGITAL_2);
		UITextField tf1 = new UITextField(800,100,200,25).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS3);
		UITextField tf2 = new UITextField(800,140,200,25).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS3);
		UITextField tf3 = new UITextField(800,180,200,25).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS3);
		UITextField tf4 = new UITextField(800,220,200,25).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS3);
		UITextField tf5 = new UITextField(800,260,200,25).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS3);
		UITextField tf6 = new UITextField(800,300,200,25).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS3);
		

		
		UIGraph accelly = (UIGraph) new UIGraph(300,500,400,100).setUpdater(DataTypes.DATA_DIGITAL_1);
		UISpeedometer spd = (UISpeedometer) new UISpeedometer(300,50,150).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS1);
		UIDial dial1 = (UIDial) new UIDial(300, 210, 150).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS1);
		
		
		accelly.setMax(4);
	    accelly.setMin(-4);
		
	    throttle1.setMax(1);
	    throttle1.setMin(-1);
	    throttle1.setValue(-.75);
	    
		   
		p.add(throttle2);
		p.add(throttle1);
		p.add(speed2);
		p.add(speed1);
		p.add(tf1);
		p.add(tf2);
		p.add(tf3);
		p.add(tf4);
		p.add(tf5);
		p.add(tf6);
		p.add(accelly);
		p.add(spd);
		p.add(dial1);
		
		/*LoadingOverlay ov = new LoadingOverlay(0,0,f.getWidth(),f.getHeight());
		
		f.add(ov);*/
		//spd.setValue(75);
		p.add(new JPanel());
		dial1.setValue(0);
		
	}
	
	
}
