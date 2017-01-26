package com.java.serialization;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class SerializeEmployee {

	public static void main(String[] args) {

		Employee e1 = new Employee(1, "Ankit");
		Employee e2 = new Employee(2, "Jason");
		
		try{
			File f = new File("ser.txt");
			if(!f.exists()){
				f.createNewFile();
			}
			
			OutputStream os = new FileOutputStream("ser.txt");
			ObjectOutput oo = new ObjectOutputStream(os);
			
			System.out.println("Begining Serialization");
			oo.writeObject(e1);
			oo.writeObject(e2);
			oo.close();
			System.out.println("Serialization Completed");
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
		
	}

}
