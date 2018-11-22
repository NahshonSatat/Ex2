package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point3D a=new Point3D(32.10332,35.20904,670);
		Point3D b=new Point3D(32.10635,35.20523,650);
		System.out.println(distance3d1(a,b));
		
	}
	
	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
	    double RADIUS = 6371000;
	    double LON_NORM = 0.847091174;
		double diffx=gps1.x()-gps0.x();
		double diffy=gps1.y()-gps0.y();
		// to radian 
		double diffxR=diffx*(Math.PI/180);
	    double diffyR=diffy*(Math.PI/180);
	    // to meter 
	    double diffxM=Math.sin(diffxR)*RADIUS;
	    double diffyM=Math.sin(diffyR)*RADIUS*LON_NORM;
	    // Pitagoras 
		return Math.sqrt(diffxM*diffxM+diffyM*diffyM);
	}
	
	// just for testing
	//493.0523
	public static double distance3d1(Point3D gps0, Point3D gps1) {
	    double RADIUS = 6371000;
	    double LON_NORM = 0.847091174;
		double diffx=gps1.x()-gps0.x();
		double diffy=gps1.y()-gps0.y();
		double diffxR=diffx*(Math.PI/180);
	    double diffyR=diffy*(Math.PI/180);
	    double diffxM=Math.sin(diffxR)*RADIUS;
	    double diffyM=Math.sin(diffyR)*RADIUS*LON_NORM;
		return Math.sqrt(diffxM*diffxM+diffyM*diffyM);
	}

	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		// TODO Auto-generated method stub
		return false;
	}

}
