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
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;

public class Clicker_Game implements ActionListener
{//Beginning of Clicker_Game
	//Global Objects
	
	//------Random GUI Globals
	private static JPanel panel;
	private static JFrame frame;
	private static JLabel WelcomeLabel;
	private static JLabel label1;
	private static JLabel label2;
	private static JSeparator Divider1Label;
	private static JLabel Inspiration1Label;
	private static JLabel Inspiration2Label;
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
	
	//Gui - Game Globals
	public static JButton MakePencil;
	private static JLabel PencilLabel;
	private static JLabel BusinessLabel;
	private static JSeparator Business;
	private static JLabel FundsLabel;
	private static JLabel InventoryLabel;
	private static JButton IncreasePrice;
	private static JButton DecreasePrice;
	private static JLabel PricePerPencilLabel;
	private static JLabel DemandLabel;
	private static JButton MarketingUpgrade;
	private static JLabel MarketingLvlLabel;
	private static JLabel MarketingUpgradeCost;
	private static JLabel ManufacturingLabel;
	private static JSeparator ManufacturingSeperator;
	private static JLabel PencilsPerSecond;
	private static JButton WoodBuy;
	private static JLabel WoodAmtLabel;
	private static JLabel WoodCostLabel;
	private static JButton LeadBuy;
	private static JLabel LeadAmtLabel;
	private static JLabel LeadCostLabel;
	private static JButton AutoAssemblerBuy;
	private static JLabel AutoAssemblerLabel;
	private static JLabel AutoAssemblerCostLabel;
	
	
	//----Miscelaneous 
	public static boolean a = false;//Disabling buttons
	public static boolean b = false;

	public static int c = 0;
	
	//-----Selling
	public static int result = 0;
	public static int SellDemand = 0;
	
	//------Game Objects
	
	public static double Pencils = 0;
	public static double Funds = 0;
	public static double Inventory = 0;
	public static double Price = 0.25;
	public static int Demand = 3200; 
	public static double DemandShow = Demand/100;
	public static double MarketingLvl = 1;
	public static double UpgradeMarketingCost = 100;
	private static double InventorySubbed;
	private static double PencilsPerSecondValue;
	private static double WoodAmt = 0;
	private static double LeadAmt = 0;
	private static double WoodCost = 5;
	private static double LeadCost = 7;
	private static double AssemblerAmt = 0;
	private static double AssemblerCost = 5;
	
	//------Establishing new colours
	public static final Color TAX = new Color(158, 182, 222);
	public static final Color DARK_GREY = new Color(102, 102, 102);
	public static final Color NEWBlUE = new Color(201, 222, 242);
	public static final Color BLACK = new Color(1, 2, 2);
	
	//------Decimal Format
	static DecimalFormat money = new DecimalFormat("$###,###,##0.00");
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
		MAKEPENCIL,
		PRICEDOWN,
		PRICEUP,
		MARKETINGUPGRADE,
		WOOD,
		LEAD,
		ASSEMBLERBUY
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
		
		BufferedImage img1 = null;
		BufferedImage img2 = null;
		try {
			img1 = ImageIO.read(new File("Universal_Paperclips_Title_Screen.png"));
		    img2 = ImageIO.read(new File("LVL1Pencil.png"));
		} catch (IOException e) {
		    e.printStackTrace();
		}
		
		Image dimg = img1.getScaledInstance(600, 450, 100);
		Image eimg = img2.getScaledInstance(40, 30, 100);
		
		//Creating image icons
		ImageIcon image1 = new ImageIcon(dimg);
		ImageIcon image2 = new ImageIcon(eimg);
		
		//image loading screen
		label1 = new JLabel(image1);
		label1.setBounds(350,100,600,450);
		panel.add(label1);
		
		label2 = new JLabel(image2);
		label2.setBounds(5,65,40,30);
		panel.add(label2);
		label2.setVisible(false);
		
