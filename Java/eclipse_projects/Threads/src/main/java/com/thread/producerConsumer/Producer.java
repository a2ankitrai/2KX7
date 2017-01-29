package com.thread.producerConsumer;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {

	List<Integer> items;

	public Producer(List<Integer> items) {
		this.items = items;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		synchronized (items) {
			while (true) {
				if (items.size() > 5) {
					try {
						System.out.println("Producer Waiting");
						items.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					items.add(new Random().nextInt());
					System.out.println("Producer Adding");
					items.notify();
				}
			}
		}

	}

}
