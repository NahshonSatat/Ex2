package Algorithms;

import java.awt.Color;
import java.util.Iterator;

import Coords.MyCoords;
import Coords.convert;
import Geom.Fruit;
import Geom.Game;
import Geom.Packman;
import Geom.myLine;
import javafx.scene.shape.Line;

public class GameAlgorithem {
	public static void main(String[] args)
	{
		
	}
	private double algotime;
	private Game game;
	public GameAlgorithem(Game g) {
		this.game=g;
	}
	
	public void GoAlgo() {
		if(game.getFruits().isEmpty()) {
			System.out.println("no fruit!");
			// return this.game;
		}
		else {
		while(!(game.getFruits().isEmpty())) {
			firstPackGo();
		}
		
		 Iterator<Packman> it1 =game.getPackmans().iterator();
		 Packman temp_Packman;
			 while(it1.hasNext()) {
				 temp_Packman=(Packman)it1.next();
				 game.addPath2Solution(temp_Packman.GetPath());
				 if(temp_Packman.GetTime()>algotime)
					 algotime= temp_Packman.GetTime();
	         System.out.println("packman id: "+temp_Packman.GetId()+" num of his line "+temp_Packman.getPath().size());
			 }
			 System.out.println("in the algo");
			 System.out.println("the algo time is: "+algotime);
			   //return this.game;
		}

		}

	
	public double time(Packman p,Fruit f) {
		MyCoords md=new MyCoords();
		double time= 0;
		double road= 0;
		road= md.distance3d(p.Getpoint(),f.Getpoint());
		//time=road/p.Getspeed();
		time=road*p.Getspeed();
		return time;
	    }
	
	   public double firstFruitId(Packman p) {
		   if(game.getFruits().isEmpty()) {
			   return 0;
		   }
		   else {
		   double minTime =0;
		  // minTime=time(p,game.getFruits().get(0))+p.GetTime();
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
				 //System.out.println("the near pack is: "+near_Packman.GetId());
				 near_Packman= game.getPackmans().get((int) near_Packman.GetId());
				 Fruit near_Fruit=game.getFruits().get((int)firstFruitId(near_Packman));
				 //System.out.println("the near fruit is: "+near_Fruit.GetId());
				 near_Packman.setTime(near_Time);
				 //myLine l=new myLine(near_Packman.Getpoint(),near_Fruit.Getpoint());
				 Line line=new Line();
				 line.setStartX(near_Packman.Getpoint().x());
				 line.setStartY(near_Packman.Getpoint().y());
				 line.setEndX(near_Fruit.Getpoint().x());
				 line.setEndY(near_Fruit.Getpoint().y());
				 System.out.println("the new line:"+line);
				 convert m1=new convert(1433,642,35.202306,32.105730,35.212407,32.101867);
				 //myLine l1=m1.LineGps2Pix(l);
				 //System.out.println("the new line pixels:"+l1);
				 near_Packman.add2Path(line);
				 //System.out.println("the line enter "+line);
				 System.out.println("num of line "+near_Packman.getPath().size());
				 //System.out.println("the num of line of this pack: "+near_Packman.getPath().size());
				 near_Packman.setPosition(near_Fruit.Getpoint());
				 game.removeFbyId((int)near_Fruit.GetId());
	   }


}
