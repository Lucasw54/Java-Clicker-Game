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
	private static JButton Back;
	private static JButton Options;
	public static JProgressBar bar = new JProgressBar();
	public static int counter = 0;
	public static boolean load = false;
	public static JLabel GUImodeLabel;
	public static JButton GUImode1Label;
	public static JButton GUImode2Label;
	public static JButton GUImode3Label;
	public static JButton GUImode4Label;
	public static JButton GUImode5Label;
	public static JButton GUImode6Label;
	public static JButton GUImode7Label;
	public static JButton MakePencil;
	
	
	
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
		SAVE,
		RETURN,
		QUIT,
		OPTIONS,
		GUIMODE1,
		GUIMODE2,
		GUIMODE3,
		GUIMODE4,
		GUIMODE5,
		GUIMODE6,
		GUIMODE7,
		MAKEPENCIL
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
		
		//----------Menu stuff
		Quit1 = new JButton("Quit");
		Quit1.setBounds(10, 10, 80, 25);
		Quit1.setActionCommand(Actions.QUIT.name());
		Quit1.addActionListener(instance);
		panel.add(Quit1);
		Quit1.setVisible(false);
		
		Save = new JButton("Save");
		Save.setBounds(560, 10, 80, 25);
		Save.setActionCommand(Actions.SAVE.name());
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
		Options.setActionCommand(Actions.OPTIONS.name());
		Options.addActionListener(instance);
		panel.add(Options);
		Options.setVisible(false);
		
		Back = new JButton("Back");
		Back.setBounds(90, 10, 80, 25);
		Back.setActionCommand(Actions.RETURN.name());
		Back.addActionListener(instance);
		panel.add(Back);
		Back.setVisible(false);
		
		//-------------Game stuff
		
		PencilLabel = new JLabel("Pencils: " + number.format(Pencils));
		PencilLabel.setBounds(20, 70, 1240, 25);
		panel.add(PencilLabel);
		PencilLabel.setFont(new Font("Serif", Font.PLAIN, 24));
		PencilLabel.setVisible(false);
		
		MakePencil = new JButton("Make Pencil");
		MakePencil.setBounds(10, 110, 120, 25);
		MakePencil.setActionCommand(Actions.MAKEPENCIL.name());
		MakePencil.addActionListener(instance);
		panel.add(MakePencil);
		MakePencil.setVisible(false);
		
		
		//-------Options Window
		GUImodeLabel = new JLabel("Window Size: ");
		GUImodeLabel.setBounds(30,100,200,20);
		panel.add(GUImodeLabel);
		GUImodeLabel.setVisible(false);
		GUImodeLabel.setFont(new Font("Serif", Font.PLAIN, 24));
		
		GUImode1Label = new JButton("Default");
		GUImode1Label.setBounds(30,280,200,40);
		GUImode1Label.setActionCommand(Actions.GUIMODE1.name());
		GUImode1Label.addActionListener(instance);
		panel.add(GUImode1Label);
		GUImode1Label.setVisible(false);
		GUImode1Label.setFont(new Font("Serif", Font.PLAIN, 24));
		
		GUImode2Label = new JButton("2048 x 1280");
		GUImode2Label.setBounds(30,130,200,40);
		GUImode2Label.setActionCommand(Actions.GUIMODE2.name());
		GUImode2Label.addActionListener(instance);
		panel.add(GUImode2Label);
		GUImode2Label.setVisible(false);
		GUImode2Label.setFont(new Font("Serif", Font.PLAIN, 24));
		
		GUImode3Label = new JButton("1650 x 1050");
		GUImode3Label.setBounds(30,180,200,40);
		GUImode3Label.setActionCommand(Actions.GUIMODE3.name());
		GUImode3Label.addActionListener(instance);
		panel.add(GUImode3Label);
		GUImode3Label.setVisible(false);
		GUImode3Label.setFont(new Font("Serif", Font.PLAIN, 24));
		
		GUImode4Label = new JButton("1440 x 900");
		GUImode4Label.setBounds(30,230,200,40);
		GUImode4Label.setActionCommand(Actions.GUIMODE4.name());
		GUImode4Label.addActionListener(instance);
		panel.add(GUImode4Label);
		GUImode4Label.setVisible(false);
		GUImode4Label.setFont(new Font("Serif", Font.PLAIN, 24));

		GUImode5Label = new JButton("1152 x 720");
		GUImode5Label.setBounds(30,330,200,40);
		GUImode5Label.setActionCommand(Actions.GUIMODE5.name());
		GUImode5Label.addActionListener(instance);
		panel.add(GUImode5Label);
		GUImode5Label.setVisible(false);
		GUImode5Label.setFont(new Font("Serif", Font.PLAIN, 24));
		
		GUImode6Label = new JButton("1024 x 768");
		GUImode6Label.setBounds(30, 380,200,40);
		GUImode6Label.setActionCommand(Actions.GUIMODE6.name());
		GUImode6Label.addActionListener(instance);
		panel.add(GUImode6Label);
		GUImode6Label.setVisible(false);
		GUImode6Label.setFont(new Font("Serif", Font.PLAIN, 24));
		
		GUImode7Label = new JButton("800 x 600");
		GUImode7Label.setBounds(30,430,200,40);
		GUImode7Label.setActionCommand(Actions.GUIMODE7.name());
		GUImode7Label.addActionListener(instance);
		panel.add(GUImode7Label);
		GUImode7Label.setVisible(false);
		GUImode7Label.setFont(new Font("Serif", Font.PLAIN, 24));
		
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
		Save.setVisible(true);
		Load.setVisible(true);
		Options.setVisible(true);
		Quit1.setVisible(true);
		
		PencilLabel.setVisible(true);
		MakePencil.setVisible(true);
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
				Thread.sleep(10);
				Load.setBounds(850, 610, 80, 25);
				}//End of try
			
			catch (InterruptedException e) 
			{//Beginning of catch
				e.printStackTrace();
			}//End of catch
			
			counter +=1;
		}//End of while
		Load.setVisible(true);
	}//End of fill
	
