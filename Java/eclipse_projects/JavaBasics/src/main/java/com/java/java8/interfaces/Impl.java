package com.java.java8.interfaces;

public class Impl implements InterfaceA, InterfaceB {
	public void defaultMethod(){
		 InterfaceB.super.defaultMethod();
    }
	
	public static void main(String[] args) {
		
		Impl i  = new Impl();
		i.defaultMethod();
	}
}
