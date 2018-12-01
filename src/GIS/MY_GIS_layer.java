package GIS;

import java.text.ParseException;
import java.util.Collection;
import java.util.Iterator;
import java.util.HashSet;
public class MY_GIS_layer extends HashSet<GIS_element> implements GIS_layer {
	/**
	 * This class represents a full csv file = alot of point on the gps that made a layer 
	 * the point save has a HashSet
	 * Additionally its had anther data constructor that save only the mata data 
	 */
         private Meta_data_layer MD;
         
     	/**
     	 * empty contractor
     	 */
         public MY_GIS_layer() {
        	 super();
        	 MD=new Meta_data_layer();
         }
         
     	/**
     	 * anther add function Additionally on the  add function - to save the mata data on anther data 
     	 */
         public void add(My_GIS_element m1,boolean m2) throws ParseException {
        	 this.add(m1);
        	 MD.add(m1);
         }
         
	@Override
	public Meta_data get_Meta_data() {
		return this.MD;
	}

	/**
 	 * for the use of the Meta_data_layer function
 	 */
	public Meta_data_layer getMD() {
		return MD;
	}
	
 	/**
 	 * return the HashSet iterator
 	 */
    public Iterator<GIS_element> iteretor(){
    	return this.iterator();	
    }




}
