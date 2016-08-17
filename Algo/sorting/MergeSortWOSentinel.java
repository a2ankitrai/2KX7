class MergeSortWOSentinel {

	public int[] mergeSort(int a[], int p , int r) {
		if (p < r) {
			int q = (p + r) / 2;
			mergeSort(a, p, q);
			mergeSort(a, (q + 1), r);
			merge(a, p, q, r);
		}
		return a;
	}

	public void merge(int a[], int p, int q, int r) {
		int n1 = q - p + 1;
		int n2 = r - q ;

		int[] auxLeft = new int[n1];
		int[]  auxRight = new int [n2];

		for (int i = 0; i < n1; i++) {
			auxLeft[i] = a[p + i];
		}

		for (int j = 0; j < n2; j++) {
			auxRight[j] = a[q + 1 + j];
		}

		int i = 0, j = 0;
		int k = p;

		while (i < n1 && j < n2) {
			if (auxLeft[i] <= auxRight[j]) {
				a[k] = auxLeft[i];
				i++;
			} else {
				a[k] = auxRight[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			a[k] = auxLeft[i];
			i++;
			k++;
		}

		while (j < n2) {
			a[k] = auxRight[j];
			j++;
			k++;
		}


		/*for (int k = p, i = 0, j = 0; k <= r; k++) {
			if (i < n1 && (j >= n2 || auxLeft[i] < auxRight[j])) {
				a[k] = auxLeft[i];
				i = i + 1;
			} else {
				a[k] = auxRight[j];
				j = j + 1;
			}
		}*/

	}

	public static void main(String[] args) {
		MergeSortWOSentinel ms =  new MergeSortWOSentinel();

		int a[] = {5, 2, 29, 9, 15, 4, 3, 2};

		a = ms.mergeSort(a, 0, a.length - 1);
		for (int i=0; i<a.length;i++) {
			System.out.print(a[i] + " -> ");
		}
	}
}