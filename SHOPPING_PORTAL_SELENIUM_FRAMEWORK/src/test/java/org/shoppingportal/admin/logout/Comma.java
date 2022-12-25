package org.shoppingportal.admin.logout;

public class Comma {

	public static void main(String[] args) {

		String s="12, 7;how are you;11.33.1;224, 8";
		String[] str = s.split(";");

		char ch=',';
		for (int i = 0; i < str.length; i++) {

			if(str[i].indexOf(ch)>0) {
				System.out.println(str[i]);
			}


		}
		
		String t=",";
		for (int i = 0; i < str.length; i++) {

		if(str[i].contains(t)) {
			System.out.println(str[i]);
		}

		}





	}

}
