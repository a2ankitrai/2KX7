package com.java.collections.hashMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class SortByValues {

	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "dnk");
		map.put(2, "ank");
		map.put(3, "cnk");
		map.put(4, "bnk");
		
		List<Map.Entry> list = new ArrayList<>();
		for(Map.Entry e : map.entrySet()){
			list.add(e);
		}

		/*list.sort((Map.Entry<Integer, String> e1, Map.Entry<Integer, String> e2) -> {
			e1.getValue().toString().compareTo(e2.getValue().toString());
		});*/
		
	/*	Collections.sort(list, (Map.Entry e1, Map.Entry e2) -> {
			e1.getValue().toString().compareTo(e2.getValue().toString());
		} );*/
		
		Collections.sort(list, new Comparator<Map.Entry>() {

			@Override
			public int compare(Map.Entry e1, Map.Entry e2) {
				return e1.getValue().toString().compareTo(e2.getValue().toString());
			}
		});
		
		Map<Integer, String> linkedMap = new LinkedHashMap<>();
		for(Map.Entry e : list){
			linkedMap.put((Integer)e.getKey(),(String)e.getValue());
		}
		
		for(Map.Entry e : linkedMap.entrySet()){
			System.out.println(e.getKey()+" -- "+e.getValue());
		}
		
		
	}
}
