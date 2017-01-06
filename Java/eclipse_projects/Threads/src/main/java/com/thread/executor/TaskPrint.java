package com.thread.executor;

public class TaskPrint implements Runnable {

	private final String name;
	private final int delay;

	public TaskPrint(String name, int delay) {
		super();
		this.name = name;
		this.delay = delay;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		System.out.println("Staring " + name);
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Done with " + name);
	}

}
