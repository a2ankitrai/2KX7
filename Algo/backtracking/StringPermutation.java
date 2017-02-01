class StringPermutation {

	public static void swap(char[] a, int i, int j) {
		char temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public static void permute(char[] str, int l, int r) {
		if (l == r) {
			System.out.println(String.valueOf(str));
		} else {
			for (int i = l ; i <= r; i++) {
				swap(str, l, i);
				permute(str, l + 1, r);
				swap(str, l, i);
			}
		}
	}

	public static void main(String[] args) {
		char[] a = {'A', 'B', 'C'};
		permute(a, 0, a.length - 1 );	
	}
}