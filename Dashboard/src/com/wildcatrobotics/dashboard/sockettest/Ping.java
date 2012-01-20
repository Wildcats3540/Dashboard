package com.wildcatrobotics.dashboard.sockettest;
import java.io.*;
import java.net.*;
import java.util.Scanner;

import com.wildcatrobotics.dashboard.Dashboard;
public class Ping extends Thread{



	public void run(){
		try {
			Socket skt = new Socket("10.35.40.2", 7777);
			System.out.print(skt.isConnected());
			DataInputStream in = new DataInputStream(skt.getInputStream());
			DataOutputStream out = new DataOutputStream(skt.getOutputStream());
			System.out.println("Printing: "+ in.readUTF());
			while(true){
				Dashboard.data = in.readDouble();
			//	System.out.println(Dashboard.data);
			}
		}
		catch(Exception e) {
			System.out.println("Failed to connect");
			e.printStackTrace();
		}
	}
}

