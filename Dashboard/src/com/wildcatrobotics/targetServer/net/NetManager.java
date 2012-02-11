package com.wildcatrobotics.targetServer.net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
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
				 BufferedInputStream in = new BufferedInputStream(skt.getInputStream());
				 BufferedOutputStream out = new BufferedOutputStream(skt.getOutputStream());
				 while(skt.isConnected()){
					 
				 }
				
			}
		}catch(Exception e){
			Logger.error("Exception in network thread");
		}
		
		
	}
	
	
}
