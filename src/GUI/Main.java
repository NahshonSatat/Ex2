package GUI;

import java.io.IOException;

import javax.swing.JFrame;

import Algorithms.GameAlgorithem;
import Coords.MyCoords;
import Coords.convert;
import Geom.Packman;
import Geom.Point3D;
import javafx.scene.shape.Line;


public class Main 
{
	public static void main(String[] args) throws IOException
	{
		Point3D g1=new Point3D(32.103506,35.207834);
		Point3D p2=new Point3D(912,388,0);
		Point3D g2=new Point3D(32.103418,35.208723);
		Map m=new Map("C:\\\\Users\\\\אליהו סתת\\\\Desktop\\\\Ariel1.png",g1,g2);
		MainWindow window = new MainWindow(m);
		window.setVisible(true);
		window.setSize(window.myImage.getWidth(),window.myImage.getHeight());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//GameAlgorithem ga=new GameAlgorithem(window.gameP);
		///window.gameP=ga.GoAlgo();
		//window.repaint();
		
//		Point3D pstart=new Point3D(0,0,0);
//		Point3D pend=new Point3D(1433,642,0);
//		Point3D gstart=new Point3D(32.105730,35.202306,0);
//		Point3D gend=new Point3D(32.101867,35.212407,0);
//		Packman t2=new Packman(32.102494,35.207475,1);
//		Packman t1=new Packman(733,537,1);
//		Packman t3=new Packman(32.104981,35.208311,1);
//		Packman t4=new Packman(850,128,1);
//		convert m1=new convert(1433,642,35.202306,32.105730,35.212407,32.101867);
		//m1.PacGps2Pix(t3);
		//Line l=new  Line(0,0,10,10);
		//m1.PacPix2Gps(t4);
		//System.out.println(m1.gps2pix(t2));
		//Point3D t2=new Point3D(32.102498,35.207475);
		//Point3D t3=new Point3D(732,540);
        //System.out.println(m.gps2pix(t2));
	
	}
}
