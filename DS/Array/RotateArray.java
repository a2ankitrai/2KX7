class RotateArray {

	public static void rotate(int[] a, int d) {
		int n = a.length;

		if (d == n) {return;}

		if (d > n) {d = d - n;}

		for (int i = 0; i < d; i++) {

			int temp = a[0];

			for (int j = 0; j + 1 < n; j++) {
				a[j] = a[j + 1];
			}
			a[n - 1] = temp;
		}
	}

	public static void main(String[] args) {
		int arr[] = {1, 2, 3, 4, 5, 6, 7};
		int d = 10;

		rotate(arr, d);

		for (int i : arr) {
			System.out.print(" " + i);
		}


	}
}