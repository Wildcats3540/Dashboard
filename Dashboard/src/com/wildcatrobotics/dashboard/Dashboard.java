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
import com.wildcatrobotics.targetServer.util.HoughTransform;

public class Dashboard {

	public static String ip = "10.35.40.2";
	public static int port = 7777;

	JFrame f = new JFrame("Dashboard");
	JPanel p = new JPanel();
	JPanel cameraT = new JPanel();
	
	JFrame setD = new JFrame();
	JTextField setIPT = new JTextField();
	JTextField setPortT = new JTextField();
	
	JButton hough = new JButton("Start h");
	
	private static JDialog connectedWindow = new JDialog();
	
	public static double data = 0;
	
	public static void main(String args[]){
		new Dashboard().run();
	}
	

	/**
	 * This method is the first method to be called at startup of the dashboard.
	 * Currently this method creates and displays the connection settings window.
	 */
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
	
	/**
	 * This method is the starting point for the program. Called when the connect button is pressed on the setup window
	 * 
	 * 
	 * 
	 * 
	 * 
	 */
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
		connectedWindow.setAlwaysOnTop(true);
		connectedWindow.setLayout(null);
		JLabel l = new JLabel("<html><span style=\"font-size:15px\">Connecting to "+ ip +":" + port+"</font>");
		l.setBounds(50,25,200,50);
		
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

	
	
	
	UICamera camera = new UICamera(5,45,395,300, "Camera", "http://10.35.40.20/mjpg/video.mjpg");
	UICamera camera2 = new UICamera(405,45,395,300, "Camera", "http://10.35.40.21/mjpg/video.mjpg");
	JPanel himg = new JPanel();
	
	/**
	 * This is where all the UI Elements are added and setup
	 */
	public void setup(){
		UIBar throttle1 = (UIBar) new UIBar(295,515,5,150, "Throttle").setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS3).setMainColor(Color.orange);
		UIBar throttle2 = (UIBar) new UIBar(310,515,5,150, "Throttle").setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS3).setMainColor(Color.orange);
		UIBar speed1    = (UIBar) new UIBar(270,515,25,150, "Speed").setUpdater(DataTypes.DATA_DIGITAL_1);
		UIBar speed2    = (UIBar) new UIBar(315,515,25,150, "Speed").setUpdater(DataTypes.DATA_DIGITAL_2);
		UITextField tf1 = new UITextField(805,45,200,25).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS1);
		UITextField tf2 = new UITextField(805,75,200,25).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS2);
		UITextField tf3 = new UITextField(805,105,200,25).setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS3);
		UITextField tf4 = new UITextField(805,135,200,25).setUpdater(DataTypes.DATA_ROBOT_VOLTS);
		UITextField tf5 = new UITextField(805,165,200,25).setUpdater(DataTypes.DATA_NETWORK_PING);
		UITextField tf6 = new UITextField(805,195,200,25).setUpdater(DataTypes.DATA_DIGITAL_1);
		UILight status = (UILight) new UILight(5,5,1000,35, "Mode").setUpdater(DataTypes.DATA_ROBOT_MODE);
		Hashtable<Integer, Color>colors = new Hashtable<Integer,Color>();
		colors.put(0, Color.black);
		colors.put(1, Color.RED);
		colors.put(2, Color.LIGHT_GRAY);
		colors.put(3, Color.blue);
		colors.put(4, Color.green);
		status.setColors(colors);

		UI2DAxisPosition axis = (UI2DAxisPosition) new UI2DAxisPosition(5,465,200,200, "Axis").setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS1,DataTypes.DATA_JOYSTICK_1_AXIS2);
		UIGraph accellerator = (UIGraph) new UIGraph(5,515,250,150, "Accel",200).setUpdater(DataTypes.DATA_DIGITAL_1);
		UISpeedometer speedometer = (UISpeedometer) new UISpeedometer(375,465,200, "Speed").setUpdater(DataTypes.DATA_JOYSTICK_1_AXIS3);
		UIGraph ping  = (UIGraph) new UIGraph(5,410,100,50, "Ping").setUpdater(DataTypes.DATA_NETWORK_PING);
		UIGraph volts = (UIGraph) new UIGraph(5,350,100,50, "Volts").setUpdater(DataTypes.DATA_ROBOT_VOLTS);
		UIDial gyro = (UIDial) new UIDial(805,470,100, "Dial").setUpdater(DataTypes.DATA_DIGITAL_13);
		hough.setBounds(800,300,100,30);
		hough.addActionListener(new houghT());
		himg.setBounds(800,350,300,200);
		
		
		ping.setMin(0);
		ping.setMax(100);
		
		accellerator.setMax(4);
		accellerator.setMin(-4);
		
		
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
		//p.add(accellerator);
		p.add(speedometer);
		p.add(ping);
		p.add(volts);
		p.add(axis);
		//p.add(gyro);
		p.add(status);
		p.add(camera);
		p.add(camera2);
		p.add(hough);
		p.add(himg);
		/*LoadingOverlay ov = new LoadingOverlay(0,0,f.getWidth(),f.getHeight());
		f.add(ov);*/
		//spd.setValue(75);
		p.add(new JPanel());
	}
	/**
	 * Called when the Connection state is changed.
	 * @param Boolean. Connection state;
	 */
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
	class houghT implements ActionListener{

		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			HoughTransform h = new HoughTransform();
			h.start(camera2.getBWImage());
			himg.getGraphics().drawImage(h.getHoughArrayImage(),0,0,300,200,null);
			
		}
		
	}
}