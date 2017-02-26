package com.java.polymorphism.override;

class A{
	
	int a =5;
	private void m1(){
		System.out.println("Private method m1 in class A");
	}
}

class B extends A{
	int a = 10;
	public void m1(){
		System.out.println("public method m1 in class B");
	}
}

public class PrivateOverrideTest {
	public static void main(String[] args) {
		B a = new B();
		a.m1();
		
		A obj = new B();
		System.out.println(obj.a);
	}
}
