package Geom;

import java.io.File;
import java.util.ArrayList;

import File_format.Csv2Game;


public class Game {
	private ArrayList<Packman> Packmans;
	private ArrayList<Fruit> Fruits;
	
	public Game() {
		Packmans=new ArrayList<Packman>();
		Fruits=new ArrayList<Fruit>();
	}
	
	// csv constructor
	public Game(String path) throws Exception {
		Csv2Game c2g=new Csv2Game();
		Game g=c2g.ReadFile(new File(path));
		this.Packmans=g.getPackmans();
		this.Fruits=g.getFruits();
	}
	
	public void addPac(Packman p) {
		Packmans.add(p);
	}
	public void addFru(Fruit f) {
		Fruits.add(f);
	}
	public ArrayList<Packman> getPackmans(){
		return this.Packmans;
	}
	public ArrayList<Fruit> getFruits(){
		return this.Fruits;
	}
	
	

}
