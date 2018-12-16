package Geom;

public class Line {
	private Point3D start,end;
	
	public Line(Point3D start,Point3D end) {
		this.start=new Point3D(start);
		this.end=new Point3D(end);
	}
	public Line(double x1,double y1,double x2,double y2) {
		this.start=new Point3D(x1,y1);
		this.end=new Point3D(x2,y2);
	}

	public Point3D getStart() {
		return start;
	}

	public Point3D getEnd() {
		return end;
	}
	
}
