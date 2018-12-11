package File_format;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

import GIS.GIS_element;
import GIS.My_GIS_element;
import Geom.Fruit;
import Geom.Game;
import Geom.Packman;

public class trying {

	public static void main(String[] args) throws Exception {
//		BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\אליהו סתת\\Desktop\\game_1543684662657.csv"));
//		System.out.println(br.readLine());
//		System.out.println(br.readLine());
//		System.out.println(br.readLine());
//		System.out.println(br.readLine());
//		System.out.println(br.readLine());
//		String[] s = br.readLine().split(",");
//		for (int i = 0; i < s.length; i++) {
//			System.out.println(s[i]);
//		}
//		br.close();
		Game g=new Game("C:\\Users\\נחשון סתת\\Desktop\\game_1543684662657.csv");
	    Game g1=new Game("C:\\Users\\נחשון סתת\\Desktop\\game_1543684662657.csv");
	    Game g2=new Game("C:\\Users\\נחשון סתת\\Desktop\\game_1543684662657.csv");
//		Iterator<Packman> it =g.getPackmans().iterator();
//		Packman temp_Packman ;
//			// run over all the layer
//			 while(it.hasNext()) {
//				 temp_Packman=(Packman)it.next();
//               System.out.println("p "+temp_Packman.toString());
//			 }
//		
//	
//	 Iterator<Fruit> it1 =g.getFruits().iterator();
//	  Fruit temp_Fruit ;
//		// run over all the layer
//		 while(it1.hasNext()) {
//			 temp_Fruit=(Fruit)it1.next();
//           System.out.println("f "+temp_Fruit.toString());
//			 //System.out.println(temp_Fruit.id);
//		 }
		System.out.println(g.gametocsv());
	
}
}


