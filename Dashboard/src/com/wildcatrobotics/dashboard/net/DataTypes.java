package com.wildcatrobotics.dashboard.net;

import java.util.Hashtable;


public class DataTypes{
	
	
	public static  Hashtable<Integer, int[]> ranges = new Hashtable<Integer, int[]>();
	
	
	public static final int NULL = 0;
	
	//TYPES
	public static final int TYPE_MIXED  = 0;
	public static final int TYPE_STRING = 1;
	public static final int TYPE_INT    = 2;
	public static final int TYPE_DOUBLE = 3;
	public static final int TYPE_UNKNOWN = 100;
	
	
	//META
	public static final int[] META_ROBOT    = new int[] {1,3, TYPE_MIXED};
	public static final int[] META_PWM      = new int[] {10,19, TYPE_DOUBLE};
	public static final int[] META_DIGITAL  = new int[] {20,33, TYPE_DOUBLE};
	public static final int[] META_RELAY    = new int[] {40,47, TYPE_DOUBLE};
	public static final int[] META_JOYSTICK = new int[] {100,200,TYPE_DOUBLE};

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
	
	
	//JOYSTICKS
	//RESERVED 100-300
	//NUMBERS 205-300 CAN BE USED FOR EXTRA JOYSTICK DATA
	public static final int DATA_JOYSTICK_1_AXIS1    = 100;
	public static final int DATA_JOYSTICK_1_AXIS2    = 101;
	public static final int DATA_JOYSTICK_1_AXIS3    = 102;
	public static final int DATA_JOYSTICK_1_AXIS4    = 103;
	public static final int DATA_JOYSTICK_1_AXIS5    = 104;
	public static final int DATA_JOYSTICK_1_AXIS6    = 105;
	public static final int DATA_JOYSTICK_1_BUTTON1  = 106;
	public static final int DATA_JOYSTICK_1_BUTTON2  = 107;
	public static final int DATA_JOYSTICK_1_BUTTON3  = 108;
	public static final int DATA_JOYSTICK_1_BUTTON4  = 109;
	public static final int DATA_JOYSTICK_1_BUTTON5  = 110;
	public static final int DATA_JOYSTICK_1_BUTTON6  = 111;
	public static final int DATA_JOYSTICK_1_BUTTON7  = 112;
	public static final int DATA_JOYSTICK_1_BUTTON8  = 113;
	public static final int DATA_JOYSTICK_1_BUTTON9  = 114;
	public static final int DATA_JOYSTICK_1_BUTTON10 = 115;
	public static final int DATA_JOYSTICK_1_BUTTON11 = 116;
	public static final int DATA_JOYSTICK_1_BUTTON12 = 117;
	public static final int DATA_JOYSTICK_1_BUTTON13 = 118;
	public static final int DATA_JOYSTICK_1_BUTTON14 = 119;
	public static final int DATA_JOYSTICK_1_BUTTON15 = 120;
	
	public static final int DATA_JOYSTICK_2_AXIS1    = 121;
	public static final int DATA_JOYSTICK_2_AXIS2    = 122;
	public static final int DATA_JOYSTICK_2_AXIS3    = 123;
	public static final int DATA_JOYSTICK_2_AXIS4    = 124;
	public static final int DATA_JOYSTICK_2_AXIS5    = 125;
	public static final int DATA_JOYSTICK_2_AXIS6    = 126;
	public static final int DATA_JOYSTICK_2_BUTTON1  = 127;
	public static final int DATA_JOYSTICK_2_BUTTON2  = 128;
	public static final int DATA_JOYSTICK_2_BUTTON3  = 129;
	public static final int DATA_JOYSTICK_2_BUTTON4  = 130;
	public static final int DATA_JOYSTICK_2_BUTTON5  = 131;
	public static final int DATA_JOYSTICK_2_BUTTON6  = 132;
	public static final int DATA_JOYSTICK_2_BUTTON7  = 133;
	public static final int DATA_JOYSTICK_2_BUTTON8  = 134;
	public static final int DATA_JOYSTICK_2_BUTTON9  = 135;
	public static final int DATA_JOYSTICK_2_BUTTON10 = 136;
	public static final int DATA_JOYSTICK_2_BUTTON11 = 137;
	public static final int DATA_JOYSTICK_2_BUTTON12 = 138;
	public static final int DATA_JOYSTICK_2_BUTTON13 = 139;
	public static final int DATA_JOYSTICK_2_BUTTON14 = 140;
	public static final int DATA_JOYSTICK_2_BUTTON15 = 141;

