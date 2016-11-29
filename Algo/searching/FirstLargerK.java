class FirstLargerK {

	public int searchFirstLargerK(int[] a, int k) {
		int low = 0, high = a.length - 1, result = -1;

		while (low <= high) {
			int mid = low + ((high - low) >> 2);
			if (a[mid] > k) {
				result = mid;
				high = mid - 1;
			} else { //a[mid]<=k
				low = mid + 1;
			}
		}
		return result;
	}


	public static void main(String[] args) {
		FirstLargerK fk = new FirstLargerK();
		int[] a = { -14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
		int[] b = {2, 5, 6, 11, 15};/*
		System.out.println(fk.searchFirstLargerK(a, 500));
		System.out.println(fk.searchFirstLargerK(a, 101));
*/
		System.out.println(fk.searchFirstLargerK(b, 7));
		System.out.println(fk.searchFirstLargerK(b, 20));
		System.out.println(fk.searchFirstLargerK(b, 11));
	}
}