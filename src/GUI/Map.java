package GUI;

import Geom.Point3D;

public class Map {
	
	String path;
	Point3D start;
	Point3D end;
	public Map(String path , Point3D start1, Point3D end1) {
		this.path=path;
		start=new Point3D (start1);
		end=new Point3D (end1);
	}
	public String getPath() {
		return path;
	}
	
	
}