	public static final int DATA_JOYSTICK_3_AXIS1    = 142;
	public static final int DATA_JOYSTICK_3_AXIS2    = 143;
	public static final int DATA_JOYSTICK_3_AXIS3    = 144;
	public static final int DATA_JOYSTICK_3_AXIS4    = 145;
	public static final int DATA_JOYSTICK_3_AXIS5    = 146;
	public static final int DATA_JOYSTICK_3_AXIS6    = 147;
	public static final int DATA_JOYSTICK_3_BUTTON1  = 148;
	public static final int DATA_JOYSTICK_3_BUTTON2  = 149;
	public static final int DATA_JOYSTICK_3_BUTTON3  = 150;
	public static final int DATA_JOYSTICK_3_BUTTON4  = 151;
	public static final int DATA_JOYSTICK_3_BUTTON5  = 152;
	public static final int DATA_JOYSTICK_3_BUTTON6  = 153;
	public static final int DATA_JOYSTICK_3_BUTTON7  = 154;
	public static final int DATA_JOYSTICK_3_BUTTON8  = 155;
	public static final int DATA_JOYSTICK_3_BUTTON9  = 156;
	public static final int DATA_JOYSTICK_3_BUTTON10 = 157;
	public static final int DATA_JOYSTICK_3_BUTTON11 = 158;
	public static final int DATA_JOYSTICK_3_BUTTON12 = 159;
	public static final int DATA_JOYSTICK_3_BUTTON13 = 160;
	public static final int DATA_JOYSTICK_3_BUTTON14 = 161;
	public static final int DATA_JOYSTICK_3_BUTTON15 = 162;
	
	
	public static final int DATA_JOYSTICK_4_AXIS1    = 163;
	public static final int DATA_JOYSTICK_4_AXIS2    = 164;
	public static final int DATA_JOYSTICK_4_AXIS3    = 165;
	public static final int DATA_JOYSTICK_4_AXIS4    = 166;
	public static final int DATA_JOYSTICK_4_AXIS5    = 167;
	public static final int DATA_JOYSTICK_4_AXIS6    = 168;
	public static final int DATA_JOYSTICK_4_BUTTON1  = 169;
	public static final int DATA_JOYSTICK_4_BUTTON2  = 170;
	public static final int DATA_JOYSTICK_4_BUTTON3  = 171;
	public static final int DATA_JOYSTICK_4_BUTTON4  = 172;
	public static final int DATA_JOYSTICK_4_BUTTON5  = 173;
	public static final int DATA_JOYSTICK_4_BUTTON6  = 174;
	public static final int DATA_JOYSTICK_4_BUTTON7  = 175;
	public static final int DATA_JOYSTICK_4_BUTTON8  = 176;
	public static final int DATA_JOYSTICK_4_BUTTON9  = 177;
	public static final int DATA_JOYSTICK_4_BUTTON10 = 178;
	public static final int DATA_JOYSTICK_4_BUTTON11 = 179;
	public static final int DATA_JOYSTICK_4_BUTTON12 = 180;
	public static final int DATA_JOYSTICK_4_BUTTON13 = 181;
	public static final int DATA_JOYSTICK_4_BUTTON14 = 182;
	public static final int DATA_JOYSTICK_4_BUTTON15 = 183;

	public static final int DATA_JOYSTICK_5_AXIS1    = 184;
	public static final int DATA_JOYSTICK_5_AXIS2    = 185;
	public static final int DATA_JOYSTICK_5_AXIS3    = 186;
	public static final int DATA_JOYSTICK_5_AXIS4    = 187;
	public static final int DATA_JOYSTICK_5_AXIS5    = 188;
	public static final int DATA_JOYSTICK_5_AXIS6    = 189;
	public static final int DATA_JOYSTICK_5_BUTTON1  = 190;
	public static final int DATA_JOYSTICK_5_BUTTON2  = 191;
	public static final int DATA_JOYSTICK_5_BUTTON3  = 192;
	public static final int DATA_JOYSTICK_5_BUTTON4  = 193;
	public static final int DATA_JOYSTICK_5_BUTTON5  = 194;
	public static final int DATA_JOYSTICK_5_BUTTON6  = 195;
	public static final int DATA_JOYSTICK_5_BUTTON7  = 196;
	public static final int DATA_JOYSTICK_5_BUTTON8  = 197;
	public static final int DATA_JOYSTICK_5_BUTTON9  = 198;
	public static final int DATA_JOYSTICK_5_BUTTON10 = 199;
	public static final int DATA_JOYSTICK_5_BUTTON11 = 200;
	public static final int DATA_JOYSTICK_5_BUTTON12 = 201;
	public static final int DATA_JOYSTICK_5_BUTTON13 = 202;
	public static final int DATA_JOYSTICK_5_BUTTON14 = 203;
	public static final int DATA_JOYSTICK_5_BUTTON15 = 204;
}
