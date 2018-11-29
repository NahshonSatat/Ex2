package Coords;

import Geom.Point3D;

public class MyCoords implements coords_converter{


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Point3D a=new Point3D(32.10332,35.20904,670);
		Point3D b=new Point3D(32.10635,35.20523,650);
		MyCoords md = new MyCoords();
		System.out.println(md.distance3d(a,b));
	}
	
	@Override
	public Point3D add(Point3D gps, Point3D local_vector_in_meter) {
		//to meters
		Point3D adding = new Point3D(gps.Gps2Meter());
		//adding the points
		adding.add(local_vector_in_meter);
		// converting back to degree
		Point3D gps2 = new Point3D(adding.meter2Gps());
		return gps2;
	}

	@Override
	public double distance3d(Point3D gps0, Point3D gps1) {
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
	

	@Override
	public Point3D vector3D(Point3D gps0, Point3D gps1) {
		// converting to meters
		Point3D meter0 = new Point3D(gps0.Gps2Meter());
		Point3D meter1 = new Point3D(gps1.Gps2Meter());
		// the difference in meters
		System.out.println(meter0);
		System.out.println(meter1);
		double x=meter1.x()-meter0.x();
		double y=meter1.y()-meter0.y();
		double z=meter1.z()-meter0.z();
		Point3D vector3d = new Point3D(x,y,z);
		System.out.println(vector3d);
		return vector3d;
	}

	@Override
	public double[] azimuth_elevation_dist(Point3D gps0, Point3D gps1) {
		double azimuth []= new double[3];
		azimuth[0]=gps0.north_angle(gps1);
		azimuth[1]=	gps0.up_angle(gps1);
		azimuth[2]=distance3d(gps0,gps1);
		return azimuth;
	}

	@Override
	public boolean isValid_GPS_Point(Point3D p) {
		boolean flag=true;
		if(p.x()>180||p.x()<-180)
		flag= false;
		if(p.y()>90||p.y()<-90)
		flag= false;
		// 8000= the high of the highest point on Earth( Mount Everest)
		if(p.x()>8000||p.x()<-450)
		flag= false;
		return flag;
	}
	
	


}
