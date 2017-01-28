package com.thread.basics;

class CThread extends Thread{
	
	public void run(){
		System.out.println("Inside run of Cthread");
		System.out.println("Thread name :"+Thread.currentThread().getName());
		m1();
	}
	
	public void start(){
		System.out.println("Overridden start");
		run();		
	}
	
	private void m1(){
		System.out.println("Inside m1");
	}
}

public class StartOverrideTest {
	public static void main(String[] args) {
		
		CThread t = new CThread();
		
		System.out.println("Inside Main");
		
		t.start();
	}
}
