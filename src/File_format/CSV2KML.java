package File_format;

import java.io.File;

import Algorithms.MultiCSV;

public class CSV2KML {
	public static File folder ;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String path="C:\\Users\\נחשון סתת\\eclipse-workspace\\java";
		folder = new File(path);
		// Build the object with the folder path
		MultiCSV test =new MultiCSV("C:\\Users\\נחשון סתת\\eclipse-workspace\\java");
		// run over the folder and convert it to a project 
		test.Folder2project(folder);
		// build from this project kml file
		test.toKml();
	}

}
