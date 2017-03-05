package com.java.java8.lambda;

public class TypeInference {
	
	public static void getLength(StringLen l){
		System.out.println(l.getLen("Ankit Rai"));
	}
	
	public static void main(String[] args) {
		StringLen sl = s -> s.length();
		
		getLength(s -> s.length());
		
		AddNum adder = (a,b) -> a+b;		
		System.out.println(adder.add(3, 5));
		
	}
}

interface StringLen{
	int getLen(String s);
}

interface AddNum{
	int add(int a, int b);
}