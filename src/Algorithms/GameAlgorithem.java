package Algorithms;

import java.awt.Color;
import java.util.Iterator;

import Coords.MyCoords;
import Geom.Fruit;
import Geom.Game;
import Geom.Line;
import Geom.Packman;
import Geom.myLine;

public class GameAlgorithem {
	  
	private Game game;
	public GameAlgorithem(Game g) {
		this.game=g;
	}
	
	public Game GoAlgo() {
		int i=0;
		while(!game.getFruits().isEmpty()) {
			firstPackGo();
			System.out.println(i);
			i++;
		}
		System.out.println("done!!");
	   return this.game;
		
	}
	
	public double time(Packman p,Fruit f) {
		MyCoords md=new MyCoords();
		double time= 0;
		double road= 0;
		road= md.distance3d(p.Getpoint(),f.Getpoint());
		time=road*p.Getspeed();
		return time;
	    }
	
	   public double firstFruitId(Packman p) {
		   double minTime =0;
		   double minFruitId=0;
			 Iterator<Fruit> it2 =game.getFruits().iterator();
			 Fruit temp_Fruit ;
				// run over all the Fruit
				 while(it2.hasNext()) {
					 temp_Fruit=(Fruit)it2.next();
		            if(time(p,temp_Fruit)+p.GetTime()<minTime) {
		            	minTime=time(p,temp_Fruit)+p.GetTime();
		            	minFruitId=temp_Fruit.GetId();
		            }
				 }
				 return minFruitId;
	       }
	   
	   public void firstPackGo() {
		   Packman near_Packman =new Packman(game.getPackmans().get(0));
		   double near_Time=near_Packman.GetTime()+time(near_Packman, game.getFruits().get((int)firstFruitId(near_Packman)));
		   double temp_time=0;
		   Iterator<Packman> it1 =game.getPackmans().iterator();
			 Packman temp_Packman ;
				 while(it1.hasNext()) {
					 temp_Packman=(Packman)it1.next();
					 temp_time=temp_Packman.GetTime()+time(temp_Packman, game.getFruits().get((int)firstFruitId(temp_Packman)));
                     if(temp_time<near_Time) {
                    	 near_Packman= new Packman(temp_Packman);
                    	 near_Time=temp_time;
                     }
				 }
				 near_Packman= game.getPackmans().get((int) near_Packman.GetId());
				 Fruit near_Fruit=game.getFruits().get((int)firstFruitId(near_Packman));
				 near_Packman.setTime(near_Time);
				 myLine l=new myLine(near_Packman.Getpoint(),near_Fruit.Getpoint());
				 near_Packman.add2Path(l);
				 near_Packman.setPosition(near_Fruit.Getpoint());
				 game.getFruits().remove(near_Fruit.GetId());
	   }


}
