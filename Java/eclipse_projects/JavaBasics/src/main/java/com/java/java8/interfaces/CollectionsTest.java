package com.java.java8.interfaces;

import java.util.ArrayList;
import java.util.List;

public class CollectionsTest {

	public static void main(String[] args) {
		
		List<String> list = new ArrayList<>();
		
		list.add("a");list.add("b");list.add("c");list.add("d");
		
		list.forEach(s -> System.out.println(s));
	}
}
