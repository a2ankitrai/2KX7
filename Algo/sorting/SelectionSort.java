class SelectionSort {

	public void selectSort(int a[]) {

		for (int i = 0; i < (a.length - 1); i++) {
			int min = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[min] > a[j])
					min = j;
			}
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}

		for (int i : a) {
			System.out.print(i + " -> ");
		}
	}

	public static void main(String[] args) {

		SelectionSort ss = new SelectionSort();
		int b[] = {54, 24, 76, 2, 5, 24, 1, 56, 99, 345, 312, 203};
		ss.selectSort(b);

	}
}