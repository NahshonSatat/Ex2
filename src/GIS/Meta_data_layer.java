package GIS;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

import Geom.Point3D;

public class Meta_data_layer implements Meta_data{
	private ArrayList<My_Meta_data> MTlayer;
	
     public Meta_data_layer() {
    	 MTlayer=new ArrayList<My_Meta_data>();
     }
     
     public void add(My_GIS_element m) throws ParseException {
 		My_Meta_data data = new My_Meta_data(m);
 		MTlayer.add(data);
     }
	// according to: "https://stackoverflow.com/questions/5175728/how-to-get-the-current-date-time-in-java"
	@Override
	public long getUTC() throws ParseException {
		String timeStamp = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
		return toUtc(timeStamp);
	}
    // according to -"https://stackoverflow.com/questions/12081417/convert-utc-date-into-milliseconds"
    private long toUtc(String time) throws ParseException {
    	SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss", Locale.US);
    	format.setTimeZone(TimeZone.getTimeZone("UTC"));

    	Date date = format.parse(time);
    	long millis = date.getTime();
    	return millis;
    }

	@Override
	public Point3D get_Orientation() {
		// TODO Auto-generated method stub
		return null;
	}

}
