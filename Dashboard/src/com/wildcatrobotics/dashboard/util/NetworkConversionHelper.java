package com.wildcatrobotics.dashboard.util;

import java.util.Hashtable;

import com.wildcatrobotics.dashboard.net.DataTypes;

public class NetworkConversionHelper {

	String raw;
	public Hashtable<Integer,Object> RawToHash(String input){
		Hashtable<Integer, Object>ht = new Hashtable<Integer, Object>();
		
		String[] next = {"",""}; 
		
		raw = input.substring(1, input.length()-1);

		
		while((next = getNext())!=null){
			try{
				int i = Integer.parseInt(next[0]);
				int type = getType(i);
				Object v = convertToObject(next[1],type);
				ht.put(i, v);
			}catch(Exception e){e.printStackTrace();}
			
		}
		
		return ht;
		
		
	}
	
	
	
	private Object convertToObject(String string, int type) {
		if(type == DataTypes.TYPE_DOUBLE)
			return new Double(Double.parseDouble(string));
		if(type == DataTypes.TYPE_INT)
			return new Integer(Integer.parseInt(string));
		return string;
		
	}



	private String[] getNext(){
		try{
		int a = 0;
		String [] flag = {"",""};
		int i = raw.indexOf("=");
		int i2 = raw.indexOf(",");
		if(i==-1&&i2==-1)
			return null;
		if(i2==-1)
			i2 = raw.length();
		String t1 = raw.substring(0,i);
		String t2 = raw.substring(i+1,i2 );
		
		if(i2!=raw.length())
			raw = raw.substring(i2+2);
		else
			raw = "";
		
		flag[0] = t1;
		flag[1] = t2;
		
		return flag;
		}
		catch(Exception e){e.printStackTrace();}
		return null;
	}
	
	
	public int getType(int i){
		for(int a = 0;DataTypes.META_RANGE.length>a;a++){
			if(DataTypes.META_RANGE[a][0]<i && DataTypes.META_RANGE[a][1]>i){
				return DataTypes.META_RANGE[a][2];
			}
		}
		return DataTypes.TYPE_UNKNOWN;
		

	}
	
	
}
