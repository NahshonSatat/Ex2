package Geom;

import java.util.ArrayList;

import GIS.My_Meta_data;

public class Packman  {
	private double Radius;
	private double id;
	private double speed;
	private Point3D point;
	private double time;
	private ArrayList<myLine> path; 

	public Packman(double lat,double lon,double alt,double speed,double id,double Radius) {
		this.point=new Point3D(lat,lon,alt);
		this.id=id;
		this.speed=speed;
		this.Radius=Radius;
		this.time=0;
		path=new ArrayList<myLine>();
	}
	public Packman(double lat,double lon,double id) {
		this.point=new Point3D(lat,lon,0);
		this.id=id;
		this.speed=1;
		this.Radius=1;
		this.time=0;
		path=new ArrayList<myLine>();
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
		this.Radius=radius;
		this.time=0;
		path=new ArrayList<myLine>();
	}
	
	
	public Packman(Packman packman) {
		double x= packman.Getpoint().x();
		double y= packman.Getpoint().y();
		double z= packman.Getpoint().z();
		double id=packman.GetId();
		double speed=packman.Getspeed();
		double radius=packman.GetRadius();
		this.point=new Point3D(x,y,z);
		this.id=id;
		this.speed=speed;
		this.Radius=radius;
		this.time=packman.GetTime();
		path=new ArrayList<myLine>();
	}
	public double GetId() {
		return this.id;
	}
	public ArrayList<myLine> GetPath() {
		return this.path;
	}
	public double GetTime() {
		return this.time;
	}
	public double GetRadius() {
		return this.Radius;
	}
	public double Getspeed() {
		return this.speed;
	}
	public Point3D Getpoint() {
		return this.point;
	}
	public String toString() {
		return id+","+point.x()+","+point.y()+","+point.z()+","+speed+","+Radius;
	}
	public void setTime(double d) {
		 this.time=d;
	}
	public void setPosition(Point3D p) {
		this.point.SetP(p);
	}
	public void add2Path(myLine l) {
		 this.path.add(l);
	}
	public ArrayList<myLine> getPath() {
		return this.path;
	}
	
}
