class InsertionSort {

	public void insertSort(int[] a) {
		int key;

		for (int i = 1; i < a.length; i++) {
			key = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] < key) {
				a[j + 1] = a[j];
				j = j - 1;
			}
			a[j + 1] = key;
		}

		for (int i : a) {
			System.out.print(i + " -> ");
		}
	}

	public static void main(String[] args) {
		int a[] = {5, 2, 4, 6, 1, 3};
		int b[] = {54, 24, 76, 2, 5, 24, 1, 56, 99, 345, 312, 203};

		InsertionSort iS = new InsertionSort();

		iS.insertSort(b);
	}

}