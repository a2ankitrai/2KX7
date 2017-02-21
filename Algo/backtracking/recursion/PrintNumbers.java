class PrintNumbers {

	public static void printRange(int n1, int n2) {
		if (n1 == n2) {
			System.out.println(n2);
		} else {
			System.out.println(n1 + " ");
			printRange(n1 + 1, n2);
		}
	}

	public static void mystery(int i) {
		if (i <= 0) { // base case
			return;
		}
		// recursive case
		System.out.println(i);
		mystery(i - 1);
		System.out.println(i);
	}


	public static void main(String[] args) {

//			printRange(5, 9);
			mystery(2);
		
	}


}