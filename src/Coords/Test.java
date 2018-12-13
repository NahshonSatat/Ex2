package Coords;

import Geom.Point3D;

public class Test {
	static final int mapWidth = 1433, mapHeight = 642;
	// offsets
	static final double mapLongitudeStart =35.202306  , mapLatitudeStart = 32.105730;
	// length of map in long/lat
	static final double mapLongitude = 35.212407-mapLongitudeStart, 
	        // invert because it decreases as you go down
	        mapLatitude = mapLatitudeStart-32.101867;

	private static Point3D getPositionOnScreen(double longitude, double latitude){
	    double x,y;
	    x=longitude - mapLongitudeStart;
	   // System.out.println(x);
	    // do inverse because the latitude increases as we go up but the y decreases as we go up.
	    // if we didn't do the inverse then all the y values would be negative.
	    y = mapLatitudeStart-latitude;
	    //System.out.println(y);
	    // set x & y using conversion
	    int x1 = (int) (mapWidth*(x/mapLongitude));
	    int y1 = (int) (mapHeight*(y/mapLatitude));
        System.out.println((int)x1+","+ (int)y1);
	    return new Point3D((int)x1, (int)y1);
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point3D t2=new Point3D(35.207475,32.102494);
		Point3D gstart=new Point3D(32.105730,35.202306,0);
		Point3D gend=new Point3D(32.101867,35.212407,0);
		getPositionOnScreen(35.207475,32.102494);
		getPositionOnScreen(35.202306,32.105730);
		getPositionOnScreen(35.212407,32.101867);
		getPoositionOnScreen(35.207475,32.102494);
		//getPoositionOnScreen(35.202306,32.105730);
		
	}
	

	private static Point3D getPoositionOnScreen(double longitude, double latitude){
	    double x,y;
	   // double x1 =  (mapWidth*(x/mapLongitude));
	   // double y1 =  (mapHeight*(y/mapLatitude));
	    x=longitude - mapLongitudeStart;
	   // System.out.println(x);
	    // do inverse because the latitude increases as we go up but the y decreases as we go up.
	    // if we didn't do the inverse then all the y values would be negative.
	    y = mapLatitudeStart-latitude;
	    //System.out.println(y);
	    // set x & y using conversion
	    double x1 = (int ) (mapWidth*(x/mapLongitude));
	    double y1 = (int)  (mapHeight*(y/mapLatitude));
	  //  x1=x1*mapWidth;
	  //  y1=y1*mapHeight;
        System.out.println(x1+","+ y1);
        double  x2=x1/mapWidth;
        double  y2=x1/mapHeight;
        System.out.println(x2+","+ y2);

	    
	    
	    
	    
	    return null;
	}

}
