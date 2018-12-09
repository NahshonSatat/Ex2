package Geom;

import GIS.My_Meta_data;

public class Packman  {
	private double Radius,id,speed;
	private Point3D point; 
	public Packman(double lat,double lon,double alt,double speed,double id,double Radius) {
		this.point=new Point3D(lat,lon,alt);
		this.id=id;
		this.speed=speed;
		this.Radius=Radius;
	}
	public Packman(String line) {
		String[] arr=line.split(",");
		// getting the lat lont alt for the point
		double x= Double.parseDouble(arr[2]);
		double y= Double.parseDouble(arr[3]);
		double z= Double.parseDouble(arr[4]);
		double id=Double.parseDouble(arr[1]);
		double speed=Double.parseDouble(arr[5]);
		double radius=Double.parseDouble(arr[6]);
		this.point=new Point3D(x,y,z);
		this.id=id;
		this.speed=speed;
		this.Radius=Radius;
	}
}
