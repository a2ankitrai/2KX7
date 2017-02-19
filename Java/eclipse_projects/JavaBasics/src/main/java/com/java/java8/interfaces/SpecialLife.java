package com.java.java8.interfaces;

public class SpecialLife extends AbstractLife {

	@Override
	public void m2() {
		// TODO Auto-generated method stub
		System.out.println("m2 in Special");
	}

	public static void main(String[] args) {
		
		SpecialLife s = new SpecialLife();
		
		System.out.println(s.a);
	}
}
