package com.thread.basics;

import java.util.concurrent.atomic.AtomicInteger;


class Task1 implements Runnable {

	private Object monitor;
	private AtomicInteger counter;
	
	public Task1(Object monitor,AtomicInteger counter) {
		this.monitor = monitor;
		this.counter = counter;
	}

	public void run() {
		int i = 1;

		while (i < 50) {
		//	synchronized (monitor) {
				if(counter.get() == 0 || counter.get()==3){
					System.out.print(i + " ");
					i = i + 3;
					counter.set(1);
				}
				 
			/*	monitor.notify();
				try {
					monitor.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
		}
	}
}

class Task2 implements Runnable {

	private Object monitor;
	private AtomicInteger counter;
	
	public Task2(Object monitor,AtomicInteger counter) {
		this.monitor = monitor;
		this.counter = counter;
	}

	public void run() {
		int i = 2;

		while (i < 50) {
		//	synchronized (monitor) {
				if(counter.get() == 1){
				
				System.out.print(i + " ");
				i = i + 3;
				counter.set(2);
				}
			/*	monitor.notify();
				try {
					monitor.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
		}
	}
}

class Task3 implements Runnable {

	private Object monitor;
	private AtomicInteger counter;

	public Task3(Object monitor, AtomicInteger counter) {
		this.monitor = monitor;
		this.counter = counter;
	}

	public void run() {
		int i = 3;

		while (i < 50) {
		//	synchronized (monitor) {
				if(counter.get() == 2){
				System.out.print(i + " ");
				i = i + 3;
				counter.set(3);
				}
			/*	monitor.notify();
				try {
					monitor.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}*/
		}
	}
}


public class PatternPrint2 {

	public static void main(String[] args) {

		Object cb = new Object();
		AtomicInteger counter = new AtomicInteger(0);
		
		Task1 t1 = new Task1(cb,counter);
		Task2 t2 = new Task2(cb,counter);
		Task3 t3 = new Task3(cb,counter);

		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();

	}
}
