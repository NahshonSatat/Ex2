package Coords;

import Geom.Fruit;
import Geom.Line;
import Geom.Packman;
import Geom.myLine;

public class convert {
	int mapWidth;
	int mapHeight;
	double mapLongitudeStart;
	double mapLatitudeStart;
	double mapLongitude;
	double mapLatitude;
	// according to https://stackoverflow.com/questions/38748832/convert-longitude-and-latitude-coordinates-to-image-of-a-map-pixels-x-and-y-coor
	
	
	public convert(int mapWidth,int mapHeight,double mapLongitudeStart,double mapLatitudeStart,double mapLongitudeEnd,double mapLatitudeEnd) {
		this.mapWidth=mapWidth;
		this.mapHeight=mapHeight;
		this.mapLongitudeStart=mapLongitudeStart;
		this.mapLatitudeStart=mapLatitudeStart;
		this.mapLongitude=mapLongitudeEnd-mapLongitudeStart;
		this.mapLatitude=mapLatitudeStart-mapLatitudeEnd;
		
	}
	 
	public Packman PacPix2Gps(Packman p) {
		double xPIX=p.Getpoint().x();
		double yPIX=p.Getpoint().y();
		   double x=xPIX*mapLongitude ;//;
		   //System.out.println(z);
		   x=x/(mapWidth);
		  // System.out.println(z);
		   x=x +mapLongitudeStart;
	       //System.out.println(x);
	       double y=yPIX*mapLatitude;
	       y=y/mapHeight;
	       y=y-mapLatitudeStart;
	       y=y*(-1);
	       //System.out.println(x+","+y);
	       Packman p1=new Packman(y,x,p.Getpoint().z(),p.Getspeed(),p.GetId(),p.GetRadius());
	       return p1;
	}
	public Packman PacGps2Pix(Packman p) {
	    double x,y;
	    x=p.Getpoint().y() - mapLongitudeStart;
	   // System.out.println(x);
	    // do inverse because the latitude increases as we go up but the y decreases as we go up.
	    // if we didn't do the inverse then all the y values would be negative.
	    y = mapLatitudeStart-p.Getpoint().x();
	    //System.out.println(y);
	    // set x & y using conversion
	    int x1 = (int) (mapWidth*(x/mapLongitude));
	    int y1 = (int) (mapHeight*(y/mapLatitude));
       // System.out.println((int)x1+","+ (int)y1);
        Packman p1=new Packman(x1,y1,p.Getpoint().z(),p.Getspeed(),p.GetId(),p.GetRadius());
       // System.out.println(p1);
        return p1;
	}
	
	
	public myLine LineGps2Pix(myLine l) {
	    double sx,sy,ex,ey;
	    sx=l.getStart().y() - mapLongitudeStart;
	    ex=l.getEnd().y() - mapLongitudeStart;
	   // System.out.println(x);
	    // do inverse because the latitude increases as we go up but the y decreases as we go up.
	    // if we didn't do the inverse then all the y values would be negative.
	    sy = mapLatitudeStart-l.getStart().x();
	    ey=  mapLatitudeStart-l.getEnd().x();
	    //System.out.println(y);
	    // set x & y using conversion
	    int x1 = (int) (mapWidth*(sx/mapLongitude));
	    int y1 = (int) (mapHeight*(sy/mapLatitude));
	    int x2 = (int) (mapWidth*(ex/mapLongitude));
	    int y2 = (int) (mapHeight*(ey/mapLatitude));
	    myLine l1= new myLine(x1,y1,x2,y2);
        return l1;
	}

	
	public void setFrame(int mapWidth,int mapHeight) {
		this.mapHeight=mapHeight;
		this.mapWidth=mapWidth;
	}
	
	
	public Fruit FruPix2Gps(Fruit f) {
				double xPIX=f.Getpoint().x();
	double yPIX=f.Getpoint().y();
	   double x=xPIX*mapLongitude ;//;
	   //System.out.println(z);
	   x=x/(mapWidth);
	  // System.out.println(z);
	   x=x +mapLongitudeStart;
    //System.out.println(x);
    double y=yPIX*mapLatitude;
    y=y/mapHeight;
    y=y-mapLatitudeStart;
    y=y*(-1);
    //System.out.println(x+","+y);
    Fruit p1=new Fruit(y,x,f.Getpoint().z(),f.GetWeight(),f.GetId());
    return p1;
	}
	
	
	
	public Fruit FruGps2Pix(Fruit f) {
			    double x,y;
    x=f.Getpoint().y() - mapLongitudeStart;
   // System.out.println(x);
    // do inverse because the latitude increases as we go up but the y decreases as we go up.
    // if we didn't do the inverse then all the y values would be negative.
    y = mapLatitudeStart-f.Getpoint().x();
    //System.out.println(y);
    // set x & y using conversion
    int x1 = (int) (mapWidth*(x/mapLongitude));
    int y1 = (int) (mapHeight*(y/mapLatitude));
   // System.out.println((int)x1+","+ (int)y1);
    Fruit p1=new Fruit(x1,y1,f.Getpoint().z(),f.GetWeight(),f.GetId());
   // System.out.println(p1);
    return p1;
	}
	

}
