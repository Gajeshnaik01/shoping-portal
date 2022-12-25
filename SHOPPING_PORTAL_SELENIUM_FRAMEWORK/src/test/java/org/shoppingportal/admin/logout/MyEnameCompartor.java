package org.shoppingportal.admin.logout;

import java.util.Comparator;

public class MyEnameCompartor implements Comparator<Object>{

	@Override
	public int compare(Object o1, Object o2) {
		Emp e1=(Emp)o1;
		Emp e2=(Emp)o2;
		
		if(e1.ename.equals(e2.ename)) {
			return 0;
		}
		else if(e1.ename.compareTo(e2.ename)>0){
			return 1;
		}
		else {
			return -1;
		}
	}
}
