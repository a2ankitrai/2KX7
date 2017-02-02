package com.java.polymorphism;

class Implementor extends AbstractInitializer{
	
	public Implementor(){
		System.out.println("Implementor class constructor");
	}
	
}

public abstract class AbstractInitializer {

	public AbstractInitializer(){
		System.out.println("Abstract class method");
	}
	
	public static void main(String[] args) {
		
		Implementor a = new Implementor();
		
	}
	
}
