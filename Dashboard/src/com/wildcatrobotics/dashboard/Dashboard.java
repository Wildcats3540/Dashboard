package com.wildcatrobotics.dashboard;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wildcatrobotics.dashboard.net.DataManager;
import com.wildcatrobotics.dashboard.net.DataTypes;
import com.wildcatrobotics.dashboard.net.NetManager;
import com.wildcatrobotics.dashboard.objects.UI2DAxisPosition;
import com.wildcatrobotics.dashboard.objects.UIBar;
import com.wildcatrobotics.dashboard.objects.UICamera;
import com.wildcatrobotics.dashboard.objects.UIDial;
import com.wildcatrobotics.dashboard.objects.UIGraph;
import com.wildcatrobotics.dashboard.objects.UILight;
import com.wildcatrobotics.dashboard.objects.UISpeedometer;
import com.wildcatrobotics.dashboard.objects.UITextField;
import com.wildcatrobotics.dashboard.sockettest.Ping;
import com.wildcatrobotics.dashboard.util.NetworkConversionHelper;

public class Dashboard {

	
	public static String ip = "10.35.40.2";
	public static int port = 7777;
		
	
	
	JFrame f = new JFrame("Dashboard");
	JPanel p = new JPanel();
	JPanel cameraT = new JPanel();
	

	JFrame setD = new JFrame();
	JTextField setIPT = new JTextField();
	JTextField setPortT = new JTextField();
	
	private static JDialog connectedWindow = new JDialog();
	
	public static double data = 0;
	
	public static void main(String args[]){
		new Dashboard().run();
	}
	
	
	public void run(){
		JPanel  setP = new JPanel();
		JPanel setPB = new JPanel();
		JLabel about = new JLabel("<html><br><center>Wildcat Robotics - FIRST Team 3540 - 2011/2012</center>");
		JLabel setIP = new JLabel("IP");
		JLabel setPort = new JLabel("Port");
		JButton setB = new JButton("Connect");
		
		setD.setTitle("Dashboard Startup - Wildcat Robotics 3540");
		setD.setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);
		setD.setSize(400, 175);
		//setD.setResizable(false);
		setP.setLayout(null);
		setPB.setLayout(null);
		setP.setBackground(Color.white);
		setD.setLocationRelativeTo(null);
		
		setP.setBounds(0, 0, setD.getWidth(), setD.getHeight());
		about.setBounds(50, 5,400,25);
		setIP.setBounds(30, 1, 200, 25);
		setPort.setBounds(230,1,50,25);
		setPortT.setBounds(230, 26, 100, 25);
		setIPT.setBounds(30, 26, 200, 25);
		setB.setBounds(230, 53, 100, 30);
		setPB.setBounds(0,50,400,100);
		
		setP.add(about);
		setPB.add(setIP);
		setPB.add(setPort);
		setPB.add(setIPT);
		setPB.add(setPortT);
		setPB.add(setB);
		setP.add(setPB);
		setD.add(setP);
		
		setIPT.setText(ip);
		setPortT.setText(port+"");
		setIPT.setFont(new Font("courier", Font.PLAIN, 12));
		setPortT.setFont(new Font("courier", Font.PLAIN, 12));
		setB.addActionListener(new Connect());
		
