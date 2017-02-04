package com.thread.synchronization;

public class ConstructorSynchronizeTest {

	private ConstructorSynchronizeTest() {
		System.out.println("intializing");
	}

	static void factory() {
		synchronized (ConstructorSynchronizeTest.class) {
			new ConstructorSynchronizeTest();
		}
	}
}
