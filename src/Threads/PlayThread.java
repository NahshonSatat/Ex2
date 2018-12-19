package Threads;

import Geom.Game;

public class PlayThread implements Runnable {



		@Override
		public void run() 
		{
			
		}
	
	public static void sleep(int i) {
		try {
			Thread.sleep(i);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



}
