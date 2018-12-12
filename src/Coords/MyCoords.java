package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter{
	/**
	 * This class has function on coordinate
	 * @author eliahu satat , nashon satat
	 */
	private Point3D pixel1;
	private Point3D pixel2;
	private Point3D gps1;
	private Point3D gps2;
	private double p2g;
	private double g2p;
	
	
	public MyCoords(Point3D p1,Point3D p2,Point3D g1,Point3D g2) {
		pixel1=new Point3D(p1);
		pixel2=new Point3D(p2);
		gps1=new Point3D(g1);
		gps2=new Point3D(g2);
		//double disPixels=regulardis(p1,p2);
		//double disGps=distance2d(g1,g2);
		double xPixels=p2.x();
		Point3D a=new Point3D(g1.Gps2Meter1());
		Point3D b=new Point3D(g2.Gps2Meter1());
		double xmeters=b.x()-a.x();
		double xgps=g1.x()-g2.x();
		p2g=xPixels/xgps;
		g2p=xgps/xPixels;
	}
	public MyCoords() {
		pixel1=new Point3D(0,0,0);
		pixel2=new Point3D(0,0,0);
		gps1=new Point3D(0,0,0);
		gps2=new Point3D(0,0,0);
		p2g=0;
		g2p=0;
	}
	
	
//	public Point3D p2g(Point3D pixels) {
//		
//		
//	}
	public Point3D gps2pix(Point3D gps) {
		//Point3D a = new Point3D(gps1.Gps2Meter1());
		//Point3D b = new Point3D(gps.Gps2Meter1());
		//Point3D v=vector3D(gps1,gps);
		//double bx=v.x();
		//double by=-v.y();
		double bx=gps1.x()-gps.x();
		double by=gps.y()-gps1.y();
		System.out.println(bx);
		System.out.println(by);
		Point3D c = new Point3D(bx*p2g,by*p2g,0);
		return c;
		
		
	}
	/*
	 * only for test myself
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCoords md =new MyCoords();
		Point3D a=new Point3D(32.10332,35.20904,670);
		Point3D b=new Point3D(32.10635,35.20523,650);
		Point3D c=new Point3D(337.6989921,-359.2492069,-20);
		System.out.println(md.distance2d(a,b));
		
	}
	
	
	*/
	
	/** computes a new point which is the gps point transformed by a 3D vector (in meters)*/
	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		//to meters
		Point3D adding = new Point3D(gps.Gps2Meter1());
		//adding the points
		adding.add(local_vector_in_meter);
		// converting back to degree
		Point3D gps2 = new Point3D(adding.meter2Gps1());
		return gps2;
	}
	
	public double regulardis(Point3D p1,Point3D p2) {
		double dis=Math.sqrt(p1.x()*p2.x()+p1.y()+p2.y());
		return dis;
	}

	/** computes the distance between two points 2d (in meters)
	 * According to the according to the given excel
	 * */
	public double distance2d(Point3D gps0, Point3D gps1) {
	    double RADIUS = 6371000;
	    double LON_NORM = 0.847091174;
		double diffx=gps1.x()-gps0.x();
		double diffy=gps1.y()-gps0.y();
		// to radian 
		double diffxR=(Math.toRadians(diffx));
	    double diffyR=(Math.toRadians(diffy));
	    // to meter 
	    double diffxM=Math.sin(diffxR)*RADIUS;
	    double diffyM=Math.sin(diffyR)*RADIUS*LON_NORM;
	    // Pitagoras 
		return Math.sqrt(diffxM*diffxM+diffyM*diffyM);
	}
	/** computes the 3D distance (in meters) between the two gps like points */
	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
	MyCoords md = new MyCoords();	
    double dis =md.distance2d(gps0,gps1);
    double height=gps0.z()-gps1.z();
    double ans=Math.sqrt(dis*dis+height*height);
    return ans;
	}
	
	/** computes the 3D vector (in meters) between two gps like points */
	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		MyCoords md = new MyCoords();
		Point3D meter0 = new Point3D(gps0.Gps2Meter1());
		Point3D meter1 = new Point3D(gps1.Gps2Meter1());
		//System.out.println(meter0);
		//System.out.println(meter1);
		double x=meter1.x()-meter0.x();
		double y=meter1.y()-meter0.y();
		double z=meter1.z()-meter0.z();
		Point3D ans = new Point3D(x,y,z);
		return ans;
	}

	
	/** computes the polar representation of the 3D vector be gps0-->gps1 
	 * Note: this method should return an azimuth (aka yaw), elevation (pitch), and distance
	 * note its use the point 3d function that Buaz gave us  
	 * */
	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		double azimuth []= new double[3];
		azimuth[0]=gps0.north_angle(gps1);
		azimuth[1]=	gps0.up_angle(gps1);
		azimuth[2]=distance3d(gps0,gps1);
		return azimuth;
	}
	
	/**
	 * return true iff this point is a valid lat, lon , lat coordinate: [-180,+180],[-90,+90],[-450, 8000]
	 * @param p
	 * @return
	 */
	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		boolean flag=true;
		if(p.x()>180||p.x()<-180)
		flag= false;
		if(p.y()>90||p.y()<-90)
		flag= false;
		// 8000= the high of the highest point on Earth( Mount Everest)
		if(p.z()>8000||p.z()<-450)
		flag= false;
		return flag;
	}


	
	


}
