/* Name:Lucas Wall
* Class code: ICS3U 
* Date:Friday, February 26, 2022 
* Assignment #: 8
* Description: Created a GUI to represent Income Tax calculations in a easily legible manner.
* Variables, Constants, Decimal Formatting, Scanner-Kind of(.get Text()), If statements, do while, 
*/
package com.LucasWall.Clicker_Game;

//Imports
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;

public class Clicker_Game implements ActionListener
{//Beginning of Clicker_Game
	//Global Objects
	//--Random GUI Globals
	private static JPanel panel;
	private static JFrame frame;
	private static JLabel WelcomeLabel;
	private static JLabel label1;
	private static JLabel label2;
	private static JLabel Divider1Label;
	private static JLabel EnterLabel;
	private static JLabel FNameLabel;
	private static JTextField FNameText;
	private static JLabel LNameLabel;
	private static JTextField LNameText;
	private static JLabel SinLabel;
	private static JTextField SinText1;
	private static JTextField SinText2;
	private static JTextField SinText3;
	private static JLabel CityLabel;
	private static JLabel ProvinceLabel;
	private static JLabel IncomeLabel;
	private static JTextField IncomeText;
	private static JButton Calculate;
	private static JButton Brackets;
	private static JButton Recalculate;
	private static JLabel RevenueCanadaLabel;
	private static JLabel IncomeTax2021;
	private static JLabel InfoEarn;
	private static JLabel NameVar;
	private static JLabel SinVar;
	private static JLabel ResidenceVar;
	private static JLabel YrEarn;
	private static JLabel FedTax;
	private static JLabel ProvTax;
	private static JLabel TotTax;
	private static JLabel EarnaftTax;
	public static String FName = "";
	public static String LName = "";
	public static double SIN1 = 0;
	public static double SIN2 = 0;
	public static double SIN3 = 0;
	public static String City = "";
	public static String YrEarnings = "";
	public static JComboBox<String> jComboBox;
	public static Clicker_Game instance;
	private static JLabel FTBR;
	private static JLabel PTBR;
	private static JButton Return;
	private static JButton Quit1;
	private static JButton Quit2;
	private static JButton Quit3;
	public static JProgressBar bar = new JProgressBar();
	public static int counter = 0;
	public static JLabel FederalBr1;
	public static JLabel FederalBr2;
	public static JLabel FederalBr3;
	public static JLabel FederalBr4;
	public static JLabel FederalBr5;
	public static JLabel ProvincialBr1;
	public static JLabel ProvincialBr2;
	public static JLabel ProvincialBr3;
	public static JLabel ProvincialBr4;
	public static JLabel ProvincialBr5;

	
	//Calculation Globals
	public static final double RATE1 = 0.0505; // Provincial tax rates
	public static final double RATE2 = 0.0915;
	public static final double RATE3 = 0.116;
	public static final double RATE4 = 0.1216;
	public static final double RATE5 = 0.1316;
	public static final double T1 = 45142; // Provincial tax brackets
	public static final double T2 = 90287;
	public static final double T3 = 150000;
	public static final double T4 = 220000;
	public static final double fRATE1 = 0.15; // Federal tax rates
	public static final double fRATE2 = 0.205;
	public static final double fRATE3 = 0.26;
	public static final double fRATE4 = 0.29;
	public static final double fRATE5 = 0.33;
	
	public static boolean BR1 = false;
	public static boolean BR2 = false;
	public static boolean BR3 = false;
	public static boolean BR4 = false;
	public static boolean BR5 = false;

	public static boolean fBR1 = false;
	public static boolean fBR2 = false;
	public static boolean fBR3 = false;
	public static boolean fBR4 = false;
	public static boolean fBR5 = false;

	public static final double fT1 = 49020; // Federal tax brackets
	public static final double fT2 = 98040;
	public static final double fT3 = 151978;
	public static final double fT4 = 216511;

	static String Province = "Ontario";
	static String Country = "Canada";
	static double income = 0;
	static double tax = 0;
	static double ftax = 0;
	static double TotalTax = 0;
	static double TotalEarnAftTax = 0;
	
