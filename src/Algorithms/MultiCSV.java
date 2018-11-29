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
	
	private static My_GIS_project project;
	public static File folder ;//= new File("C:\\Users\\נחשון סתת\\eclipse-workspace\\Java");
	static String temp = "";

    public MultiCSV(String path) {
    	project = new My_GIS_project();
    	folder = new File(path);
    }

	public static void listFilesForFolder1(final File folder) throws Exception
	{
		for (final File fileEntry : folder.listFiles()) {
			if (fileEntry.isDirectory()) {
				System.out.println("Reading files under the folder "+folder.getAbsolutePath());
				listFilesForFolder1(fileEntry);
			} else {

				System.out.println(fileEntry.getName());
				if(fileEntry.getName().contains(".csv")) {
					CSV2Object toObject=new CSV2Object();
					project.add(toObject.ReadFile(fileEntry),true);
				System.err.println("yes!!!!!!!!!");

					String line = "";
					String cvsSplitBy = ",";

					try (BufferedReader br = new BufferedReader(new FileReader(fileEntry))) 
					{
						while ((line = br.readLine()) != null) 
						{

							String[] userInfo = line.split(cvsSplitBy);
						}
					

					} catch (IOException e) 
					{
						e.printStackTrace();
					}
				}

			}
		}
	}
	public void toKml() {
		

		String kmlString=
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n" + 
				"<kml xmlns=\"http://www.opengis.net/kml/2.2\">"+"\n"
				+"<Document><Folder>\n";
		Iterator<GIS_layer> i = project.iterator();
		MY_GIS_layer temp_layer=new MY_GIS_layer();
		while (i.hasNext()) {
			temp_layer = (MY_GIS_layer) i.next();
			 Iterator<GIS_element> it = temp_layer.iterator();
			 My_GIS_element temp_element=new My_GIS_element();
			 while(it.hasNext()) {
				 temp_element=(My_GIS_element) it.next();
				 kmlString=kmlString+kmlConvert(temp_element)+"\n";
			 }
			
		}
		
		kmlString=kmlString+"</Folder></Document>\n</kml>";
     	System.out.println(kmlString);
     	
		try {
			File file=new File("kmlProject"+".kml");

			if(!file.exists())
				file.createNewFile();

			PrintWriter pw=new PrintWriter(file);
			pw.print(kmlString);
			pw.close();
			System.out.println("done");
		}catch(IOException e)
		{
			e.printStackTrace();
		}

	}
	public String kmlConvert(My_GIS_element m)
	{
		String str="<Placemark>\n"
				+ "<name>"+"<![CDATA[" + m.Data().getSSID()+ "]]>"+"</name>\n"
				+"<description>"+ m.Data().getType()+"</description>\n"
				+"<Point><coordinates>"+m.Geom().x()+","+m.Geom().y()+","+m.Geom().z()+"</coordinates></Point>\n"
				+"<time>"+m.Data().getUTC()+"</time></Placemark>\n";
		
		return str;
	}
		
		

		
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("Reading files under the folder "+ folder.getAbsolutePath());
		//  listFilesForFolder(folder);
		MultiCSV test =new MultiCSV("C:\\Users\\נחשון סתת\\eclipse-workspace\\Java");
		listFilesForFolder1(folder);
		System.err.println("1111");
		//System.out.println(MultiCSV.project.toString());
		
	}

}







