class K_Smallest {

	public static int select(int[] a , int k) {
		int lo = 0, hi = a.length - 1;
		while (lo < hi) {
			int j = partition(a, lo, hi);
			if (j < k ) { lo = j + 1; }
			else if ( j > k) { hi = j - 1;}
			else {
				return a[k];
			}

		}
		return a[k];
	}


	private static int partition(int[] a, int lo, int hi) {

		int i = lo , j = hi + 1;

		while (true) {

			while (a[++i] < a[lo]) {
				if (i == hi) break;
			}

			while (a[lo] < a[--j]) {
				if (j == lo) break;
			}

			if (i >= j) break;
			swap(a, i, j);
		}
		swap(a, lo, j);
		return  j;
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {

		int[] a = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8};
		System.out.println("4 smallest : " + select(a, 4));


	}
}