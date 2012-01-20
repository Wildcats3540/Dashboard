package com.wildcatrobotics.dashboard.sockettest;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String args[]){

		try {
			ServerSocket srvr = new ServerSocket(7777);
			Socket skt = srvr.accept();
			System.out.print("Server has connected!\n");
			PrintWriter out = new PrintWriter(skt.getOutputStream(), true);
			System.out.print("Sending string: '" + "" + "'\n");
			out.print("");
			out.close();
			skt.close();
			srvr.close();
		}
		catch(Exception e) {
			System.out.print("Whoops! It didn't work!\n");
			e.printStackTrace();
			
		}
	}

}
