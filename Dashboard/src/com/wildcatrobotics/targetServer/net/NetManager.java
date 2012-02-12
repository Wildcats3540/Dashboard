package com.wildcatrobotics.targetServer.net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

import com.wildcatrobotics.targetServer.util.Logger;

public class NetManager extends Thread{

	public static boolean online = true;
	
	
	public void run(){
		Logger.log("Network Initialized");
		try{
			while(online){
		         ServerSocket srvr = new ServerSocket(7778);
		         Socket skt = srvr.accept();
				 BufferedReader in = new BufferedReader(new InputStreamReader(skt.getInputStream()));
				 BufferedOutputStream out = new BufferedOutputStream(skt.getOutputStream());
				 
				 while(skt.isConnected()){
					 String input = in.readLine();
					 if(input.equals("request")){
						 
					 }
						 
					 
				 }
				Logger.log("");
			}
		}catch(Exception e){
			Logger.error("Exception in network thread");
		}
		
		
	}
	
	
	public double getValue(String str, String val){
		int index = str.indexOf(val);
		String sub = str.substring(index, str.indexOf(";", index));
		
		return Double.parseDouble(sub);
	}
	
	
}
