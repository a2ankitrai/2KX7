class MaxHeapify {

	public int parent(i) {
		return ((i - 1) / 2);
	}

	public int left(i) {
		return (2 * i + 1);
	}
	public int right(i) {
		return (2 * i + 2);
	}
}