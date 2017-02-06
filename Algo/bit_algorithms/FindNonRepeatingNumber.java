class FindNonRepeatingNumber {


	public static void repeatingNum(int[] a) {

		if (a == null || a.length == 0) {
			return ;
		}

		int x = 0, y = 0;

		int xor = a[0];

		for (int i = 1; i < a.length; i++) {
			xor ^= a[i];
		}

		System.out.println(xor);

		/* Get the rightmost set bit in set_bit_no */
		int	set_bit_no = xor & ~(xor - 1);
	}

	public static void main(String[] args) {

		int arr[] = {2, 4, 7, 9, 2, 4, 9};

		repeatingNum(arr);

	}

}