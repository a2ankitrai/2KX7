class MinHeap {

	private int[] heap;
	private int heapSize;
	private int capacity;


	public MinHeap(int capacity) {
		this.heap = new int[capacity + 1];
		this.heapSize = 0;
		this.capacity = capacity;
	}

	private int getParent(int i) {
		return (i / 2);
	}

	private int getLeftChild(int i) {
		return (2 * i);
	}

	private int getRightChild(int i) {
		return (2 * i + 1);
	}

	private void swap(int i, int j) {
		int temp = heap[i];
		heap[i] = heap[j];
		heap[j] = temp;
	}

	private boolean isLeaf(int pos) {
		return pos > (heapSize / 2);
	}

	private void heapify(int pos) {
		if (isLeaf(pos))
			return;

		int left = getLeftChild(pos);
		int right = getRightChild(pos);

		int min = pos;

		/**
		* Check whether left and right child indexes are still within the heapsize
		*/

		if (left <= heapSize && heap[left] < heap[min]) {
			min = left;
		}
		if (right <= heapSize && heap[right] < heap[min]) {
			min = right;
		}

		if (min != pos) {
			swap(pos, min);
			heapify(min);
		}
	}

	public void insert(int data) {
		if (heapSize == capacity) {
			System.out.println("Heap overflow");
			return ;
		}

		heap[++heapSize] = data;
		int current  = heapSize;

		int parent = getParent(current);

		while (parent >= 1 && heap[parent] > heap[current]) {
			swap(parent, current);
			current = getParent(current);
			parent = getParent(current);
		}

		/*while (current >= 1 && heap[current/2] > heap[current]) {
			swap(current/2, current);
			current = current/2;
		}*/
	}

	public int extractMin() {
		if (heapSize == 0) {return -1;}

		int poppedItem = heap[1];
		swap(1, heapSize--);
		heapify(1);
		heap[heapSize + 1] = 0;
		return poppedItem;
	}

	public static void main(String[] args) {
		MinHeap mh = new MinHeap(10);
		int a[] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
		for (int i : a) {
			mh.insert(i);
		}
		while (mh.heapSize != 0)
			System.out.println(mh.extractMin());

	}

}