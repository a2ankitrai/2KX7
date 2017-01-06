package com.thread.executor;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {

	public static void main(String[] args) {

		// Create an executor of thread pool size 3
		ExecutorService executor = Executors.newFixedThreadPool(3);

		int waitTime = 600;
		Random random = new Random();
		
		for(int i=0;i<10;i++){
			String name = "NamePrinter "+i;
			int time = random.nextInt(500);
			waitTime += time;
			Runnable r = new TaskPrint(name, time);
			System.out.println("Adding: " + name + " / " + time);
			executor.execute(r);
		}
		
		try{
			Thread.sleep(waitTime);
			executor.shutdown();
			executor.awaitTermination(waitTime, TimeUnit.MILLISECONDS);
		}catch(InterruptedException ie){
			
		}
		System.exit(0);
	}
}
