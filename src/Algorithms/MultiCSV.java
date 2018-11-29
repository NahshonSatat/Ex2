package Algorithms;


import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.Iterator;
import javax.xml.parsers.*;
import File_format.CSV2Object;
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
		
	}

		
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.out.println("Reading files under the folder "+ folder.getAbsolutePath());
		//  listFilesForFolder(folder);
		MultiCSV test =new MultiCSV("C:\\Users\\נחשון סתת\\eclipse-workspace\\Java");
		listFilesForFolder1(folder);
		System.err.println("1111");
		System.out.println(MultiCSV.project.toString());
		
	}

}







