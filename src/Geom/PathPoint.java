package Geom;

public class PathPoint extends Point3D{
	
	/**
	 * this class represent the one point on the path that the packman went
	 * and she had the time he was in it
	 * @author אליהו סתת
	 *
	 */
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
