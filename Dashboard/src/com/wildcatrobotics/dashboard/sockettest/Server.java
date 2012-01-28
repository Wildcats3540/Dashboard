package com.wildcatrobotics.dashboard.sockettest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Hashtable;
import java.util.Random;

import com.wildcatrobotics.dashboard.net.DataTypes;

public class Server {
	public static void main(String args[]){
		while(true){
		try {
			ServerSocket srvr = new ServerSocket(7777);
			Socket skt = srvr.accept();
			DataOutputStream in = new DataOutputStream(skt.getOutputStream());
			System.out.println("Connected");
			while(skt.isConnected()){
				Hashtable<Integer,Object>a = new Hashtable<Integer,Object>();
				Random rand = new Random();
				a.put(DataTypes.DATA_JOYSTICK_1_AXIS1, rand.nextDouble());
				a.put(DataTypes.DATA_JOYSTICK_1_AXIS2, rand.nextInt(100));
				String b = a.toString();
				System.out.println(b);
				in.writeUTF(b);
				
			}
			System.out.println("Dc");
			in.close();
			skt.close();
			srvr.close();
		}
		catch(Exception e) {
			/*System.out.print("Whoops! It didn't work!\n");
			e.printStackTrace();*/
			
		}
		}
	}


}
