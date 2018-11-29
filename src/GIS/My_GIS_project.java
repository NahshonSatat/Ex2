package GIS;

import java.util.Collection;
import java.util.HashSet;

public class My_GIS_project  extends  HashSet<GIS_layer> implements GIS_project {

	@Override
	public boolean add(GIS_layer e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends GIS_layer> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Meta_data get_Meta_data() {
		// TODO Auto-generated method stub
		return null;
	}

}
