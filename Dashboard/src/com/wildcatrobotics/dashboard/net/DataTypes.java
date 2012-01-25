package com.wildcatrobotics.dashboard.net;

import java.util.Hashtable;


public class DataTypes{
	
	
	public static  Hashtable<Integer, int[]> ranges = new Hashtable<Integer, int[]>();
	
	
	//TYPES
	public static final int TYPE_MIXED  = 0;
	public static final int TYPE_STRING = 1;
	public static final int TYPE_INT    = 2;
	public static final int TYPE_DOUBLE = 3;
	public static final int TYPE_UNKNOWN = 100;
	
	
	//META
	public static final int[] META_ROBOT   = new int[] {1,3, TYPE_MIXED};
	public static final int[] META_PWM     = new int[] {10,19, TYPE_DOUBLE};
	public static final int[] META_DIGITAL = new int[] {20,33, TYPE_DOUBLE};
	public static final int[] META_RELAY   = new int[] {40,47, TYPE_DOUBLE};

	public static final int[][] META_RANGE = 
		{	
			META_ROBOT,
			META_PWM,
			META_DIGITAL,
			META_RELAY
		};
	
	
	

	//ROBOT VALUES
	//RESERVED: 0-10
	public static final int DATA_ROBOT_NAME = 1;
	public static final int DATA_ROBOT_MODE = 2;
	public static final int DATA_ROBOT_VOLTS = 3;
	
	
	//PWM
	//RESERVED: 10-19
	public static final int DATA_PWM_1 =  10;
	public static final int DATA_PWM_2 =  11;
	public static final int DATA_PWM_3 =  12;
	public static final int DATA_PWM_4 =  13;
	public static final int DATA_PWM_5 =  14;
	public static final int DATA_PWM_6 =  15;
	public static final int DATA_PWM_7 =  16;
	public static final int DATA_PWM_8 =  17;
	public static final int DATA_PWM_9 =  18;
	public static final int DATA_PWM_10 = 19;
	
	
	//DIGITAL INPUTS
	//RESERVED: 20-39
	public static final int DATA_DIGITAL_1  = 20;
	public static final int DATA_DIGITAL_2  = 21;
	public static final int DATA_DIGITAL_3  = 22;
	public static final int DATA_DIGITAL_4  = 23;
	public static final int DATA_DIGITAL_5  = 24;
	public static final int DATA_DIGITAL_6  = 25;
	public static final int DATA_DIGITAL_7  = 26;
	public static final int DATA_DIGITAL_8  = 27;
	public static final int DATA_DIGITAL_9  = 28;
	public static final int DATA_DIGITAL_10 = 29;
	public static final int DATA_DIGITAL_11 = 30;
	public static final int DATA_DIGITAL_12 = 31;
	public static final int DATA_DIGITAL_13 = 32;
	public static final int DATA_DIGITAL_14 = 33;
	
	//RELAY
	//RESERVED 40-59
	public static final int DATA_RELAY_1 = 40;
	public static final int DATA_RELAY_2 = 41;
	public static final int DATA_RELAY_3 = 42;
	public static final int DATA_RELAY_4 = 43;
	public static final int DATA_RELAY_5 = 44;
	public static final int DATA_RELAY_6 = 45;
	public static final int DATA_RELAY_7 = 46;
	public static final int DATA_RELAY_8 = 47;
	
	
}
