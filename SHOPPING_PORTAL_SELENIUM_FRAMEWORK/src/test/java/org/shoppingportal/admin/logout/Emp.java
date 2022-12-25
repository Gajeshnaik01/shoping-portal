package org.shoppingportal.admin.logout;

public class Emp implements Comparable<Emp> {

	int id;
	String ename;
	String phoneNo;
	
	public Emp(int id,String ename,String phoneNo) {
		this.id=id;
		this.ename=ename;
		this.phoneNo=phoneNo;
	}
	
	public String toString() {
		return ename;
		
	}
	
	public int compareTo(Emp e) {
		
		if(this.ename.equals(e.ename)) {
			return 0;
		}
		else if(this.ename.compareTo(e.ename)>0) {
			return 1;
		}
		else {
			return -1;
		}
	
	}
}
