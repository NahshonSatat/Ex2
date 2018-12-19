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

	}
}
