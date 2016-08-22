class BinarySearchRecursive {

	public int binarySearch(int a[], int key, int low, int high) {
		if (low <= high) {
			int mid =  (low + high) / 2;
			if (a[mid] == key) {
				return mid;
			} else {
				if (a[mid] < key) {
					low = mid + 1;
				} else {
					high = mid - 1;
				}
				return binarySearch(a, key, low, high);
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		BinarySearchRecursive bsr = new BinarySearchRecursive();
		int a[] = {3, 4, 7, 12, 13, 22, 42, 45, 46, 59, 86, 94, 99, 109, 144, 169};

		int result = bsr.binarySearch(a, 169, 0 , a.length - 1);
		if (result != -1) {
			System.out.println("Search item found at index " + result);
		} else {
			System.out.println("Search item not found in the array");
		}
	}
}