		setD.setVisible(true);
		
	}
	
	public void start(){

		f.setSize(1024, 710);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		p.setLayout(null);
		p.setBounds(0, 0, f.getWidth(), f.getHeight());
		setup();
		f.add(p);
		f.setVisible(true);
		
		connectedWindow.setSize(400,125);
		//connectedWindow.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		connectedWindow.setLocationRelativeTo(f);
		//connectedWindow.setAlwaysOnTop(true);
		
		//connectedWindow.setLayout(null);
		
		
		JLabel l = new JLabel("<html><span style=\"font-size:15px\">Connecting to "+ ip +":" + port+"</font>");
		//l.setBounds(50,25,200,50);
		
		ImageIcon icon = new ImageIcon(getClass().getResource("ajax-loader1.gif"),"");;
		JLabel activity = new JLabel(icon);
		JPanel cp = new JPanel();
		cp.add(activity);
		cp.add(l);
		connectedWindow.add(cp);
		
		setConnected(false);		
		
		
		DataManager.setup();
		new NetManager().start();
		}

	

	public void setup(){

		UIBar throttle1 = (UIBar) new UIBar(875,220,5,150, "Throttle").setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS3).setMainColor(Color.orange);
		UIBar throttle2 = (UIBar) new UIBar(900,220,5,150, "Throttle").setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS3).setMainColor(Color.orange);
		UIBar speed1    = (UIBar) new UIBar(850,220,25,150, "Speed").setUpdater(DataTypes.DATA_DIGITAL_1);
		UIBar speed2    = (UIBar) new UIBar(905,220,25,150, "Speed").setUpdater(DataTypes.DATA_DIGITAL_2);
		UITextField tf1 = new UITextField(800,10,200,25).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS3);
		UITextField tf2 = new UITextField(800,40,200,25).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS3);
		UITextField tf3 = new UITextField(800,70,200,25).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS3);
		UITextField tf4 = new UITextField(800,100,200,25).setUpdater(DataTypes.DATA_ROBOT_VOLTS);
		UITextField tf5 = new UITextField(800,130,200,25).setUpdater(DataTypes.DATA_NETWORK_PING);
		UITextField tf6 = new UITextField(800,160,200,25).setUpdater(DataTypes.DATA_DIGITAL_1);
		UILight    mode = (UILight) new UILight(10,10,75,75, "Mode").setUpdater(DataTypes.DATA_ROBOT_MODE);
		UI2DAxisPosition axis = (UI2DAxisPosition) new UI2DAxisPosition(10,125,200,200, "Axis").setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS5,DataTypes.DATA_JOYSTICK_1_AXIS6);

		UICamera camera = new UICamera(300,35,500,400, "Camera");

		
		UIGraph accelly = (UIGraph) new UIGraph(10,500,250,150, "Accel").setUpdater(DataTypes.DATA_DIGITAL_1);
		UISpeedometer spd = (UISpeedometer) new UISpeedometer(350,450,200, "Speed").setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS5);
		
		UIGraph ping  = (UIGraph) new UIGraph(25,425,100,50, "Ping").setUpdater(DataTypes.DATA_NETWORK_PING);
		UIGraph volts = (UIGraph) new UIGraph(145,425,100,50, "Volts").setUpdater(DataTypes.DATA_ROBOT_VOLTS);

		UIDial dial1 = (UIDial) new UIDial(775, 425, 100, "Dial").setUpdater(DataTypes.DATA_DIGITAL_13);


		
		ping.setMin(0);
		ping.setMax(100);
		
		accelly.setMax(4);
	    accelly.setMin(-4);
		
	    throttle1.setMax(1);
	    throttle1.setMin(-1);
	    throttle1.setValue(-.75);
	    
	    volts.setMax(14);
	    volts.setMin(10);
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
		p.add(ping);
		p.add(volts);
		p.add(axis);
		p.add(dial1);
		p.add(mode);
		p.add(camera);
		/*LoadingOverlay ov = new LoadingOverlay(0,0,f.getWidth(),f.getHeight());
		
		f.add(ov);*/
		//spd.setValue(75);
		p.add(new JPanel());
		
	}
	
	public static void setConnected(boolean b){
		if(b){
			connectedWindow.setVisible(false);
		}
		else{
			if(!connectedWindow.isVisible())
			connectedWindow.setVisible(true);
		}
		
	}
	
	class Connect implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			ip = setIPT.getText();
			port = Integer.parseInt(setPortT.getText());
			

			start();
			setD.setVisible(false);
			setD.dispose();
			
		}
		
	}
	
	
}
