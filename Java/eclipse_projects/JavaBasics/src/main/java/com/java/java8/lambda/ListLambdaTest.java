package com.java.java8.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class ListLambdaTest {
	public static void main(String[] args) {
		
		List<Person> people = Arrays.asList(
				new Person("Charles","Dicken", 60),
				new Person("Lewis", "Carrol", 20),
				new Person("Thomas", "Caobal", 40),
				new Person("Jpoes", " Broen", 23),
				new Person("Kristen", "johnson", 34)
				);
		
		
		Collections.sort(people,(Person a, Person b)->a.name.compareTo(b.name));
		
		for(Person p: people){
			System.out.println(p);
		}
	}	
}
