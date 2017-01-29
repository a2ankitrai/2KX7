package com.thread.producerConsumer;

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerTest {

	public static void main(String[] args) {
		
		List<Integer> items =  new ArrayList<>();
		
		Producer p = new Producer(items);
		Consumer c = new Consumer(items);
		
		Thread tP = new Thread(p);
		Thread tC = new Thread(c);
		
		tP.start();
		tC.start();
		
	}
}
