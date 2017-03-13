package com.java.classes;

public class ForName {
	
	void m1(){
		System.out.println("hello life..");
	}
	
	public static void main(String[] args) {
		
		try {
			Class<? extends Object> cls = Class.forName("com.java.classes.ForName");
			System.out.println(cls.getCanonicalName());
			System.out.println(cls.getPackage());
			
			try {
				ForName obj = (ForName) cls.newInstance();
				obj.m1();
				
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