		WelcomeLabel = new JLabel("");
		panel.add(WelcomeLabel);
		WelcomeLabel.setHorizontalAlignment(JLabel.CENTER);
		WelcomeLabel.setVisible(false);
		
		Divider1Label = new JSeparator();
		Divider1Label.setBounds(0, 40, 1280, 25);
		panel.add(Divider1Label);
		Divider1Label.setForeground(BLACK);
		Divider1Label.setVisible(false);

		Inspiration1Label = new JLabel("This Game was Heavily Inspired by Universal Paperclips:)");
		Inspiration1Label.setBounds(450,650,400,20);
		panel.add(Inspiration1Label);
		Inspiration1Label.setVisible(true);
		
		Inspiration2Label = new JLabel("https://www.decisionproblem.com/paperclips/");
		Inspiration2Label.setBounds(480,670,400,20);
		panel.add(Inspiration2Label);
		Inspiration2Label.setVisible(true);
		
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
		PencilLabel.setBounds(40, 70, 1240, 25);
		panel.add(PencilLabel);
		PencilLabel.setFont(new Font("Serif", Font.BOLD, 24));
		PencilLabel.setVisible(false);
		
		MakePencil = new JButton("Make Pencil");
		MakePencil.setBounds(10, 110, 120, 25);
		MakePencil.setActionCommand(Actions.MAKEPENCIL.name());
		MakePencil.addActionListener(instance);
		panel.add(MakePencil);
		MakePencil.setVisible(false);
		
		BusinessLabel = new JLabel("Business");
		BusinessLabel.setBounds(20, 160, 100, 25);
		panel.add(BusinessLabel);
		BusinessLabel.setFont(new Font("Serif", Font.BOLD, 18));
		BusinessLabel.setVisible(false);
		
		Business = new JSeparator();
		Business.setBounds(10, 180, 300, 25);
		panel.add(Business);
		Business.setVisible(false);
		Business.setForeground(BLACK);
		
		FundsLabel = new JLabel("Available Funds: " + money.format(Funds));
		FundsLabel.setBounds(20, 190, 400, 25);
		panel.add(FundsLabel);
		FundsLabel.setVisible(false);
		
		InventoryLabel = new JLabel("Unsold Inventory: " + number.format(Inventory));
		InventoryLabel.setBounds(20, 210, 400, 25);
		panel.add(InventoryLabel);
		InventoryLabel.setVisible(false);
		
		PricePerPencilLabel = new JLabel("Price per Pencil: " +money.format(Price));
		PricePerPencilLabel.setBounds(80, 230, 400, 25);
		panel.add(PricePerPencilLabel);
		PricePerPencilLabel.setVisible(false);
				
	    IncreasePrice = new JButton("+");
	    IncreasePrice.setBounds(40, 230, 40, 25);
		IncreasePrice.setActionCommand(Actions.PRICEUP.name());
		IncreasePrice.addActionListener(instance);
		panel.add(IncreasePrice);
		IncreasePrice.setVisible(false);
		
		DecreasePrice = new JButton("-");
		DecreasePrice.setBounds(10, 230, 40, 25);
		DecreasePrice.setActionCommand(Actions.PRICEDOWN.name());
		DecreasePrice.addActionListener(instance);
		panel.add(DecreasePrice);
		DecreasePrice.setVisible(false);
		
		DemandLabel = new JLabel("Public Demand: " + number.format(DemandShow) +"%");
		DemandLabel.setBounds(20, 250, 300, 25);
		panel.add(DemandLabel);
		DemandLabel.setVisible(false);
		
		MarketingUpgrade = new JButton("Marketing");
		MarketingUpgrade.setBounds(10, 290, 100, 25);
		MarketingUpgrade.setActionCommand(Actions.MARKETINGUPGRADE.name());
		MarketingUpgrade.addActionListener(instance);
		panel.add(MarketingUpgrade);
		MarketingUpgrade.setVisible(false);
		MarketingUpgrade.setEnabled(false);
		
