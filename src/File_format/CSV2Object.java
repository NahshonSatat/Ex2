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
	
	
	public MY_GIS_layer ReadFile(File e) throws Exception {
		MY_GIS_layer layer =new My_GIS_layer();
		
	BufferedReader brf =new BufferedReader(new FileReader(e)) ;
	
	String line=brf.readLine();
	line=brf.readLine();//maybe i lose an important(first) line
	line=brf.readLine();
	while (line != null) //maybe adding &&!line.isempty
	{
		My_GIS_element temp =new My_GIS_element(line);
		layer.add(temp);
		//			kmlString=kmlString+line.toString()+"\n";

		line = brf.readLine();
	}
	return layer;

	}

}
