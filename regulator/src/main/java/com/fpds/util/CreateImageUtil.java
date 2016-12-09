package com.fpds.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CreateImageUtil {

	public static void create(String path,String num){   
        int width = 150;   
        int height = 80;   
        
        File file = new File(path);   
           
        Font font = new Font("宋体", Font.PLAIN, 50); 
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);   
        Graphics2D g2 = (Graphics2D)bi.getGraphics();   
        g2.setBackground(Color.WHITE);   
        g2.clearRect(0, 0, width, height);   
        g2.setPaint(Color.black);   
        g2.setFont(font);
           
        g2.drawString(num.toString(), 27, 60);   
           
        try {
			ImageIO.write(bi, "jpg", file);
		} catch (IOException e) {
			e.printStackTrace();
		}   
    }   
	
	public static void main(String[] args){
		try {
			create("asd","1234");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
