package GIS;

import java.util.Collection;
import java.util.HashSet;

public class My_GIS_project  extends  HashSet<GIS_layer> implements GIS_project {
    private Meta_data_project MTP;
   public My_GIS_project(){
    	super();
    	MTP=new Meta_data_project();
    }
	public void add(MY_GIS_layer MGL1,boolean b) {
		this.add(MGL1);
		MTP.add(MGL1);
	}
	@Override
	public Meta_data get_Meta_data() {
		return MTP;
	}

}
