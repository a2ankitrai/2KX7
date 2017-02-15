class QuickSort {

	public void sort(int[] a, int p, int r) {
		if (p < r) {
			int q = partition(a, p, r);
			sort(a, p, q - 1);
			sort(a, q + 1, r);
		}
	}

	public int partition(int[] a, int p, int r) {
		int x = a[r];
		int i = p - 1;
		for (int j = p; j < r; j++) {
			if (a[j] <= x) {
				i++;
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
			}
		}
		int temp2 = a[i + 1];
		a[i + 1] = a[r];
		a[r] = temp2;
		return i + 1;
	}

	// version 2

	private static int partition2(int[] a, int lo, int hi) {

		int i = lo, j = hi + 1;

		while (true) {
			while (a[++i] < a[lo]) { // find item on left to swap
				if (i == hi) {
					break;
				}
			}

			while (a[lo] < a [--j]) { // find item on right to swap
				if (j == lo) {
					break;
				}
			}

			if (i >= j) { 	// check if pointers cross
				break;
			}
			swap(a, i, j);	// exchange
		}
		swap(a, lo, j);
		return j;
	}

	private static void sort2(int[] a, int low, int high) {
		if (high <= low) return;
		int j  = partition2(a, low, high);
		sort2(a, low, j - 1);
		sort2(a, j + 1, high);
	}

	private static void sort2(int[] a){
		if(a==null || a.length == 0) return ;

		int low = 0;
		int high = a.length -1;
		sort2(a,low,high);
	}

	public static void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int b[] = {5, 2, 29, 9, 15, 4, 3, 2};
		//qs.sort(b, 0, b.length - 1);
		
		qs.sort2(b);
		for (int i : b) {
			System.out.print(i + " -> ");
		}
	}
}