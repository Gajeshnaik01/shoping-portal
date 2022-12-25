package org.shoppingportal.admin.logout;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Demo1 {

	public static void main(String[] args) {
		List<Emp> list = new ArrayList<Emp>();
		Emp emp1 = new Emp(2,"Gajesh","8095523879");
		Emp emp2 = new Emp(1,"Arup","8975152753");
		Emp emp3 = new Emp(5,"Shann","8098923879");
		Emp emp4 = new Emp(6,"RAjat","8095545879");
		
		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
		list.add(emp4);

		System.out.println(list);
		Collections.sort(list);
		System.out.println(list);
		Collections.sort(list, new MyIdCompartor());
		System.out.println(list);
		Collections.sort(list, new MyEnameCompartor());
		System.out.println(list);
		
		Iterator<Emp> it = list.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
