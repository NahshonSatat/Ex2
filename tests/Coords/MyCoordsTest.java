package Coords;
import Geom.Point3D;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Geom.Point3D;

class MyCoordsTest {
	//
	//	@BeforeAll
	//	static void setUpBeforeClass() throws Exception {
	//	}
	//
	//	@AfterAll
	//	static void tearDownAfterClass() throws Exception {
	//	}
	//
	//	@BeforeEach
	//	void setUp() throws Exception {
	//	}
	//
	//	@AfterEach
	//	void tearDown() throws Exception {
	//	}

	@Test
	void testadd() {
		MyCoords md = new MyCoords();
		Point3D a=new Point3D(32.103315,35.209039,670);
		Point3D b=new Point3D(337.699,-359.249,-20);
		Point3D actual = new Point3D(md.add(a, b));
		Point3D expected=new Point3D(32.10690028075636,35.204371146454925,650.0);
		if(actual.x()!=expected.x()||actual.y()!=expected.y()||actual.z()!=expected.z()) {
			fail("this sepus to be -32.10575449170983,35.205808273742996,650");
		}
	}
	@Test
	void testdistance3d() {
		MyCoords md = new MyCoords();
		Point3D a=new Point3D(32.101078,35.207898,670);
		Point3D b=new Point3D(32.102030,35.204212,650);
		double actual =md.distance3d(a, b);
		double expected =363.52;
		assertEquals(expected, actual,0.1);
	}

	// not working
	@Test
	void testvector3D() {
		MyCoords md = new MyCoords();
		Point3D a=new Point3D(32.10332,35.20904,670);
		Point3D b=new Point3D(32.10635,35.205223,650);
		Point3D actual =md.vector3D(a, b);
		Point3D expected=new Point3D(285.3977399528958,-293.7637650333345,-20);
		//System.out.println(actual.x()+","+actual.y()+","+actual.z());
		//System.out.println(expected.x()+","+expected.y()+","+expected.z());
		if(actual.x()!=expected.x()||actual.y()!=expected.y()||actual.z()!=expected.z()) {
			fail("this sepus to be -32.10575449170983,35.205808273742996,650");
		}
	}
	@Test
	void testazimuth_elevation_dist() {
		MyCoords md = new MyCoords();
		Point3D a=new Point3D(32.10332,35.20904,670);
		Point3D b=new Point3D(32.10635,35.205223,650);

		double actual []= new double[3];
		actual=md.azimuth_elevation_dist(a,b);
		double expected []= new double[3];
		expected[0]=141.5568515683036;
		expected[1]=-89.98603863144795;
		expected[2]=493.1314354225428;
		if(actual[0]!=expected[0]||actual[1]!=expected[1]||actual[2]!=expected[2]) {
			fail("this sepus to be 141.5568515683036,-89.98603863144795,493.1314354225428");
		}



	}
	@Test
	void testisValid_GPS_Point() 
	{
		MyCoords md = new MyCoords();
		Point3D x1=new Point3D(32,35,670);
		Point3D x2=new Point3D(32,35,9000);
		Point3D x3=new Point3D(32,35,-600);
		Point3D x4=new Point3D(32,100,670);
		Point3D x5=new Point3D(32,-100,670);
		Point3D x6=new Point3D(1000,35,670);
		Point3D x7=new Point3D(-1000,35,670);
		boolean flag=true;
		boolean flag1=true;
		flag1= md.isValid_GPS_Point(x2);
		if (flag == flag1)
		{
			fail("this sepus to be false");
		}
		flag1= md.isValid_GPS_Point(x3);
		if (flag==flag1)
		{
			fail("this sepus to be false");
		}
		flag1= md.isValid_GPS_Point(x4);
		if (flag==flag1)
		{
			fail("this sepus to be false");
		}
		flag1= md.isValid_GPS_Point(x5);
		if (flag==flag1)
		{
		fail("this sepus to be false");
		}
		flag1= md.isValid_GPS_Point(x6);
		if (flag==flag1)
		{
			fail("this sepus to be false");
		}
		flag1= md.isValid_GPS_Point(x7);
		if (flag==flag1)
		{
			fail("this sepus to be false");
		}
		flag1= md.isValid_GPS_Point(x1);
		if (flag!=flag1)
		{
			fail("this sepus to be true");
		}

	}
	@Test
	void testdistance2d() 
	{
		MyCoords md = new MyCoords();
		Point3D x1=new Point3D(32,35,670);
		Point3D x2=new Point3D(30,37,50);
        double actual=md.distance2d(x1, x2);
		double expected =291395.7173942502;
		assertEquals(expected, actual);
	}

}
