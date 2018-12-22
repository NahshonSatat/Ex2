package Geom;

import java.util.ArrayList;

import GIS.My_Meta_data;
import javafx.scene.shape.Line;

/**
 * this class represent a packman that is a point 
 * with speed and the path that he go
 * he can build from csv line
 * and can change his position
 * with point and Weight
 * @author אליהו סתת
 *
 */
public class Packman  {
	private double Radius;
	private double id;
	private double speed;
	private Point3D point;
	private double time;
	private ArrayList<Line> path;
	private ArrayList<PathPoint> pathpoint;

	public Packman(double lat,double lon,double alt,double speed,double id,double Radius) {
		this.point=new Point3D(lat,lon,alt);
		this.id=id;
		this.speed=speed;
		this.Radius=Radius;
		this.time=0;
		path=new ArrayList<Line>();
		pathpoint=new ArrayList<PathPoint>();
		PathPoint pp=new PathPoint(this.point,0);
		pathpoint.add(pp);
	}
	public Packman(double lat,double lon,double id) {
		this.point=new Point3D(lat,lon,0);
		this.id=id;
		this.speed=1;
		this.Radius=1;
		this.time=0;
		path=new ArrayList<Line>();
		pathpoint=new ArrayList<PathPoint>();
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
		path=new ArrayList<Line>();
		pathpoint=new ArrayList<PathPoint>();
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
		path=new ArrayList<Line>();
		pathpoint=new ArrayList<PathPoint>();
	}
	
	public double GetId() {
		return this.id;
	}
	public ArrayList<Line> GetPath() {
		return this.path;
	}
	public ArrayList<PathPoint> GetPathpoint() {
		return this.pathpoint;
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
	public void setPosition(double x,double y,double z) {
		Point3D p=new Point3D(x,y,z);
		this.point.SetP(p);
	}
	public void add2Path(Line l) {
		 this.path.add(l);
	}
	public void add2Pathpoint(PathPoint pp) {
		 this.pathpoint.add(pp);
	}
	public ArrayList<Line> getPath() {
		return this.path;
	}
	public void setId(int size) {
		this.id=size;
		
	}
	
}
