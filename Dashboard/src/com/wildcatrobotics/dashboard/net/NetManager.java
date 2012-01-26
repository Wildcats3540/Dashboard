package com.wildcatrobotics.dashboard.net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

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
		try {
			Socket skt = new Socket("10.35.40.2", 7777);
			DataInputStream in = new DataInputStream(skt.getInputStream());
			setConnected(true);
				while(skt.isConnected()){
					String s = in.readUTF();
					DataManager.updateFull(netConvHelp.RawToHash(s));
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
		UpdateManager.Init();
	}
	
}