//--------------Options Pane
	public static void options() {
		Save.setVisible(false);
		Load.setVisible(false);
		Options.setVisible(false);
		Back.setVisible(true);
		
		PencilLabel.setVisible(false);
		GUImodeLabel.setVisible(true);
		GUImode1Label.setVisible(true);
		GUImode2Label.setVisible(true);
		GUImode3Label.setVisible(true);
		GUImode4Label.setVisible(true);
		GUImode5Label.setVisible(true);
		GUImode6Label.setVisible(true);
		GUImode7Label.setVisible(true);

	}
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
		else if (e.getActionCommand() == Actions.SAVE.name())
		{//Beginning of else if
			
		}//End of else if
		
		//Return
		else if (e.getActionCommand() == Actions.RETURN.name())
		{//Beginning of else if
			Game();
			Save.setVisible(true);
			Load.setVisible(true);
			Options.setVisible(true);
			Back.setVisible(false);
			
			PencilLabel.setVisible(true);
			GUImodeLabel.setVisible(false);
			GUImode1Label.setVisible(false);
			GUImode2Label.setVisible(false);
			GUImode3Label.setVisible(false);
			GUImode4Label.setVisible(false);
			GUImode5Label.setVisible(false);
			GUImode6Label.setVisible(false);
			GUImode7Label.setVisible(false);
		}//End of else if
		
		//Quit GUI + End code
		else if (e.getActionCommand() == Actions.QUIT.name())
		{//Beginning of else if
			frame.dispose();
		}//End of else if
		
		//Go back to top
		else if (e.getActionCommand() == Actions.OPTIONS.name())
		{//Beginning of else if
			options();
		}//End of else if
		else if (e.getActionCommand() == Actions.GUIMODE1.name())
		{//Beginning of else if
			frame.setSize(1280, 800);
		}//End of else if
		else if (e.getActionCommand() == Actions.GUIMODE2.name())
		{//Beginning of else if
			frame.setSize(2048,1280);
		}//End of else if
		else if (e.getActionCommand() == Actions.GUIMODE3.name())
		{//Beginning of else if
			frame.setSize(1650,1050);
		}//End of else if
		else if (e.getActionCommand() == Actions.GUIMODE4.name())
		{//Beginning of else if
			frame.setSize(1440,900);
		}//End of else if
		else if (e.getActionCommand() == Actions.GUIMODE5.name())
		{//Beginning of else if
			frame.setSize(1152,720);
		}//End of else if
		else if (e.getActionCommand() == Actions.GUIMODE6.name())
		{//Beginning of else if
			frame.setSize(1024,768);
		}//End of else if
		else if (e.getActionCommand() == Actions.GUIMODE7.name())
		{//Beginning of else if
			frame.setSize(800,600);
		}//End of else if
		else if (e.getActionCommand() == Actions.MAKEPENCIL.name())
		{//Beginning of else if
			Pencils +=1;
			PencilLabel.setText("Pencils: " + number.format(Pencils));
			
		}//End of else if
		
	
	}//End of actionPerformed
}//End of Clicker_Game
