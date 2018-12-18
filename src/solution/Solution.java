package solution;

import java.util.ArrayList;
import java.util.Iterator;

import Geom.Point3D;
import javafx.scene.shape.Line;

public class Solution {
	private ArrayList<ArrayList<Line>> Mysolution;
	
	
    public Solution() {
    	Mysolution=new ArrayList<ArrayList<Line> >();
    }
    public void add(ArrayList<Line> getPath) {
    	Mysolution.add(getPath);
    }
    public Iterator<ArrayList<Line>> iterator() {
    	return Mysolution.iterator();    
    	}
	public int size() {
		// TODO Auto-generated method stub
		return Mysolution.size();
	}
	public void clear() {
		Mysolution.clear();
	}

}

