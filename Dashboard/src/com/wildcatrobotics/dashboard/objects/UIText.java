package com.wildcatrobotics.dashboard.objects;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import com.wildcatrobotics.dashboard.net.DataManager;

public class UIText extends BasicUIObject {
	String text = "";
	public UIText(int x, int y, int w, int h, String name) {
		super(x, y, w, h, name);
	}
	
	public void setValue(String d) {
		text = d;
		draw(this.getGraphics());
	}
	
	public void Update(){
		setValue(DataManager.get(a).toString());
	}
	
	public void paintComponent(Graphics g) {
		Graphics2D canvas = (Graphics2D)g;
		canvas.setColor(Color.BLACK);
		super.paintComponent(g);	
		canvas.drawString(text, 0, 0);
		System.out.println(text);
	}
}