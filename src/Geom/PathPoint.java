package Geom;

public class PathPoint extends Point3D{
	
    private double time;
	public PathPoint(Point3D p,double time) {
		super(p.x(), p.y());
		this.time=time;
		
	}
	public double getTime() {
		return time;
	}
	public void setTime(double time) {
		this.time = time;
	}

}
