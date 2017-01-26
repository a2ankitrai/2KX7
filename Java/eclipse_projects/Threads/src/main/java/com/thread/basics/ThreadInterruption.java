package com.thread.basics;

class MyRunnable implements Runnable {
	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println(Thread.currentThread().getName() + "has been interrupted.");
				Thread.currentThread().interrupt();
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + ": " + i);
		}
	}
}

public class ThreadInterruption {

	public static void main(String[] args) {
		
		Runnable r =  new MyRunnable();
		
		Thread t  =  new Thread(r);
		
		t.start();
		
		t.interrupt();
		
	}
}
