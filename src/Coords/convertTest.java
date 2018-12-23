package Coords;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Geom.Fruit;
import Geom.Packman;
import Geom.PathPoint;
import javafx.scene.shape.Line;

class convertTest {

	//@BeforeAll
	//static void setUpBeforeClass() throws Exception {
	//}

	//@AfterAll
	//static void tearDownAfterClass() throws Exception {
	//}

	//@BeforeEach
	//void setUp() throws Exception {
	//}

	//@AfterEach
	//void tearDown() throws Exception {
	//}

	@Test
	void testConvert() {
		convert n=new convert (1433,642,35.202306,32.105730, 35.212407,-32.101867);
		Assert.assertEquals(1433, n.getMapWidth());
		Assert.assertEquals(642, n.getMapHeight());
		if (35.202306==n.getMapLongitudeStart())
			System.out.println("good");
		else
			fail("not good");
		if (32.105730==n.getMapLatitudeStart())
			System.out.println("good");
		else
			fail("not good");
		if (0.010100999999998805==n.getMapLongitude())
			System.out.println("good");
		else
			fail("not good");
		if (64.20759699999999==n.getMapLatitude())
			System.out.println("good");
		else
			fail("not good");
	}

	@Test
	void testPacPix2Gps() {
		Packman p=new Packman (35.207475,32.102494,5);
		convert n=new convert (1433,642,35.202306,32.105730, 35.212407,-32.101867);
		Packman p1=new Packman(35.207475,32.102494,4);
		p1=n.PacPix2Gps(p);
		if (28==p1.Getpoint().ix())
			System.out.println("good");
		else
			fail("not good");
		if (35==p1.Getpoint().iy())
			System.out.println("good");
		else
			fail("not good");
	}

	@Test
	void testPacGps2Pix() {
		
		Packman p=new Packman (35.207475,32.102494,5);
		convert n=new convert (1433,642,35.202306,32.105730, 35.212407,-32.101867);
		Packman p1=new Packman(35.207475,32.102494,4);
		p1=n.PacGps2Pix(p);
		System.out.println(p1.Getpoint().ix());
		System.out.println(p1.Getpoint().iy());


	}

	@Test
	void testPathPointGps2Pix() {
		Packman p=new Packman (35.207475,32.102494,5);
		convert n=new convert (1433,642,35.202306,32.105730, 35.212407,-32.101867);
		Packman p1=new Packman(35.207475,32.102494,4);
		PathPoint p2=new PathPoint(p1.Getpoint(),p1.GetTime());
		PathPoint p3=new PathPoint(p.Getpoint(),p.GetTime());
		p3=n.PathPointGps2Pix(p2);
		System.out.println(p3);
		
	}

	@Test
	void testLineGps2Pix() {
		Packman p=new Packman (35.207475,32.102494,5);
		convert n=new convert (1433,642,35.202306,32.105730, 35.212407,-32.101867);
		Packman p1=new Packman(35.207475,32.102494,4);
		Line l=new Line ();
		Line l1=new Line ();
		l1=n.LineGps2Pix(l);
		System.out.println(l1);
		
		
		
		
	}

	@Test
	void testSetFrame() {
		Packman p=new Packman (35.207475,32.102494,5);
		convert n=new convert (1433,642,35.202306,32.105730, 35.212407,-32.101867);
		Packman p1=new Packman(35.207475,32.102494,4);
		n.setFrame(2, 1);
		Assert.assertEquals(2, n.getMapWidth());
		Assert.assertEquals(1, n.getMapHeight());
	}

	@Test
	void testFruPix2Gps() {
		Fruit f=new Fruit (35.207475,32.102494,5);
		convert n=new convert (1433,642,35.202306,32.105730, 35.212407,-32.101867);
		Fruit f1=new Fruit(35.207475,32.102494,4);
		f1=n.FruPix2Gps(f);
		if (28.89510072048767==f1.Getpoint().x())
			System.out.println("good");
		else
			fail("not good");
		if (35.202554172159786==f1.Getpoint().y())
			System.out.println("good");
		else
			fail("not good");
	}

	@Test
	void testFruGps2Pix() {
		Fruit f=new Fruit (35.207475,32.102494,5);
		convert n=new convert (1433,642,35.202306,32.105730, 35.212407,-32.101867);
		Fruit f1=new Fruit(35.207475,32.102494,4);
		f1=n.FruGps2Pix(f);
		
		if (-439761==f1.Getpoint().ix())
			System.out.println("good");
		else
			fail("not good");
		if (-31==f1.Getpoint().iy())
			System.out.println("good");
		else
			fail("not good");
	}

}
