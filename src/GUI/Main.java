package GUI;

import java.io.IOException;
//import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JFrame;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import Algorithms.GameAlgorithem;
import Coords.MyCoords;
import Coords.convert;
import Geom.Packman;
import Geom.Point3D;
import javafx.scene.shape.Line;
//import sun.util.calendar.LocalGregorianCalendar.Date;
//import sun.util.calendar.BaseCalendar.Date;
/**
 * this is a test class
 * @author אליהו סתת
 *
 */

public class Main 
{
	public static void main(String[] args) throws IOException, ParseException, java.text.ParseException
	{
		Point3D g1=new Point3D(32.103506,35.207834);
		Point3D p2=new Point3D(912,388,0);
		Point3D g2=new Point3D(32.103418,35.208723);
		Map m=new Map("C:\\\\Users\\\\אליהו סתת\\\\Desktop\\\\Ariel1.png",g1,g2);
		MainWindow window = new MainWindow(m);
		window.setVisible(true);
		window.setSize(window.myImage.getWidth(),window.myImage.getHeight());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	//System.out.println(TimeNow());
	//long l=1000;
	int x=1;
	System.out.println(TimeNow());
    System.out.println(pointTime(x));
	}

	public static String pointTime(double time) throws ParseException, java.text.ParseException {
		int x=(int)time;
		String s=TimeNow();
		//System.out.println(s);
		long l=1000*x;
		l=l+StringToMillis(s);
		s=MillisToString(l);
		//System.out.println(s);
		return s;
		
	}
	
	public static String TimeNow()
	{
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime()); 
	}
	
	
	
	public static String MillisToString(Long millis) 
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(new Date(millis));
	}
	
	
	
	public static long StringToMillis(String TimeAsString) throws ParseException, java.text.ParseException
	{
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);
		Date date =   format.parse(TimeAsString.toString());
		long millis = date.getTime();
		return millis;
	}
	
}
