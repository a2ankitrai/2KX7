class HeapSort {

	public static int heapsize = 0;

	public int parent(int i) {
		return ((i - 1) / 2);
	}

	public int left(int i) {
		return (2 * i + 1);
	}
	public int right(int i) {
		return (2 * i + 2);
	}

	public void maxHeapify(int[] a, int i) {
		int l = left(i);
		int r = right(i);
		int largest = i;
		if (l < heapsize && a[l] > a[i]) {
			largest = l;
		}
		if (r < heapsize && a[r] > a[largest]) {
			largest = r;
		}
		if (largest != i) {
			int temp = a[i];
			a[i] = a[largest];
			a[largest] = temp;
			maxHeapify(a, largest);
		}
	}

	public void buildMaxHeap(int[] a) {
		heapsize = a.length;
		for (int i = (a.length / 2) - 1; i >= 0; i--) {
			maxHeapify(a, i);
		}
	}

	public int heapExtractMax(int[] a) {
		if (heapsize <= 0) {
			System.out.println("heap underflow");
			return -1;
		}
		int max = -1;
		max = a[0];
		a[0] = a[heapsize - 1];
		maxHeapify(a, 0);
		return max;
	}

	public void sort(int[] a) {
		buildMaxHeap(a);
		for (int i = a.length - 1; i >= 1 ; i--) {
			int temp = a[0];
			a[0] = a[i];
			a[i] = temp;
			heapsize--;
			maxHeapify(a, 0);
		}
	}

	public static void main(String[] args) {
		int b[] = {54, 24, 76, 2, 5, 24, 1, 56, 99, 345, 312, 203};
		HeapSort hs = new HeapSort();
		hs.sort(b);
		for (int i : b) {
			System.out.print(i + " -> ");
		}
	}
}