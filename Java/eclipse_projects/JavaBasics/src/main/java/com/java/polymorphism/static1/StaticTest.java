package com.java.polymorphism.static1;

public class StaticTest {
	
	public static void main(String[] args) {
		Super s1 = new Sub();
		
		s1.m1();
		s1.m2();	
		s1.m3();
	}
}
