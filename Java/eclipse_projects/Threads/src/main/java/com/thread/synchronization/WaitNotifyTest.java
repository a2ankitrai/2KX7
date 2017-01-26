package com.thread.synchronization;

public class WaitNotifyTest {

	public static void main(String[] args) {
		
		Message m = new Message("Hello Threads");
		Waiter w1 = new Waiter(m);
		Waiter w2 = new Waiter(m);
		
		new Thread(w1,"waiter 1").start();
		new Thread(w2,"waiter 2").start();
		
		Notifier n = new Notifier(m);
		new Thread(n, "notifier").start();
		
		System.out.println("All Threads started");
	}

}
