class ShellSort {

	public static void sort(int[] a) {

		int N = a.length;

		int h = 1;

		while (h < N / 3) {
			h = 3 * h + 1; // 1, 4, 13, 40, 121, 364 ....    3x+1 increment sequence.
		}

		while (h >= 1) {
			// h-sort the array

			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && a[j] < a[j - h]; j--) {
					swap(a, j, j - h);
				}
			}
			h = h / 3;
		}
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void printArray(int[] a){
		for (int i : a) {
			System.out.print(i + " ");
		}
	}

	public static void main(String[] args) {

		int b[] = {54, 24, 76, 2, 5, 24, 1, 56, 99, 345, 312, 203};
		sort(b);
		printArray(b);
	}

}