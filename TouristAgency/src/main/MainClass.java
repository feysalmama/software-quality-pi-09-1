package main;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

import gui.*;

public class MainClass {
	
	public static void main(String[] args) {
		MainFORM mainForm = new MainFORM();		
		mainForm.setVisible(true);
		mainForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
}