		MarketingLvlLabel = new JLabel("Level: " + number.format(MarketingLvl));
		MarketingLvlLabel.setBounds(110, 290, 100, 25);
		panel.add(MarketingLvlLabel);
		MarketingLvlLabel.setVisible(false);

		MarketingUpgradeCost = new JLabel("Cost: " + UpgradeMarketingCost);
		MarketingUpgradeCost.setBounds(20, 310, 100, 25);
		panel.add(MarketingUpgradeCost);
		MarketingUpgradeCost.setVisible(false);
		
		ManufacturingLabel = new JLabel("Manufacturing");
		ManufacturingLabel.setBounds(20, 350, 160, 25);
		panel.add(ManufacturingLabel);
		ManufacturingLabel.setFont(new Font("Serif", Font.BOLD, 18));
		ManufacturingLabel.setVisible(false);
		
		ManufacturingSeperator = new JSeparator();
		ManufacturingSeperator.setBounds(10, 370, 300, 25);
		panel.add(ManufacturingSeperator);
		ManufacturingSeperator.setVisible(false);
		ManufacturingSeperator.setForeground(BLACK);
		
		PencilsPerSecond = new JLabel("Pencils per Second: " + number.format(PencilsPerSecondValue));
		PencilsPerSecond.setBounds(20, 380, 300, 25);
		panel.add(PencilsPerSecond);
		PencilsPerSecond.setVisible(false);
		
		WoodBuy = new JButton("Wood");
		WoodBuy.setBounds(10,410,80,25);
		WoodBuy.setActionCommand(Actions.WOOD.name());
		WoodBuy.addActionListener(instance);
		panel.add(WoodBuy);
		WoodBuy.setVisible(false);
		WoodBuy.setEnabled(false);
		
		WoodAmtLabel = new JLabel(number.format(WoodAmt) + " pieces");
		WoodAmtLabel.setBounds(90, 410, 300, 25);
		panel.add(WoodAmtLabel);
		WoodAmtLabel.setVisible(false);
		
		WoodCostLabel = new JLabel("Cost: " + money.format(WoodCost));
		WoodCostLabel.setBounds(20, 430, 300, 25);
		panel.add(WoodCostLabel);
		WoodCostLabel.setVisible(false);
		
		LeadBuy = new JButton("Lead");
		LeadBuy.setBounds(10,470,80,25);
		LeadBuy.setActionCommand(Actions.LEAD.name());
		LeadBuy.addActionListener(instance);
		panel.add(LeadBuy);
		LeadBuy.setVisible(false);
		LeadBuy.setEnabled(false);
		
		LeadAmtLabel = new JLabel(number.format(LeadAmt) + " rods");
		LeadAmtLabel.setBounds(90, 470, 300, 25);
		panel.add(LeadAmtLabel);
		LeadAmtLabel.setVisible(false);
		
		LeadCostLabel = new JLabel("Cost: " + money.format(LeadCost));
		LeadCostLabel.setBounds(20, 490, 300, 25);
		panel.add(LeadCostLabel);
		LeadCostLabel.setVisible(false);
		
		AutoAssemblerBuy = new JButton("AutoAssemblers");
		AutoAssemblerBuy.setBounds(10,530,150,25);
		AutoAssemblerBuy.setActionCommand(Actions.ASSEMBLERBUY.name());
		AutoAssemblerBuy.addActionListener(instance);
		panel.add(AutoAssemblerBuy);
		AutoAssemblerBuy.setVisible(false);
		AutoAssemblerBuy.setEnabled(false);
		
		AutoAssemblerLabel = new JLabel(number.format(AssemblerAmt));
		AutoAssemblerLabel.setBounds(160, 530, 300, 25);
		panel.add(AutoAssemblerLabel);
		AutoAssemblerLabel.setVisible(false);
		
