class MergeSort {

	public int[] mergesorter(int a[], int p, int r) {

		if (p < r) {
			int q = (p + r) / 2;
			mergesorter(a, p, q);
			mergesorter(a, (q + 1), r);
			merge(a, p, q, r);
		}
		return a;
	}

	public void merge(int a[], int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q;
		int[] left = new int[n1 + 1];
		int[] right = new int[n2 + 1];

		for (int i = 0; i < n1; i++)
			left[i] = a[p + i ];

		for (int j = 0; j < n2; j++)
			right[j] = a[q + 1 + j];

		left[n1] = 9999;
		right[n2] = 9999;

		for (int k = p, x = 0, y = 0; k <= r; k++) {
			if (left[x] < right[y]) {
				a[k] = left[x];
				x++;
			} else {
				a[k] = right[y];
				y++;
			}
		}
	}



	public static void main(String[] args) {

		MergeSort ms =  new MergeSort();
		int b[] = {54, 24, 76, 2, 5, 24, 1, 56, 99, 345, 312, 203};
		//int b[] = {5, 2, 1, 3, 7, 4};
		int[] sortedArr = ms.mergesorter(b, 0, b.length - 1);

		for (int i : sortedArr) {
			System.out.print(i + " -> ");
		}
	}
}