import java.util.Scanner;

class ArrayTest {

	public static void main(String[] args) {
		int arraySize ;

		Scanner in = new Scanner(System.in);
		System.out.println("Enter Array Size: ");
		arraySize = in.nextInt();

		int [] array = new int[arraySize];

		for (int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			System.out.print(" " + array[i] + ", ");
		}
		System.out.print("]");

	}
}