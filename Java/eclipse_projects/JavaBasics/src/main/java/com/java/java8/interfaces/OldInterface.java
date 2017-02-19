package com.java.java8.interfaces;

public interface OldInterface {

	public void existingMethod();
	
	default public void newDefaultMethod(){
		System.out.println("New default method in interface");
		existingMethod();
	}
}
