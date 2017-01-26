package com.java.serialization;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

public class DeSerializeEmployee {

	public static void main(String[] args) {

		try {
			InputStream fi = new FileInputStream("ser.txt");
			ObjectInput oi = new ObjectInputStream(fi);

			Employee e = null;

			while ((e = (Employee) oi.readObject()) != null) {
				System.out.println(e);
			}

		} catch (EOFException e) {
			System.out.println("File ended");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
