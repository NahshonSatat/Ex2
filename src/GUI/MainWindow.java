package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import Geom.Fruit;
import Geom.Game;

import Geom.Packman;
import Geom.Point3D;




public class MainWindow extends JFrame implements MouseListener
{
	public Game gameP;
    public Map map;
	public BufferedImage myImage;
	
	// the constructor 
	public MainWindow(Map map) 
	{
		this.map=map;
		gameP=new Game();
		initGUI();		
		this.addMouseListener(this); 
	}
	
	private void initGUI() 
	{
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("file"); 
		MenuItem item1 = new MenuItem("save");
		MenuItem item2 = new MenuItem("load");
		Menu menu1 = new Menu("game"); 
		MenuItem item3 = new MenuItem("run");
		MenuItem item4 = new MenuItem("new game");
		
		// the "save" action
		item1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			System.out.println("game loaded");
			System.out.println(gameP.gametocsv());
			gameP.clear();
			repaint();
			}
			
		});
		// the "new gameP" action
		item4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			System.out.println("start new gameP");
			gameP.clear();
			repaint();
			}
			
		});
		menu.add(item1);
		menu.add(item2);
		menu1.add(item3);
		menu1.add(item4);
		menuBar.add(menu);
		menuBar.add(menu1);

		this.setMenuBar(menuBar);
		
		try {
			myImage = ImageIO.read(new File(map.getPath()));
			// myImage = ImageIO.read(new File("C:\\Users\\אליהו סתת\\Desktop\\Ariel1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	
	
	
	int x = -1;
	int y = -1;
	
	public void paint(Graphics g)
	{
		ArrayList<Packman>p=gameP.getPackmans();
		ArrayList<Fruit>f=gameP.getFruits();
		g.drawImage(myImage, 0, 0,this.getWidth(),this.getHeight(), this);
		
		 // print the Packmans
		 Iterator<Packman> it1 =p.iterator();
		 Packman temp_Packman ;
			 while(it1.hasNext()) {
				 temp_Packman=(Packman)it1.next();
				 g.setColor(Color.yellow);
				 g.fillOval((int)temp_Packman.Getpoint().x(), (int)temp_Packman.Getpoint().y(), 20, 20);
			 }
			 
			 // print the fruits
			 Iterator<Fruit> it2 =f.iterator();
			 Fruit temp_Fruit ;
				// run over all the layer
				 while(it2.hasNext()) {
					 temp_Fruit=(Fruit)it2.next();
					 g.setColor(Color.GREEN);
					 //g.setColor(randomColor());
					 g.fillOval((int)temp_Fruit.Getpoint().x(),(int) temp_Fruit.Getpoint().y(), 10, 10);
					
				 }
	
	}
	
	//pixel->lat/lng:
	public void Convert(Point3D f){
		double x=f.x();
		double y=f.y();
		double lat=(y/(this.getHeight()/180)-90)/-1;
		double lng = x/(this.getWidth()/360)-180;
		System.out.println(x+","+y);
		//Fruit newFruit=new Fruit()
		
		
	}
	
	public void Convert2(Point3D f){
		double lat=f.x();
		double lng=f.y();
		double y = Math.round(((-1 * lat) + 90) * (this.getHeight() / 180));
		double x = Math.round((lng + 180) * (this.getWidth() / 360));
		System.out.println(x+","+y);
		//Fruit newFruit=new Fruit()
	}
	public void Convert3(Point3D f){
	double minLat = 32.101896;
	double minLong = 35.202205;
	double maxLat = 32.105381;
	double maxLong = 35.212388;

	// Map image size (in points)
	double mapHeight = this.getHeight();
	double mapWidth = this.getWidth();

	// Determine the map scale (points per degree)
	double xScale = mapWidth/ (maxLong - minLong);
	double yScale = mapHeight / (maxLat - minLat);

	// position of map image for point
	double x = (f.x() - minLong) * xScale;
	double y = - (f.y() + minLat) * yScale;

	System.out.println("final coords: " + x + " " + y);
	}

	private Color randomColor() {
		int r=(int)(Math.random()*50);
		Color c=Color.white;
		if(r>0 && r<=10) {
		c=Color.BLACK ;
		}
		if(r>10 && r<=20) {
			 c=Color.white ;
		}
		if(r>20&&r<=30) {
			 c=Color.BLUE ;
		}
		if(r>30&&r<=40) {
			 c=Color.CYAN ;
		}
		if(r>40&&r<=50) {
			 c=Color.GREEN ;
		}
	   return c;
	}

	@Override
	public void mouseClicked(MouseEvent arg) {
		//if right click add Packman
		if(arg.getButton()==1) {
		System.out.println("mouse Clicked");
		System.out.println("("+ arg.getX() + "," + arg.getY() +")");
		x = arg.getX();
		y = arg.getY();
		Packman p1=new Packman(x,y,gameP.getPackmans().size());
		gameP.addPac(p1);
		repaint();
		}
		//if left click add Fruit
		if(arg.getButton()==3) {
			System.out.println("("+ arg.getX() + "," + arg.getY() +")");
			x = arg.getX();
			y = arg.getY();
			Fruit p2=new Fruit(x,y,gameP.getFruits().size());
			gameP.addFru(p2);
			repaint();
			}
	}
			
		


	@Override
	public void mouseEntered(MouseEvent arg0) {
		//System.out.println("mouse entered");
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
