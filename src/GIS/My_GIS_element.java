package GIS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import Geom.Geom_element;
import Geom.Point3D;

public class My_GIS_element implements  GIS_element {
    private Point3D Geom ;
    private My_Meta_data Data ;
    
    My_GIS_element(){
    	
    }
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
    
    
    // according to -"https://stackoverflow.com/questions/12081417/convert-utc-date-into-milliseconds"
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
	

	@Override
	public void translate(Point3D vec) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) throws ParseException {
		My_GIS_element m= new My_GIS_element();
		long l =m.toUtc("03-12-2017 08:53:08");
		System.out.println(l);
	}

}
