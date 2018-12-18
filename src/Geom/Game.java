package Geom;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import File_format.Csv2Game;
import javafx.scene.shape.Line;
import solution.Solution;


public class Game {
	private ArrayList<Packman> Packmans;
	private ArrayList<Fruit> Fruits;
	private Solution solu;
	
	public Game() {
		Packmans=new ArrayList<Packman>();
		Fruits=new ArrayList<Fruit>();
		solu=new Solution();
	
	}
	
	// csv constructor
	public Game(String path) throws Exception {
		Csv2Game c2g=new Csv2Game();
		Game g=c2g.ReadFile(new File(path));
		this.Packmans=g.getPackmans();
		this.Fruits=g.getFruits();
		solu=new Solution();
	}
	public void csvtogame(String path) throws Exception {
		Csv2Game c2g=new Csv2Game();
		Game g=c2g.ReadFile(new File(path));
		this.Packmans=g.getPackmans();
		this.Fruits=g.getFruits();
	}
	
	public void addPac(Packman p) {
		p.setId(this.Packmans.size());
		Packmans.add(p);
	}
	public void removeFbyId(int id) {
		 Iterator<Fruit> it2 =Fruits.iterator();
		 Fruit temp_Fruit ;
			
			 while(it2.hasNext()) {
				 temp_Fruit=(Fruit)it2.next();
				 if(temp_Fruit.GetId()==id) {
					 it2.remove();
				 }
			 }
	}
	public void addFru(Fruit f) {
		f.setId(this.Fruits.size());
		Fruits.add(f);
	}
	public ArrayList<Packman> getPackmans(){
		return this.Packmans;
	}
	public ArrayList<Fruit> getFruits(){
		return this.Fruits;
	}
	public Solution getSolution(){
		return this.solu;
	}
	public void clear() {
		Packmans.clear();
		Fruits.clear();
		solu.clear();
	}
	
	//gametocsv
	public String gametocsv (String name) {
		//int r=(int)(Math.random()*10000);
	StringBuilder sb = new StringBuilder();
	String fileName = name+".csv";
	PrintWriter pw = null;

	try 
	{
		pw = new PrintWriter(new File(fileName));
	} 
	catch (FileNotFoundException e) 
	{
		e.printStackTrace();
	
	}
	//the first line
	sb.append("Type");
	sb.append(',');
	sb.append("id");
	sb.append(',');
	sb.append("Lat");
	sb.append(',');
	sb.append("Lon");
	sb.append(',');
	sb.append("Alt");
	sb.append(',');
	sb.append("Speed/Weight");
	sb.append(',');
	sb.append("Radius");
	sb.append('\n');
	Iterator<Packman> it =Packmans.iterator();
	Packman temp_Packman ;
		// run over all the layer
		 while(it.hasNext()) {
			 temp_Packman=(Packman)it.next();
				sb.append("P");	
				sb.append(',');
				sb.append(temp_Packman.GetId());
				sb.append(',');
				sb.append(temp_Packman.Getpoint().x());
				sb.append(',');
				sb.append(temp_Packman.Getpoint().y());
				sb.append(',');
				sb.append(temp_Packman.Getpoint().z());
				sb.append(',');
				sb.append(temp_Packman.Getspeed());
				sb.append(',');
				sb.append(temp_Packman.GetRadius());
				sb.append('\n');
				
		 }
	

 Iterator<Fruit> it1 =Fruits.iterator();
  Fruit temp_Fruit ;
	// run over all the layer
	 while(it1.hasNext()) {
		 temp_Fruit=(Fruit)it1.next();
			sb.append("F");	
			sb.append(',');
			sb.append(temp_Fruit.GetId());
			sb.append(',');
			sb.append(temp_Fruit.Getpoint().x());
			sb.append(',');
			sb.append(temp_Fruit.Getpoint().y());
			sb.append(',');
			sb.append(temp_Fruit.Getpoint().z());
			sb.append(',');
			sb.append(temp_Fruit.GetWeight());
			sb.append('\n');
	 }

	pw.write(sb.toString());
	pw.close();
	System.out.println("done!");
	return fileName;
}

	public void addPath2Solution(ArrayList<Line> getPath) {
     this.solu.add(getPath);		
	}
	
	

}
