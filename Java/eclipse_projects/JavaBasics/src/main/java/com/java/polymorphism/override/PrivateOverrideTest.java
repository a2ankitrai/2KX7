package com.java.polymorphism.override;

class A{
	private void m1(){
		System.out.println("Private method m1 in class A");
	}
}

class B extends A{
	public void m1(){
		System.out.println("public method m1 in class B");
	}
}

public class PrivateOverrideTest {
	public static void main(String[] args) {
		B a = new B();
		a.m1();
		
	}
}
