class MinHeap {

	private int[] a;
	private int heapSize;


	public MinHeap() {
		a = new int[10];
	}

	public MinHeap(int size) {
		a = new int[size];
		/*heapSize = size;*/
	}

	public int getParent(int i) {
		if (i == 0) {
			return -1;
		}

		return (i - 1) / 2;
	}

	public int getLeft(int i) {
		return (2 * i + 1);
	}

	public int getRight(int i) {
		return (2 * i + 2);
	}

	public int getHeapMinimum() {
		return a[0];
	}

	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public void minHeapify(int[] a, int i) {
		int l = getLeft(i);
		int r = getRight(i);
		int smallest = a[i];

		if (l < smallest) {
			smallest = l;
		}
		if (r < smallest) {
			smallest = r;
		}

		if (a[i] != smallest) {
			swap(a, i, smallest);
			minHeapify(a, i);
		}
	}

	public int extractHeapMinimum() {
		if (heapSize < 1) {
			System.out.println("Heap underflow");
			return -1;
		}
		int min = a[0];
		swap(a, min, heapSize - 1);
		heapSize--;
		minHeapify(a, 0);
		return min;
	}

	public void decreaseKey(int i, int key) {
		if (key > a[i]) {
			System.out.println("New key cannot be larger than current key");
			return;
		}
		a[i] = key;
		while (i > 0 && a[i] > a[getParent(i)]) {
			swap(a, i, getParent(i));
			i = getParent(i);
		}
	}

}