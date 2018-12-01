package GIS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import Geom.Point3D;

public class Meta_data_project implements Meta_data {
	/**
	 * This class represents ArrayList ArrayList of meta data
	 * (save the meta data of the all project)
	 * @author eliahu satat , nashon satat
	 */
	
	private ArrayList<Meta_data_layer> MTproject;
	
 	/**
 	 * empty contractor
 	 */
	public Meta_data_project() {
		MTproject=new ArrayList<Meta_data_layer>();
	}
	
 	/**
   	 * Gives the current UTC
   	 *  according to: "https://stackoverflow.com/questions/5175728/how-to-get-the-current-date-time-in-java"
   	 */
	@Override
	public long getUTC() throws ParseException {
		String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		return toUtc(timeStamp);
	}
	
  	/**
   	 * help to the "getUTC" function
   	 *  according to: "https://stackoverflow.com/questions/12081417/convert-utc-date-into-milliseconds"
   	 */    private long toUtc(String time) throws ParseException {
    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US);
    	format.setTimeZone(TimeZone.getTimeZone("UTC"));

    	Date date = format.parse(time);
    	long millis = date.getTime();
    	return millis;
    }
	@Override
	public Point3D get_Orientation() {
		return null;
	}
	
  	/**
  	 * add anther meta data list to the list
  	 */
	public void add(MY_GIS_layer m) {
		MTproject.add(m.getMD());
	}

}
