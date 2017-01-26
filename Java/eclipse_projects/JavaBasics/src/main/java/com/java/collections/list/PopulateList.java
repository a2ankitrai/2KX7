package com.java.collections.list;

import java.util.ArrayList;

public class PopulateList {

	public static void main(String[] args) {
		ArrayList l1 = null;
		populateList(l1);
		System.out.println(l1.size());
		System.out.println(l1.get(0));
	}
	
	public static void populateList(ArrayList l){
		l = new ArrayList();
		l.add(1);
		l.add(2);
		System.out.println(l.get(0)); 
	}
}
