package com.wildcatrobotics.targetServer;

import com.wildcatrobotics.targetServer.net.NetManager;
import com.wildcatrobotics.targetServer.util.Logger;

public class TargetServer {

	public TargetServer(){
		
	}
	
	public static void main(String args[]){
		new TargetServer().start();
	}
	
	public void start(){
		Logger.showLogger();
		Logger.setPos(1300, 400);
		Logger.log("Target Server - Wildcat Robotics 3540 - 2012");
		Logger.log("Initializing");
		
		new NetManager().start();
		
		
		
		
		
	}
	
	
}