		AutoAssemblerCostLabel = new JLabel("Cost: " + money.format(AssemblerCost));
		AutoAssemblerCostLabel.setBounds(20, 550, 300, 25);
		panel.add(AutoAssemblerCostLabel);
		AutoAssemblerCostLabel.setVisible(false);
		
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
		Modes();
	}
	public static void Modes() {
		Timer timer = new Timer();
		timer.schedule(new Timer_Sell(), 0, 5000);
	}
	public static void Game() {
		//Hides Load - Specific Elements
		label1.setVisible(false);
		bar.setVisible(false);
		Inspiration1Label.setVisible(false);
		Inspiration2Label.setVisible(false);
		//Shows Game - Specific Elements
		label2.setVisible(true);
		WelcomeLabel.setVisible(true);
		Divider1Label.setVisible(true);
		Save.setVisible(true);
		Load.setVisible(true);
		Options.setVisible(true);
		Quit1.setVisible(true);
		
		PencilLabel.setVisible(true);
		MakePencil.setVisible(true);
		BusinessLabel.setVisible(true);
		Business.setVisible(true);
		FundsLabel.setVisible(true);
		InventoryLabel.setVisible(true);
		PricePerPencilLabel.setVisible(true);
		IncreasePrice.setVisible(true);
		DecreasePrice.setVisible(true);
		DemandLabel.setVisible(true);
		MarketingUpgrade.setVisible(true);
		MarketingLvlLabel.setVisible(true);
		MarketingUpgradeCost.setVisible(true);
		ManufacturingLabel.setVisible(true);
		ManufacturingSeperator.setVisible(true);
		PencilsPerSecond.setVisible(true);
		WoodBuy.setVisible(true);
		WoodAmtLabel.setVisible(true);
		WoodCostLabel.setVisible(true);
		LeadBuy.setVisible(true);
		LeadAmtLabel.setVisible(true);
		LeadCostLabel.setVisible(true);
		AutoAssemblerBuy.setVisible(true);
		AutoAssemblerLabel.setVisible(true);
		AutoAssemblerCostLabel.setVisible(true);
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
			DemandShow = Demand/100;
			if(Funds >= UpgradeMarketingCost) {
				MarketingUpgrade.setEnabled(true);
			}
			if(Funds >= WoodCost) {
				WoodBuy.setEnabled(true);
			}
			if(Funds >= LeadCost) {
				LeadBuy.setEnabled(true);
			}
			if(Funds >= AssemblerCost) {
				AutoAssemblerBuy.setEnabled(true);
			}
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
		MakePencil.setVisible(false);
		BusinessLabel.setVisible(false);
		Business.setVisible(false);
		FundsLabel.setVisible(false);
		InventoryLabel.setVisible(false);
		PricePerPencilLabel.setVisible(false);
		IncreasePrice.setVisible(false);
		DecreasePrice.setVisible(false);
		DemandLabel.setVisible(false);
		MarketingUpgrade.setVisible(false);
		MarketingLvlLabel.setVisible(false);
		MarketingUpgradeCost.setVisible(false);
		label2.setVisible(false);
		ManufacturingLabel.setVisible(false);
		ManufacturingSeperator.setVisible(false);
		PencilsPerSecond.setVisible(false);
		WoodBuy.setVisible(false);
		WoodAmtLabel.setVisible(false);
		WoodCostLabel.setVisible(false);
		LeadBuy.setVisible(false);
		LeadAmtLabel.setVisible(false);
		LeadCostLabel.setVisible(false);
		AutoAssemblerBuy.setVisible(false);
		AutoAssemblerLabel.setVisible(false);
		AutoAssemblerCostLabel.setVisible(false);
		
		GUImodeLabel.setVisible(true);
		GUImode1Label.setVisible(true);
		GUImode2Label.setVisible(true);
		GUImode3Label.setVisible(true);
		GUImode4Label.setVisible(true);
		GUImode5Label.setVisible(true);
		GUImode6Label.setVisible(true);
		GUImode7Label.setVisible(true);

	}
	
	public static void SellCalcs() {
		if(Inventory ==  0) {
		}
		else if(Inventory > 0) {
			if(Inventory == 1)
			{
				if (Demand > 0 && Demand <= 1000) {
					SellDemand =1;
				}
				if (Demand > 1000 && Demand <= 2000) {
					SellDemand =1;
				}
				if (Demand > 2000 && Demand <= 3000) {
					SellDemand =1;
				}
				if (Demand > 3000 && Demand <= 4000) {
					SellDemand =1;
				}
				if (Demand > 4000 && Demand <= 5000) {
					SellDemand =1;
				}
				if (Demand > 5000) {
					SellDemand =1;
				}
			}
			else if (Inventory == 2) {
				if (Demand > 0 && Demand <= 1000) {
					SellDemand =1;
				}
				if (Demand > 1000 && Demand <= 2000) {
					SellDemand =2;
				}
				if (Demand > 2000 && Demand <= 3000) {
					SellDemand =2;
				}
				if (Demand > 3000 && Demand <= 4000) {
					SellDemand =2;
				}
				if (Demand > 4000 && Demand <= 5000) {
					SellDemand =2;
				}
				if (Demand > 5000) {
					SellDemand =2;
				}
			}
			else if (Inventory == 3) {
				if (Demand > 0 && Demand <= 1000) {
					SellDemand =1;
				}
				if (Demand > 1000 && Demand <= 2000) {
					SellDemand =2;
				}
				if (Demand > 2000 && Demand <= 3000) {
					SellDemand =3;
				}
				if (Demand > 3000 && Demand <= 4000) {
					SellDemand =3;
				}
				if (Demand > 4000 && Demand <= 5000) {
					SellDemand =3;
				}
				if (Demand > 5000) {
					SellDemand =3;
				}
			}
			else if (Inventory == 4) {
				if (Demand > 0 && Demand <= 1000) {
					SellDemand =1;
				}
				if (Demand > 1000 && Demand <= 2000) {
					SellDemand =2;
				}
				if (Demand > 2000 && Demand <= 3000) {
					SellDemand =3;
				}
				if (Demand > 3000 && Demand <= 4000) {
					SellDemand =4;
				}
				if (Demand > 4000 && Demand <= 5000) {
					SellDemand =4;
				}
				if (Demand > 5000) {
					SellDemand =4;
				}
			}
			else if (Inventory >= 5 && Inventory <= 9) {
				if (Demand > 0 && Demand <= 1000) {
					SellDemand =1;
				}
				if (Demand > 1000 && Demand <= 2000) {
					SellDemand =2;
				}
				if (Demand > 2000 && Demand <= 3000) {
					SellDemand =3;
				}
				if (Demand > 3000 && Demand <= 4000) {
					SellDemand =4;
				}
				if (Demand > 4000 && Demand <= 5000) {
					SellDemand =5;
				}
				if (Demand > 5000) {
					SellDemand =5;
				}
			}
			else if (Inventory >= 10) {
				if (Demand > 0 && Demand <= 1000) {
					SellDemand =1;
				}
				if (Demand > 1000 && Demand <= 2000) {
					SellDemand =2;
				}
				if (Demand > 2000 && Demand <= 3000) {
					SellDemand =3;
				}
				if (Demand > 3000 && Demand <= 4000) {
					SellDemand =4;
				}
				if (Demand > 4000 && Demand <= 5000) {
					SellDemand =5;
				}
				if (Demand > 5000) {
					SellDemand =10;
				}
			}
			Inventory -= SellDemand;
			InventorySubbed = SellDemand;
			Funds += InventorySubbed*Price;
			InventoryLabel.setText("Unsold Inventory: " + number.format(Inventory));
			FundsLabel.setText("Available Funds: " + money.format(Funds));
		}
		
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
			Inventory += 1;
			PencilLabel.setText("Pencils: " + number.format(Pencils));
			InventoryLabel.setText("Unsold Inventory: " + number.format(Inventory));
		}//End of else if
		else if (e.getActionCommand() == Actions.PRICEDOWN.name())
		{//Beginning of else if
		
		if (Price >=0.01) {
			
			
			if (Price >= 0.01 && Price <=0.05) {
				Demand += 1000;
			}
			else if(Price >= 0.06 && Price <=0.10) {
				Demand += 500;
			}
			else if(Price >= 0.11 && Price <=0.15) {
				Demand += 300;
			} 
			else if(Price >= 0.16 && Price <=0.20) {
				Demand += 200;
			} 
			else if(Price >= 0.21 && Price <=0.25) {
				Demand += 100;
			}
			else if(Price >= 0.26 && Price <=0.30) {
				Demand += 50;
			}
			else if(Price >= 0.31) {
				Demand += 25;
			}
			Price -= 0.01;
		}
		DemandShow = Demand/100;
		
		DemandLabel.setText("Public Demand: " + number.format(DemandShow) +"%");
		PricePerPencilLabel.setText("Price per Pencil: " +money.format(Price));
		}
		else if (e.getActionCommand() == Actions.PRICEUP.name())
		{//Beginning of else if
		
		if (Demand >=1) {
		
		if (Price >= 0.01 && Price <=0.05) {
			Demand -= 1000;
		}
		else if(Price >= 0.06 && Price <=0.10) {
			Demand -= 500;
		}
		else if(Price >= 0.11 && Price <=0.15) {
			Demand -= 300;
		} 
		else if(Price >= 0.16 && Price <=0.20) {
			Demand -= 200;
		} 
		else if(Price >= 0.21 && Price <=0.25) {
			Demand -= 100;
		}
		else if(Price >= 0.26 && Price <=0.30) {
			Demand -= 50;
		}
		else if(Price >= 0.31) {
			Demand -= 25;
		}
		else if(Price == 1.44) {
		}
		Price += 0.01;
		}
		
		DemandShow = Demand/100;
		
		DemandLabel.setText("Public Demand: " + number.format(DemandShow) +"%");
		PricePerPencilLabel.setText("Price per Pencil: " +money.format(Price));
		}
		else if (e.getActionCommand() == Actions.MARKETINGUPGRADE.name())
		{//Beginning of else if
		if (Funds >= UpgradeMarketingCost) {
			MarketingLvl += 1;
			Funds -= UpgradeMarketingCost;
			Demand += 200;
			DemandShow = Demand/100;
			MarketingLvlLabel.setText("Level: " + number.format(MarketingLvl));
			DemandLabel.setText("Public Demand: " + number.format(DemandShow) +"%");
			FundsLabel.setText("Available Funds: " + money.format(Funds));
		}
		else if (e.getActionCommand() == Actions.WOOD.name())
		{
			if (Funds >= WoodCost) {
				WoodAmt += 1;
				Funds -= WoodCost;
				WoodAmtLabel.setText(number.format(WoodAmt) + " pieces");
				FundsLabel.setText("Available Funds: " + money.format(Funds));
			}
		}	
		else if (e.getActionCommand() == Actions.LEAD.name())
		{
			if (Funds >= LeadCost) {
				LeadAmt += 1;
				Funds -= LeadCost;
				LeadAmtLabel.setText(number.format(LeadAmt) + " rods");
				FundsLabel.setText("Available Funds: " + money.format(Funds));
			}
		}
			
		else if (e.getActionCommand() == Actions.ASSEMBLERBUY.name())
		{
			if (Funds >= AssemblerCost) {
				AssemblerAmt += 1;
				Funds -= AssemblerCost;
				AutoAssemblerLabel.setText(number.format(AssemblerAmt));
				FundsLabel.setText("Available Funds: " + money.format(Funds));
			}
		}
		}
	}//End of actionPerformed
}//End of Clicker_Game
