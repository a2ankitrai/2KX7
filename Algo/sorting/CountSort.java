class CountSort {

	// Does not work. There is some error. Run it. Fix it.

	public static int[] sort(int[] a, int k) {
		int[] c = new int[k];
		int[] b = new int[a.length];

		for (int i = 0; i < k; i++) {
			c[i] = 0;
		}

		for (int j = 0; j < a.length; j++) {
			++c[a[j]];
		}

		for (int i = 1; i < k; i++) {
			c[i] += c[i - 1];
		}

		for (int j = a.length - 1; j >= 0; j--) {
			b[c[a[j] - 1]] = a[j];
			--c[a[j]];

		}

		return b;
	}

	public static void main(String[] args) {
		int[] a = {1, 4, 1, 2, 7, 5, 2};
		int k = 8;

		int[] b = sort(a, k);

		for (int i : b) {
			System.out.print(i + " -> ");
		}
	}
}