package File_format;

/*
import java.io.File;
import java.io.FileNotFoundException;

import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Folder;
import de.micromata.opengis.kml.v_2_2_0.Icon;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Style;
public class Path2Kml {
	final Kml r = new Kml();
	final Kml kml = new Kml();
	Document doc = kml.createAndSetDocument().withName("JAK Example1").withOpen(true);

//	// create a Folder
//	Folder folder = doc.createAndAddFolder();
//	folder.withName("Continents with Earth's surface").withOpen(true);
//
//	// create Placemark elements
//	createPlacemarkWithChart(doc, folder, 93.24607775062842, 47.49808862281773, "Asia", 30);
//	createPlacemarkWithChart(doc, folder, 19.44601806124206, 10.13133611111111, "Africa", 20);
//	createPlacemarkWithChart(doc, folder, -103.5286299241638, 41.26035225962401, "North America", 17);
//	createPlacemarkWithChart(doc, folder, -59.96161780270248, -13.27347674076888, "South America", 12);
//	createPlacemarkWithChart(doc, folder, 14.45531426360271, 47.26208181151567, "Europe", 7);
//	createPlacemarkWithChart(doc, folder, 135.0555272486322, -26.23824399654937, "Australia", 6);

	// print and save
	kml.marshal(new File("advancedexample1.kml"));
}
*/

//////////////////////////////////////////////////////////


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Locale;

import javax.swing.JFrame;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import GUI.MainWindow;
import GUI.Map;
import Geom.Game;
import Geom.Packman;
import Geom.PathPoint;
import Geom.Point3D;
import de.micromata.opengis.kml.v_2_2_0.Document;
import de.micromata.opengis.kml.v_2_2_0.Folder;
import de.micromata.opengis.kml.v_2_2_0.Icon;
import de.micromata.opengis.kml.v_2_2_0.Kml;
import de.micromata.opengis.kml.v_2_2_0.Placemark;
import de.micromata.opengis.kml.v_2_2_0.Style;
import de.micromata.opengis.kml.v_2_2_0.TimeSpan;
/**
 * this class creat a kml file of the path of the packmans of the game
 * according to:
 * https://stackoverflow.com/questions/1459656/how-to-get-the-current-time-in-yyyy-mm-dd-hhmisec-millisecond-format-in-java
 * https://labs.micromata.de/projects/jak/quickstart.html
 * https://stackoverflow.com/questions/574881/how-can-i-string-format-a-timespan-object-with-a-custom-format-in-net
 * https://stackoverflow.com/questions/8477246/how-to-convert-date-represented-as-a-string-to-milliseconds
 *https://stackoverflow.com/questions/4142313/java-convert-milliseconds-to-time-format
 * @author אליהו סתת
 *
 */

public class Path2Kml {
	private Game g;

	public Path2Kml(Game g) {
		this.g=g;
	}
	
	public static void main(String[] args) throws FileNotFoundException {

	}
	
	public  void tokml() throws FileNotFoundException {
		final Kml kml = new Kml();
		Document doc = kml.createAndSetDocument().withName("JAK Example1").withOpen(true);
		// create a Folder
		Folder folder = doc.createAndAddFolder();
		folder.withName("Continents with Earth's surface").withOpen(true);
		
		// create Placemark elements
		Iterator<Packman> it1 =g.getPackmans().iterator();
		Packman temp_Packman ;
		
		
		while(it1.hasNext()) {
			temp_Packman=(Packman)it1.next();
				Iterator<PathPoint> it10 =temp_Packman.GetPathpoint().iterator();
				PathPoint temp_Pathpoint;
				
				
				while(it10.hasNext()) {
					temp_Pathpoint=(PathPoint)it10.next();
					Placemark p = doc.createAndAddPlacemark();
					p.withOpen(Boolean.TRUE).createAndSetPoint()
					.addToCoordinates(temp_Pathpoint.y(),temp_Pathpoint.x());
					String start="";
					try {
						start = MillisToString(StringToMillis(TimeNow())+(int)temp_Pathpoint.getTime()*1000);
					} catch (ParseException | java.text.ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					String end="";
					try {
						end = MillisToString(StringToMillis(TimeNow())+((int)temp_Pathpoint.getTime()+1)*1000);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (java.text.ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					// make the time span format
					String[] spl1=start.split(" ");
					start=spl1[0]+"T"+spl1[1]+"Z";
					
					String[] spl2=end.split(" ");
					end=spl2[0]+"T"+spl2[1]+"Z";
			
					//System.out.println("time1: "+start);
					//System.out.println("time2: "+end);
					// add the time span (life of this point) start and end
					TimeSpan a=p.createAndSetTimeSpan();
					a.setBegin(start);
					a.setEnd(end);

					//System.out.println(temp_Pathpoint.getTime());
					//createPlacemarkWithChart( folder, temp_Pathpoint.y(), temp_Pathpoint.x(), temp_Pathpoint.z());
				}


			}
		// save the kml
		kml.marshal(new File("path.kml"));
	}

	
/**
 * The createPlacemarkWithChart ()-method generates and set a placemark object, with the given statistical data . The Icon and Style
 * objects (color and size of the text and icon) are saved to the root element. The placemark is created and set to the given folder.
 * 
 * @param document structure of the KML file
 * @param folder to add continent
 * @param longitude of the continent
 * @param latitude of the continent
 * @param continentName or name of the placemark
 * @param coveredLandmass in percent
 */
private static void createPlacemarkWithChart( Folder folder, double longitude, double latitude,double z ) {
	
	Placemark placemark = folder.createAndAddPlacemark();
	placemark.createAndSetPoint().addToCoordinates(longitude, latitude); // set coordinates

}

public  String TimeNow()
{
	return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); 
}

public String pointTime(double time) throws ParseException, java.text.ParseException {
	int x=(int)time;
	String s=TimeNow();
	//System.out.println(s);
	long l=1000*x;
	l=l+StringToMillis(s);
	s=MillisToString(l);
	//System.out.println(s);
	return s;
	
}

public String MillisToString(Long millis) 
{
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	return sdf.format(new Date(millis));
}



public  long StringToMillis(String TimeAsString) throws ParseException, java.text.ParseException
{
	SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
	Date date =   format.parse(TimeAsString.toString());
	long millis = date.getTime();
	return millis;
}




}
