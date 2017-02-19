package com.java.collections.set;

import java.util.HashSet;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.TreeMap;

class Student{
	
	int id;
	
	Student(int id){
		this.id =id;
	}
	
	
}

public class HashSetTest {

	public static void main(String[] args) {
/*
		HashSet<Student> set = new HashSet<>();
		System.out.println(set.add(new Student(1)));
		System.out.println(set.add(new Student(1)));
		System.out.println(set.add(new Student(1)));*/
		
	NavigableMap<User, Integer> map = new TreeMap<User, Integer>();
		  User u1 = new User(88,"Chandresh");
		  User u2 = new User(66,"Vashistha");
		  map.put(u1, 1);
		  map.put(u2, 2);
		  
		  for(Entry<User, Integer> user: map.entrySet()){
		   System.out.println(user.getKey().getId());
		  }
		
	}
}
