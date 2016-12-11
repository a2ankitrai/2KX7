import java.util.NoSuchElementException;

class MaxPQ<Key extends Comparable<Key>> {

	private Key[] pq;
	private int n;

	public MaxPQ(int capacity) {
		// we need 1 more than the capacity because we will not be using index 0
		pq = (Key[]) new Comparable[capacity + 1];

	}

	private void swim(int k) {
		while (k > 1 && less(k / 2, k)) {
			exch(k, k / 2);
			k = k / 2;
		}
	}

	private void sink(int k) {
		while (2 * k <= n) {
			int j = 2 * k;
			if (j < n && less(j, j + 1)) j++;
			if (!less(k, j)) break;
			exch(k, j);
			k = j;
		}
	}

	// helper function to double the size of the heap array
	private void resize(int capacity) {
		assert capacity > n;
		Key[] temp = (Key[]) new Object[capacity];
		for (int i = 1; i <= n; i++) {
			temp[i] = pq[i];
		}
		pq = temp;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

	public Key max() {
		if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
		return pq[1];
	}

	public void insert(Key x) {
		if (n >= pq.length - 1) resize(2 * pq.length);

		pq[++n] = x;
		swim(n);
	}

	public Key delMax() {
		if (isEmpty()) throw new NoSuchElementException("Priority queue underflow");
		Key max = pq[1];
		exch(1, n--);
		sink(1);
		pq[n + 1] = null;
		if ((n > 0) && (n == (pq.length - 1) / 4)) resize(pq.length / 2);
		return max;
	}

	// Helper functions
	private boolean less(int i, int j) {
		return pq[i].compareTo(pq[j]) < 0;
	}

	private void exch(int i, int j) {
		Key temp = pq[i];
		pq[i] = pq[j];
		pq[j] = temp;
	}

}