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
	
	public void start(){
		new NetManager().start();
		f.setSize(1024, 710);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.add(p);
		p.setLayout(null);
		{
			p.add(cameraT);
			cameraT.setBackground(Color.white);
			cameraT.setBounds(25, 25,350, 300);
		}
		
		
		
		UIBar bar = (UIBar) new UIBar(725, 60 ,25, 150).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS1);
		bar.setMax(1);
		bar.setMin(-1);
		UIBar bar2 = (UIBar) new UIBar(755, 60 ,25, 150).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS3);
		//UIColorChanger c = (UIColorChanger) new UIColorChanger(400, 225, 100, 100).setUpdater(DataTypes.DATA_JOYSTICK_5_BUTTON7);
		UI2DAxisPosition d = (UI2DAxisPosition) new UI2DAxisPosition(600, 225, 100, 100).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS1, DataTypes.DATA_JOYSTICK_1_AXIS2);
		
		UISpeedometer sp = (UISpeedometer) new UISpeedometer(400, 50, 150).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS5);
		sp.setMax(100);
		sp.setMin(0);
		UIGraph gp = (UIGraph) new UIGraph(100,400,300,150).setUpdater(DataTypes.DATA_DIGITAL_1);
		gp.setMax(8);
		gp.setMin(-8);
		p.add(bar);
		p.add(bar2);
		//p.add(c);
		p.add(d);
		p.add(sp);
		p.add(gp);
		sp.setValue(25);
		//bar.setValue(25);
		p.repaint();
		f.setVisible(true);

		
		
		while(true){
			try{Thread.sleep(1000);}catch(Exception e){}
			//d.setValue(new Random().nextDouble()*100,(new Random().nextDouble()*100));
			
		}
		
	}

	
	
	
}
