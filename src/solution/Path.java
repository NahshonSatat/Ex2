package solution;

import java.util.ArrayList;

import Geom.Point3D;
import javafx.scene.shape.Line;

public class Path {
	private ArrayList<Line> MyPath;
	
    public Path() {
    	MyPath=new ArrayList<Line>();
    }
    
    public void add(Line p) {
    	MyPath.add(p);
    }

}
