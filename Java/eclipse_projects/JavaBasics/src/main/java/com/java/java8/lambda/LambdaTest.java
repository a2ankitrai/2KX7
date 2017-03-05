package com.java.java8.lambda;

public class LambdaTest {

	public static void greeter(MyLambda m){
		m.sample();
	}	
	
	public static void main(String[] args) {
		
		MyLambda m = () -> System.out.println("hello words");
		
		m.sample();
		
		greeter(m);
		greeter(() -> System.out.println("hello words"));
		
		
		String s = "Ankit Rai";
		
		LambdaWidArgs lw = (str) -> System.out.println("Hello "+s);
		lw.method(s+"23");
		
		
		DoubleNumberFunction dn = (int a) -> a*2;
		
		System.out.println(dn.doubleNumberFunction(3));
		
	}
}
