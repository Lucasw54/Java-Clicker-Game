package com.LucasWall.Clicker_Game;

//Imports
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class Clicker_Game implements ActionListener
{//Beginning of Clicker_Game
	//Global Objects
	
	//------Random GUI Globals
	private static JPanel panel;
	private static JFrame frame;
	private static JLabel WelcomeLabel;
	private static JLabel label1;
	private static JSeparator Divider1Label;
	private static JLabel PencilLabel;
	//private static JButton Calculate;
	public static Clicker_Game instance;
	private static JButton Quit1;
	private static JButton Save;
	private static JButton Load;
	private static JButton Options;
	public static JProgressBar bar = new JProgressBar();
	public static int counter = 0;
	public static boolean load = false;
	
	
	//------Game Objects
	
	public static double Pencils = 0;
	
	//------Establishing new colours
	public static final Color TAX = new Color(158, 182, 222);
	public static final Color DARK_GREY = new Color(102, 102, 102);
	public static final Color NEWBlUE = new Color(201, 222, 242);
	public static final Color BLACK = new Color(1, 2, 2);
	
	//------Decimal Format
	static DecimalFormat money = new DecimalFormat("$###,###,###.##");
	static DecimalFormat number = new DecimalFormat("###,###,###");
	
	public enum Actions
	{//Beginning of Actions
		LOAD,
		BRACKETS,
		RETURN,
		QUIT,
		RECALCULATE
	}//End of Actions
	
	public static void Load() {
		Clicker_Game instance = new Clicker_Game();
		//image loading screen
		panel = new JPanel();
		
		bar.setValue(0);
		bar.setBounds(320,600,500,50);
		bar.setStringPainted(true);
		panel.add(bar);
		
		panel.setBackground(TAX); //Sets background
		panel.setLayout(null); //Sets panel to open in center
		
		//new frame
		frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.setSize(1280, 800);
		frame.setLocationRelativeTo(null);
		frame.setBackground(DARK_GREY);
		frame.setResizable(false);
		
		frame.getContentPane().addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				Component c = (Component)e.getSource();
				//frame.setTitle("W: " + c.getWidth() + "H: " + c.getHeight());
				int a = c.getWidth();
				int b = c.getHeight();
				
				double WelcomeLabelWidth = a - (a * 0.6666);
				double WelcomeLabelHeight = b - (b - (b * 0.0625));
				double WelcomeLabelOver = a * 0.3437;
				double WelcomeLabelDown = b * 0.02;
				
				//double Divider1LabelWidth = a - (a * 0.6666);
				//double Divider1LabelHeight = b - (b - (b * 0.0625));
				//double Divider1LabelOver = a * 0.3437;
				//double Divider1LabelDown = b * 0.025;
				
				//double CalculateOver = a * 0.01875;
				//double CalculateDown = b * 0.75;
				//double CalculateWidth = a - (a * 0.0375);
				//double CalculateHeight = b - (b - (b * 0.0625));
				
				
				WelcomeLabel.setBounds((int) WelcomeLabelOver, (int) WelcomeLabelDown, (int) WelcomeLabelWidth, (int) WelcomeLabelHeight);
				//Divider1Label.setBounds((int) Divider1LabelOver, (int) Divider1LabelDown, (int) Divider1LabelWidth, (int) Divider1LabelHeight);
				//Calculate.setBounds((int) CalculateOver, (int) CalculateDown, (int) CalculateWidth, (int) CalculateHeight);				
			}
		});
		
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File("Universal_Paperclips_Title_Screen.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Image dimg = img.getScaledInstance(600, 450, 100);
		
		//Creating image icons
		ImageIcon image1 = new ImageIcon(dimg);
		
		//image loading screen
		label1 = new JLabel(image1);
		label1.setBounds(350,100,600,450);
		panel.add(label1);
		
		WelcomeLabel = new JLabel("");
		panel.add(WelcomeLabel);
		WelcomeLabel.setHorizontalAlignment(JLabel.CENTER);
		WelcomeLabel.setVisible(false);
		
		Divider1Label = new JSeparator();
		Divider1Label.setBounds(0, 40, 1280, 25);
		panel.add(Divider1Label);
		Divider1Label.setForeground(BLACK);
		Divider1Label.setVisible(false);

		//Calculate = new JButton("Calculate");
		//Calculate.setActionCommand(Actions.CALCULATE.name());
		//Calculate.addActionListener(instance);
		//panel.add(Calculate);
		
		Quit1 = new JButton("Quit");
		Quit1.setBounds(10, 10, 80, 25);
		Quit1.setActionCommand(Actions.QUIT.name());
		Quit1.addActionListener(instance);
		panel.add(Quit1);
		Quit1.setVisible(false);
		
		Save = new JButton("Save");
		Save.setBounds(560, 10, 80, 25);
		Save.setActionCommand(Actions.QUIT.name());
		Save.addActionListener(instance);
		panel.add(Save);
		Save.setVisible(false);
		
		Load = new JButton("Load");
		Load.setBounds(640, 10, 80, 25);
		Load.setActionCommand(Actions.LOAD.name());
		Load.addActionListener(instance);
		panel.add(Load);
		Load.setVisible(false);
		
		Options = new JButton("Options");
		Options.setBounds(1190, 10, 80, 25);
		Options.setActionCommand(Actions.QUIT.name());
		Options.addActionListener(instance);
		panel.add(Options);
		Options.setVisible(false);
		
		PencilLabel = new JLabel("Pencils: " + number.format(Pencils));
		PencilLabel.setBounds(20, 70, 1240, 25);
		panel.add(PencilLabel);
		PencilLabel.setFont(new Font("Serif", Font.PLAIN, 24));
		PencilLabel.setVisible(false);
		
		
		
		//set frame to visible
		frame.setVisible(true);
		frame.setTitle("Transcendental Pencils");
		
		if (panel.isVisible()) 
		{//Beginning of if
			
			fill();
		}//End of if
	}
	
	public static void Game() {
		//Hides Load - Specific Elements
		label1.setVisible(false);
		bar.setVisible(false);
		//Shows Game - Specific Elements
		WelcomeLabel.setVisible(true);
		Divider1Label.setVisible(true);
		PencilLabel.setVisible(true);
		Save.setVisible(true);
		Load.setVisible(true);
		Options.setVisible(true);
		//Calculate.setVisible(true);
		Quit1.setVisible(true);
	}
	
	public static void main(String[] args) 
	{//Beginning of main
		Load();
		Continue();
		Game();
	}//End of main

	public static void Continue() {
	
		while(load !=true) 
		{//Beginning of while
			try {//Beginning of try
				//Make invisble while loading
				Thread.sleep(25);
			}

			catch (InterruptedException e) 
			{//Beginning of catch
				e.printStackTrace();
			}//End of catch
		}
	}
	public static void fill()
	{//Beginning of fill
		int counter = 0;
		
		while(counter<=100) 
		{//Beginning of while
			bar.setValue(counter);
			try {//Beginning of try
				//Make invisble while loading
				Thread.sleep(25);
				Load.setVisible(true);
				Load.setBounds(850, 610, 80, 25);
				}//End of try
			
			catch (InterruptedException e) 
			{//Beginning of catch
				e.printStackTrace();
			}//End of catch
			
			counter +=1;
		}//End of while
	}//End of fill

	//If button pressed
	@Override
	public void actionPerformed(ActionEvent e)
	{//Beginning of actionPerformed
		
		//Button Calculate
		if (e.getActionCommand() == Actions.LOAD.name())
		{//Beginning of if
			Game();
			Load.setBounds(640, 10, 80, 25);
		}//End of if
		
		//Button Tax Brackets
		else if (e.getActionCommand() == Actions.BRACKETS.name())
		{//Beginning of else if
			frame.dispose();
		}//End of else if
		
		//Return
		else if (e.getActionCommand() == Actions.RETURN.name())
		{//Beginning of else if
			frame.dispose();
		}//End of else if
		
		//Quit GUI + End code
		else if (e.getActionCommand() == Actions.QUIT.name())
		{//Beginning of else if
			System.out.println("Quit");
			frame.dispose();
		}//End of else if
		
		//Go back to top
		else if (e.getActionCommand() == Actions.RECALCULATE.name())
		{//Beginning of else if
			frame.dispose();
			main(null);
		}//End of else if
	}//End of actionPerformed
}//End of Clicker_Game
