package GIS;

import Geom.Geom_element;
import Geom.Point3D;

public class My_GIS_element implements  GIS_element {
    private Point3D Geom ;
    private My_Meta_data Data ;
    
    
    public My_GIS_element(String line) {
    	
    	
    	
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
