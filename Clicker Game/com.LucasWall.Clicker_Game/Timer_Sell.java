package com.LucasWall.Clicker_Game;

import java.util.TimerTask;

class Timer_Sell extends TimerTask{

	
	
	@Override
	public void run() {
		Clicker_Game callClass = new Clicker_Game();
		callClass.SellCalcs();
		
		
		
	}
	public static void main(String[] args) {
		
	}
}

