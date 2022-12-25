package org.shoppingportal.admin.logout;

import org.yantra.genericUtility.ThreadSafeClass;

public class TheadString {

	public static void main(String[] args) {
		Thread t=new Thread();
		Object o =new Object();
		String s= "ABC";
		
		System.out.println(t==o);
		System.out.println(s==o);
		//System.out.println(t==s);
		
		
	}

	public static Object test() {
		
		return 'c';
	}

}
