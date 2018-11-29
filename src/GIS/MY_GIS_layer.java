package GIS;

import java.text.ParseException;
import java.util.Collection;
import java.util.Iterator;
import java.util.HashSet;
public class MY_GIS_layer extends HashSet<GIS_element> implements GIS_layer {
         private Meta_data_layer MD;
         
         public MY_GIS_layer() {
        	 super();
        	 MD=new Meta_data_layer();
         }
         
         public void add(My_GIS_element m1,My_GIS_element m2) throws ParseException {
        	 this.add(m1);
        	 MD.add(m1);
         }
         
	@Override
	public Meta_data get_Meta_data() {
		return this.MD;
	}

	public Meta_data_layer getMD() {
		return MD;
	}
    public Iterator<GIS_element> iterator(){
    	return this.iterator();	
    }




}
