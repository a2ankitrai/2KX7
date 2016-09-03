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

	public static void main(String[] args) {
		QuickSort qs = new QuickSort();
		int b[] = {5, 2, 29, 9, 15, 4, 3, 2};
		qs.sort(b, 0, b.length - 1);
		for (int i : b) {
			System.out.print(i + " -> ");
		}
	}
}