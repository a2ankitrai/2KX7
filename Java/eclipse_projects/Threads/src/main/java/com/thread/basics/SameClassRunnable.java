package com.thread.basics;

public class SameClassRunnable implements Runnable {

	public static void main(String[] args) {
	//	Thread t = new Thread(this); //Cannot use this in a static context
	//	t.start();
	}

	@Override
	public void run() {
		System.out.println("Test");
	}
}
