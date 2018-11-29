package GIS;

import Geom.Geom_element;
import Geom.Point3D;

public class My_GIS_element implements  GIS_element {
    private Point3D Geom ;
    private My_Meta_data Data ;
    
    
    public My_GIS_element(String line) {
		String[] arr=line.split(",");
		// getting the lat lont alt for the point
		double Geomx= Double.parseDouble(arr[7]);
		double Geomy= Double.parseDouble(arr[6]);
		double Geomz= Double.parseDouble(arr[8]);
		Geom= new Point3D(Geomx,Geomy,Geomz);
		long l=Long.parseLong(arr[3]);
		// getting the UTC,MAC,SSID,AccuracyMeters,Type
		Data=new My_Meta_data(l,arr[0],arr[1],arr[9],arr[10]);	
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

}
