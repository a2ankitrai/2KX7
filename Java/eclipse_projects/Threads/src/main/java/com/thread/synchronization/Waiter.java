package com.thread.synchronization;

public class Waiter implements Runnable {

	private Message msg;

	public Waiter(Message msg) {
		this.msg = msg;
	}

	@Override
	public void run() { 
		String name = Thread.currentThread().getName();
		
		synchronized (msg) {
			System.out.println(name + "waiting to get notified");
			try {
				msg.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(name + "Waiter thread got notified");
		System.out.println(name + "processed "+msg.getMsg());
	}
}