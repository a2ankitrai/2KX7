package com.thread.interruption;

class MyThread extends Thread{
	
	private void m1(){
		for(int i = 0 ;i<10;i++){
			System.out.println("Thread "+Thread.currentThread().getName() + " printing "+i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				System.out.println("Thread interrupted...");
				Thread.currentThread().interrupt();
			}
		}		
	}
	
	public void run(){
		m1();
	}

}

public class InterruptTest {
	
	public static void main(String[] args) {
		
		MyThread t1 = new MyThread();
		
		t1.start();
		t1.interrupt();
	}
}
