package GIS;

import Geom.Point3D;

public class My_Meta_data implements Meta_data {
    private long UTC;
    private String SSID;
    private String MAC;
    private String Type;
    private String AccuracyMeters;   
	
	//
	@Override
	public long getUTC() { 	
		return this.UTC;
	}
	@Override
	public String toString() {
		String s="UTC :"+this.UTC+"SSID :"+this.SSID+"MAC :"+this.MAC+"Type :"+this.Type+"AccuracyMeters :"+this.AccuracyMeters;
		return s;
	}

	@Override
	public Point3D get_Orientation() {
		return null;
	}

}
