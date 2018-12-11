package GUI;

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




public class MainWindow extends JFrame implements MouseListener


{
	public Game game;

	public BufferedImage myImage;
	
	public MainWindow() 
	{
		game=new Game();
		initGUI();		
		this.addMouseListener(this); 
	}
	
	private void initGUI() 
	{
		MenuBar menuBar = new MenuBar();
		Menu menu = new Menu("Menu"); 
		MenuItem item1 = new MenuItem("menu item 1");
		MenuItem item2 = new MenuItem("menu item 2");
		Menu menu1 = new Menu("Menu1"); 
		MenuItem item3 = new MenuItem("menu item 3");
		MenuItem item4 = new MenuItem("menu item 4");
		menuBar.add(menu);
		menu.add(item1);
		item1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
			System.out.println("game loaded");
			System.out.println(game.gametocsv());
			game.clear();
			repaint();
			}
			
		});
		menu.add(item2);
		menuBar.add(menu1);
		menu1.add(item3);
		menu1.add(item4);
		this.setMenuBar(menuBar);
		
		try {
			 myImage = ImageIO.read(new File("C:\\Users\\אליהו סתת\\Desktop\\Ariel1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	int x = -1;
	int y = -1;
    int z=-1;
    int q=-1;
	public void paint(Graphics g)
	{
		ArrayList<Packman>p=game.getPackmans();
		ArrayList<Fruit>f=game.getFruits();
		g.drawImage(myImage, 0, 0, this);
		 Iterator<Packman> it1 =p.iterator();
		 Packman temp_Packman ;
			// run over all the layer
			 while(it1.hasNext()) {
				 temp_Packman=(Packman)it1.next();
				 g.fillOval((int)temp_Packman.Getpoint().x(), (int)temp_Packman.Getpoint().y(), 10, 10);
				 //g.setFont(getFont());
			 }
			 Iterator<Fruit> it2 =f.iterator();
			 Fruit temp_Fruit ;
				// run over all the layer
				 while(it2.hasNext()) {
					 temp_Fruit=(Fruit)it2.next();
					 g.fillOval((int)temp_Fruit.Getpoint().x(),(int) temp_Fruit.Getpoint().y(), 20, 20);
					 g.setFont(getFont());
				 }
	
//		if(x!=-1 && y!=-1)
//		{
//			int r = 10;
//			x = x - (r / 2);
//			y = y - (r / 2);
//			g.fillOval(x, y, r, r);
//		}
//		if(z!=-1 && q!=-1)
//		{
//			int p = 20;
//			z = z - (p / 2);
//			q = q - (p / 2);
//			g.fillOval(z, q, p, p);
//		}
	}

	@Override
	public void mouseClicked(MouseEvent arg) {
		//if right click
		if(arg.getButton()==3) {
		System.out.println("mouse Clicked");
		System.out.println("("+ arg.getX() + "," + arg.getY() +")");
		x = arg.getX();
		y = arg.getY();
		Packman p1=new Packman(x,y,game.getPackmans().size());
		game.addPac(p1);
		repaint();
		}
		//if left click
		if(arg.getButton()==1) {
			
			x = arg.getX();
			y = arg.getY();
			Fruit p2=new Fruit(x,y,game.getFruits().size());
			game.addFru(p2);
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
