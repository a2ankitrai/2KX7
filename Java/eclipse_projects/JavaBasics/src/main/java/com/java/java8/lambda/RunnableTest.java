package com.java.java8.lambda;

public class RunnableTest {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Inside runnable "+ Thread.currentThread().getName());
			}
		});
		
		Thread t2 = new Thread(()-> System.out.println("Inside Lambda runnable "+
		Thread.currentThread().getName()));
	
		t1.start();t2.start();
		
	}
	
}
