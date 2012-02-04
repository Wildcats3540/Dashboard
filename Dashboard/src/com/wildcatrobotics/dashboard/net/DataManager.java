package com.wildcatrobotics.dashboard.net;

import java.util.Hashtable;

import com.wildcatrobotics.dashboard.util.NetworkConversionHelper;

public class DataManager {

	private static Hashtable<Integer, Object>data = new Hashtable<Integer, Object>();
	private static NetworkConversionHelper h = new NetworkConversionHelper();
	
	public static synchronized void setup(){
		
		for(int a = 0;DataTypes.META_RANGE.length>a;a++){
			for(int b = DataTypes.META_RANGE[a][0]; b<  DataTypes.META_RANGE[a][1]; b++){
				put(new Integer(b), 0);
			}
		}
	}
	
	
	
	public static synchronized void put(Integer i, Object o){
		data.put(i, o);
	}
	
	public static synchronized Object get(Integer i){
		return data.get(i);
	}
	
	public static synchronized void updateFull(Hashtable<Integer, Object> h){
		data.putAll(h);
	}
	
	public static synchronized double getNumber(int i){
		//System.out.println(i);
		int type = h.getType(i);
		//System.out.println(type);
		/*if(type  == DataTypes.TYPE_DOUBLE || type == DataTypes.TYPE_INT){
			System.out.println("Asd");
		}*/
			return Double.parseDouble(DataManager.get(i).toString());
		//return 0;
	}
	
}
