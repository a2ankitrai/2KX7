package com.java.collections.hashMap;

import java.util.LinkedHashMap;

public class LinkedHashMapTest {

	public static void main(String[] args) {
		
		LinkedHashMap<Integer, String> lmap = new LinkedHashMap<Integer, String>();
		
		lmap.put(1,"a");
		lmap.put(2,"b");
		lmap.put(3,"c");
		lmap.put(4,"d");
		
		for(Integer i : lmap.keySet()){
			System.out.println(i+ "-" +lmap.get(i));
		}
		lmap.remove(3);

		lmap.put(3,"c");
		
		for(Integer i : lmap.keySet()){
			System.out.println(i + "->"+lmap.get(i));
		}
		
	}
}
