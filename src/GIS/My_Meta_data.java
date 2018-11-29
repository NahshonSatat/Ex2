package GIS;

import java.text.ParseException;

import Geom.Point3D;

public class My_Meta_data implements Meta_data {
    private long UTC;
    private String SSID;
    private String MAC;
    private String Type;
    private String AccuracyMeters;   
	
    
    //
    public My_Meta_data (long UTC,String MAC,String SSID,String AccuracyMeters,String Type) {
    	this.UTC=UTC;
    	this.SSID=SSID;
    	this.MAC=MAC;
    	this.Type=Type;
    	this.AccuracyMeters=AccuracyMeters;
    }
    
    public My_Meta_data(My_GIS_element mmd) throws ParseException {
    	this.UTC=mmd.getData().getUTC();
    	this.SSID=((My_Meta_data) mmd.getData()).getSSID();
    	this.MAC=((My_Meta_data) mmd.getData()).getMAC();
    	this.Type=((My_Meta_data) mmd.getData()).getType();
    	this.AccuracyMeters=((My_Meta_data) mmd.getData()).getAccuracyMeters();
    }
	public String getSSID() {
		return SSID;
	}

	public String getMAC() {
		return MAC;
	}

	public String getType() {
		return Type;
	}

	public String getAccuracyMeters() {
		return AccuracyMeters;
	}

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
