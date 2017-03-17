package com.java.string;

public class StringCompare {

	public static void main(String[] args) {
		
		String s1 = "abc";
		String s2 = "abc";
		String s3 = new String("abc");
		
		System.out.println(s1 == s2);
		
		System.out.println(s1 == s3);
		
		System.out.println(s1 == s3.intern());
		 
		System.out.println("---------------");
		
		String s4 = new String("xyz");
		String s5 = new String("xyz");
		
		System.out.println(s4.equals(s5));
		System.out.println(s4 == s5);
		System.out.println(s4.intern() == s5.intern());
		
		
	}
}
