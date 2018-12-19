package Algorithms;

import java.awt.Color;
import java.util.Iterator;
import Coords.MyCoords;
import Coords.convert;
import Geom.Fruit;
import Geom.Game;
import Geom.Packman;
import Geom.PathPoint;
import Geom.Point3D;
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
			 }
			 System.out.println("the algo time is: "+algotime);
		}

		}

	
	public double time(Packman p,Fruit f) {
		MyCoords md=new MyCoords();
		double time= 0;
		double road= 0;
		road= md.distance3d(p.Getpoint(),f.Getpoint());
		//time=road/p.Getspeed();
		time=road/p.Getspeed();
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
				 convert m1=new convert(1433,642,35.202306,32.105730,35.212407,32.101867);
				 near_Packman.add2Path(line);
				 addToPointPath(near_Packman,near_Fruit);
				 near_Packman.setPosition(near_Fruit.Getpoint());
				 game.removeFbyId((int)near_Fruit.GetId());
	   }
	   
	   public void addToPointPath(Packman p,Fruit f){
		   MyCoords md=new MyCoords();
		   double distance  =md.distance2d(p.Getpoint(), f.Getpoint());
		   double speed = p.Getspeed();
		   //////////////////////////////////////////////
		  // double pointTime=p.GetPathpoint().get(p.GetPathpoint().size()-1).getTime();
		   double pointTime=0;
		   double numOfPoint=distance/speed;
		   int i=0;
		   while(i<numOfPoint) {
			   distance=md.distance3d(p.Getpoint(), f.Getpoint());
			   Point3D vector=md.vector3D(p.Getpoint(), f.Getpoint());
			   vector=new Point3D(vector.x()/numOfPoint,vector.y()/numOfPoint);
			   Point3D temp=md.add(p.Getpoint(), vector);
			   pointTime=pointTime+1;
			   PathPoint pp=new PathPoint(temp,pointTime) ;
			   p.add2Pathpoint(pp);
			   p.setPosition(temp);
			   i++;
		   }
		   distance  =md.distance2d(p.Getpoint(), f.Getpoint());
		   numOfPoint=distance/speed;
		   while(md.distance2d(p.Getpoint(), f.Getpoint())>1) {
		   distance=md.distance3d(p.Getpoint(), f.Getpoint());
		   Point3D vector=md.vector3D(p.Getpoint(), f.Getpoint());
		   vector=new Point3D(vector.x()/numOfPoint,vector.y()/numOfPoint);
		   Point3D temp=md.add(p.Getpoint(), vector);
		   pointTime=pointTime+1;
		   PathPoint pp=new PathPoint(temp,pointTime) ;
		   p.add2Pathpoint(pp);
		   p.setPosition(temp);
			
		   }
	   }


}
