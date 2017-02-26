package com.java.collections.tree;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

class Student {
	int id;
	
	Student(int id){
		this.id = id;
	}
	
	public String toString(){
		return "Student - "+id;
	}
}

public class TreeMapTest {

	public static void main(String[] args) {
		
		// java.lang.ClassCastException:Student cannot be cast to java.lang.Comparable
		// Map<Student,Integer> map = new TreeMap<>(); 
	
		Map<Student,Integer> map = new HashMap<>(); 
		
		Student s1 = new Student(1);
		Student s2 = new Student(2);
		
		map.put(s1, 1);
		map.put(s2, 2);
		
		System.out.println(map);
		
	}
}
