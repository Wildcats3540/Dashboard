package com.wildcatrobotics.targetServer.net;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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
				 DataInputStream in = new DataInputStream(skt.getInputStream()));
				 DataOutputStream out = new DataOutputStream(skt.getOutputStream()));
				 
				 while(skt.isConnected()){
					 String input = in.readLine();
					 if(input.equals("request")){
						 out.writeUTF(arg0)
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
