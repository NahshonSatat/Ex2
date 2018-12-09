package File_format;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import GIS.MY_GIS_layer;
import GIS.My_GIS_element;
import Geom.Fruit;
import Geom.Game;
import Geom.Packman;

public class Csv2Game {

	  public Game ReadFile(File e) throws Exception {
		  Game layer =new Game();
			
		BufferedReader brf =new BufferedReader(new FileReader(e)) ;
		
		String line=brf.readLine();
		// the first two lines are headlines
		//line=brf.readLine();
		line=brf.readLine();
		// open every line
		while (line != null) 
		{
			//System.out.println(line);
			
			if(line.charAt(0)=='P') {
				Packman p=new Packman(line);
				layer.addPac(p);
			}
			//if(line.charAt(0)=='F') {
			else {
				Fruit f=new Fruit(line);
				layer.addFru(f);	
			}

		line = brf.readLine();
		}
	  // 	return the all csv file as a layer 
		return layer;

		}
	
}
