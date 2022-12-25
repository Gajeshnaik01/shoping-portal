package org.shoppingportal.admin.logout;

public class MaxVowels {

	public static void main(String[] args) {
		String s="aeid lio aeiou aeiouaeiou al ljw";
		String[] str = s.split(" ");
		for (int i = 0; i < str.length; i++) {
			
			for (int j = i+1; j < str.length; j++) {
				
				if(numVowel(str[i])<numVowel(str[j])) {
					String temp=str[i];
					str[i]=str[j];
					str[j]=temp;
				}
				
				
			}
		}
		for (int i = 0; i < str.length; i++) {
			System.out.println(str[i]);
			
		}
		System.out.println(str[0]);
		
	}
	public static int numVowel(String s) {
		int sum=0;
		
		char[] ch = s.toLowerCase().toCharArray();
		
		for (int i = 0; i < ch.length; i++) {
			if( ch[i]=='a'||ch[i]=='e'|| ch[i]=='i'||ch[i]=='o'||ch[i]=='u') {
				sum++;
			}
			
		}
		
		
		return sum;
		
	}
	
	
	

}
