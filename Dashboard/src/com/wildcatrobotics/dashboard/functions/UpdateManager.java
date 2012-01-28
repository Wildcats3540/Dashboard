package com.wildcatrobotics.dashboard.functions;

import java.util.ArrayList;

import com.wildcatrobotics.dashboard.objects.UIObject;
import com.wildcatrobotics.dashboard.net.*;
public class UpdateManager{

	
	private static ArrayList<UIObject> objects = new ArrayList<UIObject>();
		
	
	
	
	public static synchronized  void add(UIObject i){
		objects.add(i);
		
	}
	
	
	public static synchronized  void updateFull(){
		for(UIObject o: objects){
			o.update();
		}
	}
	
}
