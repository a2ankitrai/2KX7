package com.java.serialization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

class A implements Serializable{
	
	int a = 0;
	
}

class B{
	int b =5;
}

public class NotSerializableTest implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	A a;
	B b;
	
	public static void main(String[] args) {
		
		NotSerializableTest ns = new NotSerializableTest();
		OutputStream fout;
		try {
			fout = new FileOutputStream("ser.txt");
		
		ObjectOutput oout = new ObjectOutputStream(fout);
		oout.writeObject(ns);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Error");
			e.printStackTrace();
		}
		
		InputStream fin;
		try {
			fin = new FileInputStream("ser.txt");
		
		ObjectInput oin=new ObjectInputStream(fin);
		System.out.println("DeSerialization process has started, displaying employee objects...");
		
		NotSerializableTest ns2=(NotSerializableTest)oin.readObject();
		
		System.out.println(ns2.b);
		} catch ( IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
