package solution;

import java.util.ArrayList;

import Geom.Point3D;

public class Path {
	private ArrayList<Point3D> MyPath;
	
    public Path() {
    	MyPath=new ArrayList<Point3D>();
    }
    
    public void add(Point3D p) {
    	MyPath.add(p);
    }

}