	// Establishing new colours
	public static final Color TAX = new Color(158, 182, 222);
	public static final Color DARK_GREY = new Color(102, 102, 102);
	public static final Color NEWBlUE = new Color(201, 222, 242);
	static DecimalFormat money = new DecimalFormat("$###,###,###.##");

	public enum Actions
	{//Beginning of Actions
		CALCULATE,
		BRACKETS,
		RETURN,
		QUIT,
		RECALCULATE
	}//End of Actions
	
	public static void main(String[] args) 
	{//Beginning of main
		Clicker_Game instance = new Clicker_Game();
		String[] optionsToChoose = { "Barrie", "Belleville", "Cambridge", "Guelph", "Hamilton", "Kingston", "Kitchener",
				"London", "Markham", "Orillia", "Oshawa", "Ottawa", "Peterborough", "Pickering", "Richmond Hill",
				"Thunder Bay", "Timmins", "Toronto", "Vaughan", "Waterloo", "Welland", "Windsor" };

		//-----Creating GUI
		//new panel
		panel = new JPanel();
		
		//Loading bar
		bar.setValue(0);
		bar.setBounds(50,240,500,50);
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
		
		frame.getContentPane().addComponentListener(new ComponentAdapter() {
			public void componentResized(ComponentEvent e) {
				Component c = (Component)e.getSource();
				frame.setTitle("W: " + c.getWidth() + "H: " + c.getHeight());
				int a = c.getWidth();
				//Equation to find % , original # Ex 30/600
				double numaEnterLabel = a * 0.016;//10/600
				double numaFNameLabel = a * 0.05;//30/600
				double numaFNameText = a * 0.19;//115/600
				double numaLNameLabel = a * 0.45;//275/600
				double numaLNameText = a * 0.6;//360/600
				
				int b = c.getHeight();
				double numbEnterLabel = b * 0.1;//40/400
				double numbFNameLabel = b * 0.162;//65/400
				double numbFTextLabel = b * 0.162;//...
				double numbLNameLabel = b * 0.162;
				double numbLTextLabel = b * 0.162;
				
				//double var2 = a * 0.521;
				WelcomeLabel.setBounds(10, 10, a, 25);
				label1.setBounds(50,30,a,200);
				label2.setBounds(490,10,a,40);
				Divider1Label.setBounds(10, 20, a, 25);
				EnterLabel.setBounds((int) numaEnterLabel, (int) numbEnterLabel, 200, 25);
				FNameLabel.setBounds((int) numaFNameLabel, (int) numbFNameLabel, 80, 25);
				FNameText.setBounds((int) numaFNameText, (int) numbFTextLabel, 100, 25);
				LNameLabel.setBounds((int) numaLNameLabel, (int) numbLNameLabel, 80, 25);
				LNameText.setBounds((int) numaLNameText, (int) numbLTextLabel, 100, 25);
				
			}
		});
		
		WelcomeLabel = new JLabel("Welcome to Fast Tax!");
		WelcomeLabel.setBounds(10, 10, 600, 25);
		panel.add(WelcomeLabel);
		WelcomeLabel.setHorizontalAlignment(JLabel.CENTER);
	
		
		//image loading screen
		label1 = new JLabel("Clicker Game");
		label1.setBounds(50,30,500,200);
		label1.setFont(new Font("Serif", Font.PLAIN, 72));
		label1.setHorizontalAlignment(JLabel.CENTER);
		panel.add(label1);
		
		//same image - small version
		label2 = new JLabel("");
		label2.setBounds(490,10,100,40);
		panel.add(label2);
		
		Divider1Label = new JLabel("____________________");
		Divider1Label.setBounds(10, 20, 600, 25);
		panel.add(Divider1Label);
		Divider1Label.setHorizontalAlignment(JLabel.CENTER);

		EnterLabel = new JLabel("Please Enter Your Information Below");
		EnterLabel.setBounds(10, 40, 250, 25);
		panel.add(EnterLabel);

		FNameLabel = new JLabel("First Name:");
		FNameLabel.setBounds(30, 65, 80, 25);
		panel.add(FNameLabel);

		FNameText = new JTextField(20);
		FNameText.setBounds(115, 65, 100, 25);
		panel.add(FNameText);

		LNameLabel = new JLabel("Last Name:");
		LNameLabel.setBounds(275, 65, 80, 25);
		panel.add(LNameLabel);

		LNameText = new JTextField(20);
		LNameText.setBounds(360, 65, 100, 25);
		panel.add(LNameText);

		SinLabel = new JLabel("9-Digit Social Insurance Number:");
		SinLabel.setBounds(30, 110, 350, 25);
		panel.add(SinLabel);

		SinText1 = new JTextField(20);
		SinText1.setBounds(260, 110, 40, 25);
		panel.add(SinText1);

		SinText2 = new JTextField(20);
		SinText2.setBounds(300, 110, 40, 25);
		panel.add(SinText2);

		SinText3 = new JTextField(20);
		SinText3.setBounds(340, 110, 40, 25);
		panel.add(SinText3);

		CityLabel = new JLabel("City:");
		CityLabel.setBounds(30, 160, 150, 25);
		panel.add(CityLabel);

		jComboBox = new JComboBox<>(optionsToChoose);
		jComboBox.setBounds(70, 165, 150, 20);
		panel.add(jComboBox);

		ProvinceLabel = new JLabel("Ontario, Canada");
		ProvinceLabel.setBounds(270, 160, 150, 25);
		panel.add(ProvinceLabel);

		IncomeLabel = new JLabel("Enter your Income:");
		IncomeLabel.setBounds(30, 210, 120, 25);
		panel.add(IncomeLabel);

		IncomeText = new JTextField(20);
		IncomeText.setBounds(160, 210, 100, 25);
		panel.add(IncomeText);

		Calculate = new JButton("Calculate");
		Calculate.setBounds(10, 300, 585, 25);
		Calculate.setActionCommand(Actions.CALCULATE.name());
		Calculate.addActionListener(instance);
		panel.add(Calculate);
		
		Quit1 = new JButton("Quit");
		Quit1.setBounds(10, 10, 80, 25);
		Quit1.setActionCommand(Actions.QUIT.name());
		Quit1.addActionListener(instance);
		panel.add(Quit1);
		
		//set frame to visible
		frame.setVisible(true);
		frame.setTitle("Fast Tax, The Fastest Tax Thing!");
		
		if (panel.isVisible()) 
		{//Beginning of if
			fill();
		}//End of if
		
	}//End of main

