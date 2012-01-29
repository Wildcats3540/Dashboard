package com.wildcatrobotics.dashboard.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Date;

import com.wildcatrobotics.dashboard.Dashboard;
import com.wildcatrobotics.dashboard.functions.UpdateManager;
import com.wildcatrobotics.dashboard.util.NetworkConversionHelper;

public class NetManager extends Thread {


	
	public static int STATUS_DISCONECTED = 0;
	public static int STATUS_DISALED = 1;
	public static int STATUS_AUTO = 2;
	public static int STATUS_TELE = 3;
	
	private static boolean connected = false;
	private static int status = STATUS_DISCONECTED;
	
	private NetworkConversionHelper netConvHelp = new NetworkConversionHelper();
	
	
	
	public void run(){
		while(true){
		try {
			Socket skt = new Socket(Dashboard.ip, Dashboard.port);

			DataInputStream in = new DataInputStream(skt.getInputStream());
			setConnected(true);
			System.out.println("Connected");
				while(skt.isConnected()){
					long time  = new Date().getTime();
					String s = in.readUTF();
					//System.out.println(s);
					DataManager.updateFull(netConvHelp.RawToHash(s));
					time = new Date().getTime() - time;
					DataManager.put(DataTypes.DATA_NETWORK_PING, time);
					UpdateManager.updateFull();
				}
			setConnected(false);
			in.close();
			skt.close();
			
		}
		catch(Exception e) {
			System.out.println("Failed to connect");
			e.printStackTrace();
		}
		}
	}
	
	//			DataOutputStream out = new DataOutputStream(skt.getOutputStream());

	
	private static void setConnected(Boolean b){
		connected = b;
		if(connected){
			runConnectionTask();
		}
		else
		{
			//runDCTask();
		}
	}
	
	
	public static boolean isConnected(){
		return connected;
	}
	
	public static int getStatus(){
		return status;
	}
	
	public static void runConnectionTask(){
	}
	
}
