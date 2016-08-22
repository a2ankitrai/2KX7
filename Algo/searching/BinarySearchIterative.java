class BinarySearchIterative {

	public int binarySearch(int a[], int key) {

		int low = 0, mid, high = a.length - 1;

		while (low <= high) {
			mid = (low + high) / 2;
			if (a[mid] == key) {
				return mid;
			} else if (a[mid] < key) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		BinarySearchIterative bsi = new BinarySearchIterative();

		int a[] = {3, 4, 7, 12, 13, 22, 42, 45, 46, 59, 86, 94, 99, 109, 144, 169};

		int result = bsi.binarySearch(a, 169);

		if (result != -1) {
			System.out.println("Search item found at index " + result);
		} else {
			System.out.println("Search item not found in the array");
		}
	}
}