package com.java.java8.lambda.part2;

public class ClosuresTest {

	public static void main(String[] args) {
		
		int a = 10;
		int b = 20;
		
		doProcess(a, i -> System.out.println(i+b));
		
		doProcess(a, i -> {
			// b++; //Local variable b defined in an enclosing scope must be final or effectively final
			System.out.println("i: " +i + b);
		});
		
	}
	
	static void doProcess(int i, Process p){
		p.process(i);
	}
}

interface Process{
	void process(int i);
}
