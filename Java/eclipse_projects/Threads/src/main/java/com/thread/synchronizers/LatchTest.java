package com.thread.synchronizers;

import java.util.concurrent.CountDownLatch;

public class LatchTest {
	
	public long timeTasks(int nThreads, final Runnable task) throws InterruptedException{
		
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);
		
		for(int i=0; i<nThreads; i++){
			Thread t = new Thread(){
				public void run(){
					try {
						startGate.await();
						
						try {
							task.run();
						} finally{
							endGate.countDown();
						}
						
					} catch (InterruptedException ignored) {
						// TODO: handle exception
					}
				}
			};
			t.start();
		}
	long start = System.nanoTime();
	System.out.println("Time Tasks method Before StartGate CountDown Started");
	startGate.countDown();
	endGate.await();
	long end = System.nanoTime();
	System.out.println("Time Tasks method After EndGate CountDown Ended");
	return end - start;
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		Runnable r = new Runnable() {
			public void run() {
				System.out.println("Runnable with Thread "+Thread.currentThread().getName() +" executing.");
			}
		};
		
		LatchTest lt = new LatchTest();
		
		lt.timeTasks(5, r);
	}

}
