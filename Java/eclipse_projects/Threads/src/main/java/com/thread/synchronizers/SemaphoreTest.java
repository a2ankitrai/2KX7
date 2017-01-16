package com.thread.synchronizers;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Semaphore;

class BoundedHashSet<T> {

	private final Set<T> set;
	private final Semaphore sem;

	public BoundedHashSet(int bound) {
		this.set = Collections.synchronizedSet(new HashSet<T>());
		sem = new Semaphore(bound);
	}

	public boolean add(T o) throws InterruptedException {
		sem.acquire();
		boolean wasAdded = false;
		try {
			wasAdded = set.add(o);
			return wasAdded;
		} finally {
			if (!wasAdded) {
				sem.release();
			}
		}
	}

	public boolean remove(Object o) {
		boolean wasRemoved = set.remove(o);
		if (wasRemoved) {
			sem.release();
		}
		return wasRemoved;
	}
}

public class SemaphoreTest {

	public static void main(String[] args) {

		final BoundedHashSet<String> bhs = new BoundedHashSet(1);

		new Thread() {
			@Override
			public void run() {
				try {
					String t1 = "Thread 1 entry";
					bhs.add(t1);

					Thread.sleep(1000);
					
					bhs.remove(t1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();

		new Thread() {
			@Override
			public void run() {
				try {
					String t1 = "Thread 1 entry";
					bhs.add(t1);

					Thread.sleep(1000);

					bhs.remove(t1);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}.start();
	}
}
