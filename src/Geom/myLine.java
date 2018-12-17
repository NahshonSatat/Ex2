
package Geom;

public class myLine {
	private Point3D start,end;
	
	public myLine(Point3D start,Point3D end) {
		this.start=new Point3D(start);
		this.end=new Point3D(end);
	}
	public myLine(double x1,double y1,double x2,double y2) {
		this.start=new Point3D(x1,y1);
		this.end=new Point3D(x2,y2);
	}

	public Point3D getStart() {
		return start;
	}

	public Point3D getEnd() {
		return end;
	}
	public String toString() {
		String s="x1: "+start.x()+" y1: "+start.y()+" x2: "+end.x()+" y2: "+end.y();
		return s;
	}
	
}
