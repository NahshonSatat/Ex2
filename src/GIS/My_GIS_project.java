package GIS;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

public class My_GIS_project  extends  HashSet<GIS_layer> implements GIS_project {
	/**
	 * This class represents  HashSet of layers
	 * the layers save has a HashSet
	 * Additionally its had anther data constructor that save only the mata data 
	 */
   private Meta_data_project MTP;
   
	/**
	 * empty contractor
	 */
   public My_GIS_project(){
    	super();
    	MTP=new Meta_data_project();
    }
	/**
	 * anther add function Additionally on the  add function - to save the mata data on anther data 
	 */
	public void add(MY_GIS_layer MGL1,boolean b) {
		this.add(MGL1);
		MTP.add(MGL1);
	}
	@Override
	public Meta_data get_Meta_data() {
		return MTP;
	}
 	/**
 	 * return the HashSet iterator
 	 */
    public Iterator<GIS_layer>iteretor(){
    	return this.iterator();	
    }

}
