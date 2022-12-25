package org.shoppingportal.admin.logout;

public class CharectorPresent {

	public static void main(String[] args) {
		String s="abcxd xtza lmaxn";
		
		String [] str=s.split(" ");
		int n=str.length;
		
		for (char i = 'a'; i < 'z'; i++) {
			
			int c=0;
			for (int j = 0; j < str.length; j++) {
				
				
				if(str[j].indexOf(i)>=0) {
					c++;
				}
				
			}
			
			if(n==c) {
				System.out.println(i);
			}
		}

	}

}
