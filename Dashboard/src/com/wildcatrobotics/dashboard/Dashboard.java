package com.wildcatrobotics.dashboard;

import java.awt.Color;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

import com.wildcatrobotics.dashboard.net.DataTypes;
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
	
	private static final String ip = "localhost";
	private static final String port = "777";
	
	public static double data = 0;
	public static void main(String args[]){
		new Dashboard().start();
	}
	
	public void start(){
		
		f.setSize(1024, 710);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		f.add(p);
		p.setLayout(null);
		{
			p.add(cameraT);
			cameraT.setBackground(Color.white);
			cameraT.setBounds(25, 25,350, 300);
		}
		
		UIBar bar = new UIBar(725, 60 ,25, 150);
		UIBar bar2 = new UIBar(755, 60 ,25, 150);
		UIColorChanger c = new UIColorChanger(400, 225, 100, 100);
		UI2DAxisPosition d = new UI2DAxisPosition(600, 225, 100, 100);

		UISpeedometer sp = new UISpeedometer(400, 50, 150);
		UIGraph gp = new UIGraph(100,400,300,150);
		p.add(bar);
		p.add(bar2);
		p.add(c);
		p.add(d);
		p.add(sp);
		p.add(gp);
		sp.setValue(25);
		//bar.setValue(25);
		bar2.setValue(50);
		p.repaint();
		f.setVisible(true);

		/*bar.setMin(-1);
		bar.setMax(1);*/
		Hashtable<Integer, Object> ht = new Hashtable<Integer, Object>();
		
		ht.put(DataTypes.DATA_DIGITAL_2, 4);
		ht.put(DataTypes.DATA_PWM_1, 3);
		
		Hashtable<Integer, Object> a = new NetworkConversionHelper().RawToHash(ht.toString());
		
		System.out.println(a.get(DataTypes.DATA_DIGITAL_2));
		
		
		new Ping().start();
		
		
		while(true){
			try{Thread.sleep(1000);}catch(Exception e){}
			d.setValue(new Random().nextDouble()*100,(new Random().nextDouble()*100));
			//bar.setValue(((data + 1)/2)*100);
			//bar.setValue(data);
		}
		
	}

	
	
	
}
