package com.java.collections.set;

import java.util.TreeSet;

class Person{
	String name;
	int id;
	
	public boolean equals(Person p){
		return this.id == p.id;
	}
	
	public int hashcode(){
		return 31*id;
	}
}

public class TreeSetTest {

	
	public static void main(String[] args) {
		
		TreeSet<Person> set = new TreeSet<>();
		
		set.add(new Person());
		set.add(new Person());
		set.add(new Person());
		
		System.out.println(set);
	}
}
