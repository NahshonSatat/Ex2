package Geom;

public class Fruit {
	
	private double Weight;
	private double id;
	private Point3D point; 
	
	public Fruit(double lat,double lon,double alt,double Weight,double id) {
		this.point=new Point3D(lat,lon,alt);
		this.id=id;
		this.Weight=Weight;
	}
	public Fruit(String line) {
		String[] arr=line.split(",");
		// getting the lat lont alt for the point
		double x= Double.parseDouble(arr[2]);
		double y= Double.parseDouble(arr[3]);
		double z= Double.parseDouble(arr[4]);
		double id=Double.parseDouble(arr[1]);
		double Weight=Double.parseDouble(arr[5]);
		this.point=new Point3D(x,y,z);
		this.id=id;
		this.Weight=Weight;
	}
	
	public String toString() {
		return id+","+point.x()+","+point.y()+","+point.z()+","+Weight;
	}
	
	

}
