package com.java.garbageCollection;

public class NumberOfAvailableProcessors {

	public static void main(String[] args) {

		Runtime runtime = Runtime.getRuntime();

		System.out.println("Total Number Of Processors Available: "
				+ runtime.availableProcessors());

		System.out.println("Total amount of memory: " + runtime.totalMemory());

		System.out.println("Max amount of memory JVM can use: " + runtime.maxMemory());
		
		runtime.halt(1); // pass status as 1

		System.out.println("JVM (Java virtual machine) halted");

	}
}
