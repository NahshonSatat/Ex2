package Algorithms;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Iterator;
import javax.xml.parsers.*;
import File_format.CSV2Object;
import GIS.GIS_element;
import GIS.GIS_layer;
import GIS.MY_GIS_layer;
import GIS.My_GIS_element;
import GIS.My_GIS_project;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

public class MultiCSV {
	/**
	 * this class knows to run Recursively on folder and convert it to a project that contains 
	 * all the csv file in this folder has a layers in this project
	 */
	
	private static My_GIS_project project;
	public static File folder ;
	static String temp = "";

	/**
	 *  contractor that build a file with the path(has a string)
	 */
    public MultiCSV(String path) {
    	project = new My_GIS_project();
    	folder = new File(path);
    }

	/**
	 * this function run  over the folder Recursively and convert it to a project(list of layers)
	 */
	public static void Folder2project(final File folder) throws Exception
	{
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				//System.out.println("Reading files under the folder "+folder.getAbsolutePath());
				// the Recursive call
				Folder2project(fileEntry);
			} 
			else {

				//System.out.println(fileEntry.getName());
				// if this file is a csv file
				if(fileEntry.getName().contains(".csv")) {
					// use CSV2Object object
					CSV2Object toObject=new CSV2Object();
					// and add the it has a new layer to the project
					project.add(toObject.ReadFile(fileEntry),true);
				//System.err.println("yes!!!!!!!!!");

//					String line = "";
//					String cvsSplitBy = ",";
//
//					try (BufferedReader br = new BufferedReader(new FileReader(fileEntry))) 
//					{
//						while ((line = br.readLine()) != null) 
//						{
//
//							String[] userInfo = line.split(cvsSplitBy);
//						}
//					
//
//					} catch (IOException e) 
//					{
//						e.printStackTrace();
//					}
				}

			}
		}
	}
	
	
	
	/**
	 *  convert the project of this object to kml file 
	 *  according to : https://developers.google.com/kml/documentation/kml_tut
	 */
	public void toKml() {
		
       // the openig of kml file
		String kmlString=
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<kml xmlns=\"http://www.opengis.net/kml/2.2\">"+"\n"
				+"<Document><Folder >\n";
		Iterator<GIS_layer> i = project.iterator();
		MY_GIS_layer temp_layer=new MY_GIS_layer();
		// run over all the project
		while (i.hasNext()) {
			temp_layer = (MY_GIS_layer) i.next();
			 Iterator<GIS_element> it = temp_layer.iteretor();
			 My_GIS_element temp_element=new My_GIS_element();
			// run over all the layer
			 while(it.hasNext()) {
				 temp_element=(My_GIS_element) it.next();
				 // add every element to the file 
				 kmlString=kmlString+kmlConvert(temp_element)+"\n";
			 }
			
		}
		
		// the end of the kml format
		kmlString=kmlString+"</Folder></Document>\n</kml>";
     	
		
		// export it - to kml file by the name-"kmlProject" in the project folder
		try {
			File file=new File("kmlProject"+".kml");

			// if it is not  exists create the file
			if(!file.exists())
				file.createNewFile();

			PrintWriter pw=new PrintWriter(file);
			pw.print(kmlString);
			pw.close();
		}catch(IOException e)
		{
			e.printStackTrace();
		}

	}
	
	/**
	 * convert a single element(= gps point) to kml format
	 * @param m
	 * @return string = the kml of this point
	 */
	private String kmlConvert(My_GIS_element m)
	{
		String str="<Placemark>\n"
				+ "<name>"+"<![CDATA[" + m.Data().getSSID()+ "]]>"+"</name>\n"
				+"<description>"+ m.Data().getType()+"</description>\n"
				+"<Point><coordinates>"+m.Geom().x()+","+m.Geom().y()+","+m.Geom().z()+"</coordinates></Point>\n"
				+"<time>"+m.Data().getUTC()+"</time></Placemark>\n";
		
		return str;
	}
		
		

		// for testing the class
	public static void main(String[] args) throws Exception {
		
		// Build the object with the folder path
		MultiCSV test =new MultiCSV("C:\\Users\\אליהו סתת\\eclipse-workspace\\Java");
		// run over the folder and convert it to a project 
		Folder2project(folder);
		// build from this project kml file
		test.toKml();
		
	}

}