	public static void fill()
	{//Beginning of fill
		int counter = 0;
		
		while(counter<=100) 
		{//Beginning of while
			bar.setValue(counter);
			try {//Beginning of try
				//Make invisble while loading
				Thread.sleep(25);
				label1.setVisible(true);
				label2.setVisible(false);
				WelcomeLabel.setVisible(false);
				Divider1Label.setVisible(false);
				EnterLabel.setVisible(false);
				FNameLabel.setVisible(false);
				FNameText.setVisible(false);
				LNameLabel.setVisible(false);
				LNameText.setVisible(false);
				SinLabel.setVisible(false);
				SinText1.setVisible(false);
				SinText2.setVisible(false);
				SinText3.setVisible(false);
				CityLabel.setVisible(false);
				jComboBox.setVisible(false);
				ProvinceLabel.setVisible(false);
				IncomeLabel.setVisible(false);
				IncomeText.setVisible(false);
				Calculate.setVisible(false);
				Quit1.setVisible(false);
				}//End of try
			
			catch (InterruptedException e) 
			{//Beginning of catch
				e.printStackTrace();
			}//End of catch
			
			counter +=1;
		}//End of while
		
		//Make visible after loading
		label1.setVisible(false);
		label2.setVisible(true);
		bar.setVisible(false);
		WelcomeLabel.setVisible(true);
		Divider1Label.setVisible(true);
		EnterLabel.setVisible(true);
		FNameLabel.setVisible(true);
		FNameText.setVisible(true);
		LNameLabel.setVisible(true);
		LNameText.setVisible(true);
		SinLabel.setVisible(true);
		SinText1.setVisible(true);
		SinText2.setVisible(true);
		SinText3.setVisible(true);
		CityLabel.setVisible(true);
		jComboBox.setVisible(true);
		ProvinceLabel.setVisible(true);
		IncomeLabel.setVisible(true);
		IncomeText.setVisible(true);
		Calculate.setVisible(true);
		Quit1.setVisible(true);
		
	}//End of fill

