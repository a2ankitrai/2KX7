class CountSort {

	// Does not work. There is some error. Run it. Fix it.

	public static void sort(int[] a, int k) {

		int n = a.length;

		int[] c = new int[k + 1];
		int[] b = new int[a.length];

		// Count frequency of each digit using key as index.
		for (int i = 0; i < n; i++) {
			c[a[i] + 1]++;
		}

		// Compute frequency cumulates which specify destinations. Running sum
		for (int i = 0; i < k; i++) {
			c[i + 1] += c[i];
		}

		// Access cumulates using key as index to move items.
		for (int i = 0; i < n; i++) {
			b[c[a[i]]++] = a[i];
		}

		// Copy back to the original array
		for(int i=0; i<n; i++){
			a[i] = b[i];
		}
	}

	public static void main(String[] args) {
		int[] a = {1, 4, 1, 2, 7, 5, 2};
		int k = 8;

		sort(a, k);

		for (int i : a) {
			System.out.print(i + " -> ");
		}
	}
}