package com.wildcatrobotics.dashboard.objects;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.wildcatrobotics.dashboard.MJPG.MjpegFrame;
import com.wildcatrobotics.dashboard.MJPG.MjpegInputStream;
import com.wildcatrobotics.dashboard.net.DataManager;

public class UICamera extends BasicUIObject{


	boolean connected = false;
	JPanel cp = new JPanel();
	JTextField ip = new JTextField();
	JLabel l = new JLabel("<html><span style=\"font-size:15px\">Connecting...</font>");
	//l.setBounds(50,25,200,50);

	//ImageIcon icon = new ImageIcon(getClass().getResource("ajax-loader1.gif"),"");;
	// JLabel activity = new JLabel(icon);

	Image img = null;
	MjpegFrame jpg;
	MjpegInputStream jpgin;
	FileOutputStream b;
	boolean stop = false;
	public UICamera(int x, int y, int w, int h, String name, String add) {
		super(x, y, w, h, name);
		this.setLayout(null);
		cp.setBounds(w/2 - 150, h/2 - 75, 300,150);
		cp.setLayout(null);
		l.setBounds(70, 10, 200, 25);
		ip.setBounds(75, 50, 200, 25);
		ip.setText("");
		cp.add(ip);
		cp.add(l);
		this.add(cp);
		ip.setText(add);
		new CameraFeed().start();


	}


	public void paintComponent(Graphics g) {
		Graphics2D canvas = (Graphics2D)g;
		canvas.setColor(Color.white);
		super.paintComponent(g);
		this.setBackground(Color.black);
		if(jpg!=null){
		
			img = jpg.getImage();
			
			
			Graphics2D icanvas = (Graphics2D)img.getGraphics();
			
			icanvas.setStroke(new BasicStroke(5));
			
			//icanvas.drawLine(w/2, 100, w/2 - 25,150);
			//icanvas.drawLine(w/2, 100, w/2 + 25, 150);
			
			
			canvas.drawImage(img,0,0,w,h,this);
	
		}
		
	}
	class CameraFeed extends Thread{
		public void run(){
			while(true){
				try{
					HttpURLConnection ul= (HttpURLConnection) new URL(ip.getText()).openConnection();
					jpgin = new MjpegInputStream(ul.getInputStream());
					try {b = new FileOutputStream(new File("c:\\mov2.mjpeg"));} catch (FileNotFoundException e) {			}

					if(cp.isVisible())
					cp.setVisible(false);
					while(!stop){
						try {
							jpg = jpgin.readMjpegFrame();
						//	b.write(jpg.getBytes());
						} catch (IOException e) {System.out.println("asdfsdf");stop = true;}
						
						repaint();
					}
					jpgin.close();
					b.flush();
					b.close();
					cp.setVisible(true);
				}
				catch(Exception e){
					if(!cp.isVisible())
					cp.setVisible(true);
					repaint();
				}

			}
		}
	}
	
	public BufferedImage getImage(){
		return (BufferedImage)img;
	}
	
	public BufferedImage getBWImage(){
		
		BufferedImage bimg = null;
        BufferedImage i = (BufferedImage)img;

        //drawing a new image      
        bimg = new BufferedImage((int)i.getWidth(), (int)i.getHeight(),
                                               BufferedImage.TYPE_BYTE_BINARY);
        Graphics2D gg = bimg.createGraphics();
        gg.drawImage(i, 0, 0, img.getWidth(null), img.getHeight(null), null);
        
        BufferedImage o = new BufferedImage((int)i.getWidth(), (int)i.getHeight(),  BufferedImage.TYPE_INT_ARGB);
        o.getGraphics().drawImage(bimg, 0, 0, img.getWidth(null), img.getHeight(null), null);
        
        return o;
	}
}
