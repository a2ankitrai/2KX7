class SquareMatrixMultplication {

	public static int[][] matrixMultiplication(int[][] a, int[][] b) {
		int[][] c = new int[a.length][b[0].length];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b[0].length; j++) {
				for (int k = 0; k < a[0].length ; k++ ) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}
		return c;
	}

	public static void main(String[] args) {
		int[][] a = new int[2][];
		a[0] = new int[] {1, 2, 3};
		a[1] = new int[] {4, 5, 6};

		int[][] b = new int[3][];
		b[0] = new int[] {7, 8};
		b[1] = new int[] {9, 10};
		b[2] = new int[] {11, 12};

		int[][] c = null;


		c = matrixMultiplication(a, b);

		for (int i = 0; i < c.length; i++) {
			for (int j = 0; j < c[i].length; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}

	}
}