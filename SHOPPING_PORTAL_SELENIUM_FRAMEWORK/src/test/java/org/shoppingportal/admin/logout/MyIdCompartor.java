package org.shoppingportal.admin.logout;

import java.util.Comparator;

public class MyIdCompartor implements Comparator<Emp> {

	@Override
	public int compare(Emp o1, Emp o2) {
		if(o1.id==o2.id) {
			return 0;
		}
		else if(o1.id>o2.id) {
			return 1;
		}
		else  {
			return -1;
		}
		
	}

	
}
