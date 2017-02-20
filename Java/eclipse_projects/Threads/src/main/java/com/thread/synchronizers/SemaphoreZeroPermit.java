package com.thread.synchronizers;

import java.util.concurrent.Semaphore;

class MyRunnable implements Runnable {

	Semaphore semaphore;

	public MyRunnable(Semaphore semaphore) {
		this.semaphore = semaphore;
	}

	public void run() {
		System.out.println(Thread.currentThread().getName()
				+ " is waiting for permit");
		try {
		//	semaphore.release();
			semaphore.acquire();
			System.out.println(Thread.currentThread().getName()
					+ " has got permit");

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

}

public class SemaphoreZeroPermit {

	public static void main(String[] args) {

		Semaphore s = new Semaphore(0);
		new Thread(new MyRunnable(s), "Thread-1").start();
	}

}
