package com.java.collections.hashMap;

import java.util.HashMap;

public class HashMapTest {

	public static void main(String[] args) {
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		map.put(0,0);
		map.put(2,0);
		map.put(3,0);
		map.put(1,0);
		
		map.put(0,6);
	
		System.out.println(map);
	}
}
