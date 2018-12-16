package GUI;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Algorithms.GameAlgorithem;
import Coords.convert;
import Geom.Fruit;
import Geom.Game;

import Geom.Packman;
import Geom.Point3D;
import Geom.myLine;
import javafx.scene.shape.Line;
import javafx.stage.FileChooser;




public class MainWindow extends JFrame implements MouseListener
{
	private static final ImageIO ImegeIO = null;
	public Game gameP;
    public Map map;
	public BufferedImage myImage;
	public convert m1;
	public Image p1;
	public Image f1;
	// the constructor 
	public MainWindow(Map map) throws IOException 
	{
		this.map=map;
		gameP=new Game();
		File pacFile = new File("C:\\Users\\אליהו סתת\\Downloads\\1.png");
		p1=ImageIO.read(pacFile);
		initGUI();		
		this.addMouseListener(this);
		
		 m1=new convert(1433,642,35.202306,32.105730,35.212407,32.101867);
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
        // acording to https://stackoverflow.com/questions/22261130/how-to-save-a-file-using-jfilechooser-showsavedialog
			@Override
			public void actionPerformed(ActionEvent arg0) {
		        String filename = JOptionPane.showInputDialog("Name this file");
		        JFileChooser savefile = new JFileChooser();
		        savefile.setSelectedFile(new File(filename));
		        savefile.showSaveDialog(savefile);
		        int sf = savefile.showSaveDialog(null);
		        if(sf == JFileChooser.APPROVE_OPTION){
		          	
		            	filename=""+savefile.getSelectedFile();

		        	try {
						gameP.gametocsv(filename);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		                JOptionPane.showMessageDialog(null, "File has been saved","File Saved",JOptionPane.INFORMATION_MESSAGE);
		                // true for rewrite, false for override

//		            } catch (IOException e) {
//		                e.printStackTrace();
//		            }
		        }else if(sf == JFileChooser.CANCEL_OPTION){
		            JOptionPane.showMessageDialog(null, "File save has been canceled");
		        }
			//System.out.println("game saved");
			
			gameP.clear();
			repaint();
			}
			
		});
		
		// the "load" action
		item2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
        // according to https://stackoverflow.com/questions/18774652/how-to-use-jfilechooser-to-find-a-file-location
                JFileChooser fc = new JFileChooser();

                int returnVal = fc.showOpenDialog(null);
                fc.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION) {
                    File file = fc.getSelectedFile();
                    if(!file.getAbsolutePath().contains(".csv")) {
                    	System.out.println("this is not csv file!!!");
                    }
                    else {
                    System.out.println("Opening: " + file.getAbsolutePath());
				    gameP.clear();
				try {
					gameP.csvtogame(file.getAbsolutePath());
				} catch (Exception e) {
					e.printStackTrace();
				}
                    }
			repaint();
			}
			}
		});
		
		// the "new gameP" action
		item3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				GameAlgorithem ga=new GameAlgorithem(gameP);
				gameP=ga.GoAlgo();
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
			// myImage = ImageIO.read(new File("C:\\Users\\נחשון סתת\\Desktop\\Ariel1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	
	
	
	int x = -1;
	int y = -1;
	
	public void paint(Graphics g)
	{
		m1.setFrame(this.getWidth(), this.getHeight());
		ArrayList<Packman>p=gameP.getPackmans();
		ArrayList<Fruit>f=gameP.getFruits();
		g.drawImage(myImage, 0, 0,this.getWidth(),this.getHeight(), this);
		//System.out.println(this.getWidth()+","+this.getHeight());
		 // print the Packmans
		 Iterator<Packman> it1 =p.iterator();
		 Packman temp_Packman ;
			 while(it1.hasNext()) {
				 temp_Packman=(Packman)it1.next();
				 //System.out.println(temp_Packman);
				 temp_Packman=m1.PacGps2Pix(temp_Packman);
				// System.out.println(temp_Packman);
				 g.setColor(Color.yellow);
				 
				g.drawImage(p1, (int)temp_Packman.Getpoint().x(),  (int)temp_Packman.Getpoint().y(), 20, 20,this);
				// g.fillOval((int)temp_Packman.Getpoint().x(), (int)temp_Packman.Getpoint().y(), 20, 20);
				System.out.println("packman");
				System.out.println("his line: "+temp_Packman.getPath().size());
				 Iterator<myLine> it3 =temp_Packman.getPath().iterator();
				 myLine temp_Line ;
				 while(it3.hasNext()) {
					 temp_Line=it3.next();
					 System.out.println("line draw!");
					 temp_Line=m1.LineGps2Pix(temp_Line);
					 
					 g.drawLine(temp_Line.getStart().ix(), temp_Line.getEnd().ix(),temp_Line.getStart().iy(), temp_Line.getStart().iy());
					 }
			 }

			// g.drawLine(0,0.0,100,100);
			 // print the fruits
			 Iterator<Fruit> it2 =f.iterator();
			 Fruit temp_Fruit ;
				// run over all the layer
				 while(it2.hasNext()) {
					 temp_Fruit=(Fruit)it2.next();
					 temp_Fruit=m1.FruGps2Pix(temp_Fruit);
					 g.setColor(Color.GREEN);
					 //g.setColor(randomColor());
					 g.fillOval((int)temp_Fruit.Getpoint().x(),(int) temp_Fruit.Getpoint().y(), 10, 10);
					
				 }
	
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
		Packman p2=m1.PacPix2Gps(p1);
		myLine l=new  myLine(0,0,10,10);
		p2.add2Path(l);
		gameP.addPac(p2);
		repaint();
		}
		//if left click add Fruit
		if(arg.getButton()==3) {
			System.out.println("("+ arg.getX() + "," + arg.getY() +")");
			x = arg.getX();
			y = arg.getY();
			Fruit p1=new Fruit(x,y,gameP.getFruits().size());
			Fruit p2=m1.FruPix2Gps(p1);
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
