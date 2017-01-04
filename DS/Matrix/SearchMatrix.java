class SearchMatrix {

	public static int search(int[][] mat, int x) {
		int m = mat.length;
		int n = mat[0].length;
		int i = 0, j = n - 1;

		while (i < m && j >= 0) {
			if (mat[i][j] == x) {
				System.out.println("Key " + x + " found at i = " + i + ",j = " + j);
				return 1;
			}
			if (mat[i][j] > x) {
				j--;
			} else {
				i++;
			}

		}

		System.out.println("Element not found");
		return 0;
	}

	public static void main(String[] args) {
		int[][] mat = { {10, 20, 30, 40},
						{15, 25, 35, 45},
						{27, 29, 37, 48},
						{32, 33, 39, 50},
		};
		search(mat,52);
	}
}