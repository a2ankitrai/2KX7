package com.thread.synchronizers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Task1 implements Runnable {

	CyclicBarrier cb;

	public Task1(CyclicBarrier cb) {
		this.cb = cb;
	}

	public void run() {
		int i = 1;

		while (i < 50) {
			System.out.print(i + " ");
			i = i + 3;
			try {
				cb.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Task2 implements Runnable {

	CyclicBarrier cb;

	public Task2(CyclicBarrier cb) {
		this.cb = cb;
	}

	public void run() {
		int i = 2;

		while (i < 50) {
			System.out.print(i + " ");
			i = i + 3;
			try {
				cb.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class Task3 implements Runnable {

	CyclicBarrier cb;

	public Task3(CyclicBarrier cb) {
		this.cb = cb;
	}

	public void run() {
		int i = 3;

		while (i < 50) {
			System.out.print(i + " ");
			i = i + 3;
			try {
				cb.await();
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

class CyclicBarrierEvent implements Runnable {

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

}

public class BarrierTest {

	public static void main(String[] args) {

		CyclicBarrier cb = new CyclicBarrier(3, new CyclicBarrierEvent());

		Task1 t1 = new Task1(cb);
		Task2 t2 = new Task2(cb);
		Task3 t3 = new Task3(cb);

		new Thread(t1).start();
		new Thread(t2).start();
		new Thread(t3).start();

	}
}
