package com.java.exception;

public class StaticException {

	static {
		try {
			throw new RuntimeException();
		} catch (RuntimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
	}
}
