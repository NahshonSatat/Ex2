package solution;

import java.util.ArrayList;

import Geom.Point3D;

public class Solution {
	private ArrayList<Path> MyPath;
	
	public Solution() {
		MyPath=new ArrayList<Path>();
	}
	
	public void add(Path p) {
		MyPath.add(p);
	}
}
