import java.util.*;
import java.io.*;

class PrintReverse {

	public static void printRecursive(Scanner input) {
		if (!input.hasNextLine()) { // base case
			return;
		}
		String line = input.nextLine();		
		printRecursive(input); // print the rest
		System.out.println(line);
	}

	public static void main(String[] args) throws FileNotFoundException , IOException {
		Scanner sc = new Scanner(new File("sample.txt"));
		printRecursive(sc);
	}

}