package com.thread.deadlock;

class A implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

		synchronized (String.class) {

			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName()
					+ " acqurired lock on String ");
			System.out.println("Waiting to acquire lock on Object");

			synchronized (Object.class) {
				System.out.println(Thread.currentThread().getName()
						+ " acquired lock on Object");
			}
		}
		System.out.println(Thread.currentThread().getName() + " ended.");
	}

}

class B implements Runnable {

	@Override
	public void run() {
		synchronized (Object.class) {

			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
				ie.printStackTrace();
			}

			System.out.println(Thread.currentThread().getName()
					+ " acqurired lock on Object");
			System.out.println("Waiting to acquire lock on String");

			synchronized (String.class) {
				System.out.println(Thread.currentThread().getName()
						+ " acquired lock on Object");
			}
		}
		System.out.println(Thread.currentThread().getName() + " ended.");
	}

}

public class DeadlockCreation {

	public static void main(String[] args) {
			Thread t1 = new Thread(new A(),"Thread - 1");
			Thread t2 = new Thread(new B(),"Thread - 2");
			t1.start();
			t2.start();
	}
	
}
