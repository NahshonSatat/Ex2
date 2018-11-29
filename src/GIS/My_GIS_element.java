package GIS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import Geom.Geom_element;
import Geom.Point3D;

public class My_GIS_element implements  GIS_element {
	/**
	 * This class represents a gps point that has lat lon alt + meta data 
	 */
    private Point3D Geom ;
    private My_Meta_data Data ;
    
	/**
	 * empty  constructor 
	 */
    public My_GIS_element(){
    	Geom=new Point3D(0,0,0);
    	Data=new My_Meta_data();
    }
    
	/**
	 * constructor that get a line from the csv as a string 
	 */
    public My_GIS_element(String line) throws ParseException {
		String[] arr=line.split(",");
		// getting the lat lont alt for the point
		double Geomx= Double.parseDouble(arr[7]);
		double Geomy= Double.parseDouble(arr[6]);
		double Geomz= Double.parseDouble(arr[8]);
		Geom= new Point3D(Geomx,Geomy,Geomz);
		long l=toUtc(arr[3]);
		// getting the UTC,MAC,SSID,AccuracyMeters,Type
		Data=new My_Meta_data(l,arr[0],arr[1],arr[9],arr[10]);	
    }
    
	/**
	 * return the utc in mili second
	 * according to:
	 * @see https://stackoverflow.com/questions/12081417/convert-utc-date-into-milliseconds
	 */
    private long toUtc(String time) throws ParseException {
    	SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.US);
    	format.setTimeZone(TimeZone.getTimeZone("UTC"));
    	Date date = format.parse(time);
    	long millis = date.getTime();
    	return millis;
    }
    
	@Override
	public Geom_element getGeom() {
		return this.Geom;
	}

	@Override
	public Meta_data getData() {
		
		return this.Data;
	}
	
	// for use the function of My_Meta_data
	public My_Meta_data Data() {
		return this.Data;
	}
	// for use the function of point3d
	public Point3D Geom() {
		return this.Geom;
	}
	

	@Override
	public void translate(Point3D vec) {
		// TODO Auto-generated method stub
	}
	
	// only for chack the function
//	public static void main(String[] args) throws ParseException {
//		My_GIS_element m= new My_GIS_element();
//		long l =m.toUtc("03-12-2017 08:53:08");
//		System.out.println(l);
//	}

}
