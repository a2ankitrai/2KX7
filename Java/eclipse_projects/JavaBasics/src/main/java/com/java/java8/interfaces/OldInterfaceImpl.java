package com.java.java8.interfaces;

public class OldInterfaceImpl implements OldInterface {

	@Override
	public void existingMethod() {
		System.out.println("Implementing methods in classs");
	}
	
	/*public void newDefaultMethod(){
		System.out.println("default now in class");
	}*/

	public static void main(String[] args) {
		
		OldInterface oi = new OldInterfaceImpl();
		oi.newDefaultMethod();
	}
}
