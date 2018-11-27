package Coords;

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
		Point3D expected=new Point3D(32.10575449170983,35.205808273742996,650);
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
		double expected =362.98;
		assertEquals(expected, actual,0.1);
	}
	
	// not working
	@Test
	void testvector3D() {
		MyCoords md = new MyCoords();
		Point3D a=new Point3D(32.10332,35.20904,670);
		Point3D b=new Point3D(32.10635,35.205223,650);
		Point3D actual =md.vector3D(a, b);
		Point3D expected=new Point3D(337.699,-359.249,-20);
		//System.out.println(actual.x()+","+actual.y()+","+actual.z());
		//System.out.println(expected.x()+","+expected.y()+","+expected.z());
		if(actual.x()!=expected.x()||actual.y()!=expected.y()||actual.z()!=expected.z()) {
			fail("this sepus to be -32.10575449170983,35.205808273742996,650");
		}
	}
//	@Test
//	void testazimuth_elevation_dist() {
//		fail("Not yet implemented");
//	}
//	@Test
//	void testisValid_GPS_Point() {
//		fail("Not yet implemented");
//	}

}
