package File_format;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import GIS.MY_GIS_layer;
import GIS.My_GIS_element;


public class CSV2Object {
	
  	/**
  	 * this class nows to convert a csv file to a layer
  	 */
	
	
	
	/**
  	 * its had only one function that get file read from his line by line and convert them to elements
  	 * and build MY_GIS_layer with all the points and return it
  	 */
  public MY_GIS_layer ReadFile(File e) throws Exception {
		MY_GIS_layer layer =new MY_GIS_layer();
		
	BufferedReader brf =new BufferedReader(new FileReader(e)) ;
	
	String line=brf.readLine();
	// the first two lines are headlines
	line=brf.readLine();
	line=brf.readLine();
	// open every line
	while (line != null) 
	{
		// builds anther gps point from the line(the line is now string with ',')
		My_GIS_element temp =new My_GIS_element(line);
		layer.add(temp,temp);
    // getting the next line 
		line = brf.readLine();
	}
  // 	return the all csv file as a layer 
	return layer;

	}

}
