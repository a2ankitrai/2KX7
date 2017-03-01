package com.java.exception;

public class StaticException {

	static {
		try {
			throw new Exception();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
	}
}
