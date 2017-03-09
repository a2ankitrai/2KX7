package com.java.generics;

import java.util.List;

public class GenericMethod {

	public static void printList(List<?> list) {
	    for (Object elem: list)
	        System.out.print(elem + " ");
	    System.out.println();
	}
	
	public static <T extends Number> T getSumList(List<T> list){
		Integer t = list.get(0).intValue();
		
		for(int i=1;i<list.size();i++){
			t = t+ list.get(i).intValue();
		}
		
		return (T) t;
	}
}