	public static void DataCollection()
	{//Beginning of DataCollection
		YrEarnings = IncomeText.getText();
		int income = Integer.parseInt(YrEarnings);

		if (income <= 0)
		{//Beginning of if
			System.out.println("Income cannot be less than or equal to 0, try again");
			main(null);
		}//End of if
		else
		{//Beginning of else
			TaxMath(null);
		}//End of else
	}//End of Data Collection

	public static void TaxMath(String[] args)
	{//Beginning of TaxMath
		//--------Calculations
		YrEarnings = IncomeText.getText();
		int income = Integer.parseInt(YrEarnings);

		if (Province == "Ontario")
		{ // PROVINCIAL TAX
		// ---------------------------------------------------------------------------
			if (income <= T1)
			{ // Bracket 1 between 1 and 45142
				tax = RATE1 * income;
				BR1 = true;
			}
			else if (income <= T2)
			{ // Bracket 2 between 45142 and 90287
				tax = RATE1 * T1 + RATE2 * (income - T1);
				BR1= true;
				BR2 = true;
			}
			else if (income <= T3)
			{ // Bracket 3 between 90287 and 150000
				//(income-T1)
				tax = RATE1 * T1 + RATE2 * (income - T1) + RATE3 * (income - T2);
				BR1 = true;
				BR2 = true;
				BR3 = true;
			}
			else if (income <= T4)
			{// Bracket 4 between 150000 and 200000
				tax = RATE1 * T1 + RATE2 * (income - T1) + RATE3 * (income - T2) + RATE4 * (income - T3);
				BR1 = true;
				BR2 = true;
				BR3 = true;
				BR4 = true;

			}
			else
			{ // Bracket 5 above 200000
				tax = RATE1 * T1 + RATE2 * (income - T1) + RATE3 * (income - T2) + RATE4 * (income - T3) + RATE5 * (income - T4);
				BR1 = true;
				BR2 = true;
				BR3 = true;
				BR4 = true;
				BR5 = true;
			}
		}

		if (Country == "Canada")
		{ // FEDERAL TAX
			// ---------------------------------------------------------------------------------------------
			if (income <= fT1)
			{ // Bracket 1 between 1 and 45142
				ftax = fRATE1 * income;
				fBR1 = true;
			}
			else if (income <= fT2)
			{ // Bracket 2 between 45142 and 90287
				ftax = fRATE1 * fT1 + fRATE2 * (income - fT1);
				fBR1 = true;
				fBR2 = true;
			}
			else if (income <= fT3)
			{ // Bracket 3 between 90287 and 150000
				ftax = fRATE1 * fT1 + fRATE2 * (income - fT1) + fRATE3 * (income - fT2);
				fBR1 = true;
				fBR2 = true;
				fBR3 = true;
			}
			else if (income <= fT4)
			{ // Bracket 4 between 150000 and 200000
				ftax = fRATE1 * fT1 + fRATE2 * (income - fT1) + fRATE3 * (income - fT2) + fRATE4 * (income - fT3);
				fBR1 = true;
				fBR2 = true;
				fBR3 = true;
				fBR4 = true;

			}
			else
			{ // Bracket 5 above 200000
				ftax = fRATE1 * fT1 + fRATE2 * (income - fT1) + fRATE3 * (income - fT2) + fRATE4 * (income - fT3) + fRATE5 * (income - fT4);
				fBR1 = true;
				fBR2 = true;
				fBR3 = true;
				fBR4 = true;
				fBR5 = true;
			}
		}
	}
	//If button pressed
	@Override
	public void actionPerformed(ActionEvent e)
	{//Beginning of actionPerformed
		
		//Button Calculate
		if (e.getActionCommand() == Actions.CALCULATE.name())
		{//Beginning of if
			frame.dispose();
			DataCollection();	
			System.out.println("Calculate");
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
			DataCollection();
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
			//Set tax brackets to false before going to the top.
			BR1 = false;
			BR2 = false;
			BR3 = false;
			BR4 = false;
			BR5 = false;

			fBR1 = false;
			fBR2 = false;
			fBR3 = false;
			fBR4 = false;
			fBR5 = false;
			main(null);
		}//End of else if
	}//End of actionPerformed
}//End of Clicker_Game
