package com.java.exception;

public class ErrorTest {

	static int count  = 0;
	
	static void m1(){
		
		System.out.println("Current count : "+ ++count);
		try{
			m1();
		}
		catch(StackOverflowError e){
			System.out.println("Stack is overflowed");
			e.printStackTrace();
			throw e;
		}
	}
	
	public static void main(String[] args) {
		
		m1();
	}
}
