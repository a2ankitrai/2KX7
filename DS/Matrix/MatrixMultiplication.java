class MatrixMultiplication {

	public static void main(String[] args) {

		int[][] m1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		int[][] m2 = {{11, 12, 13}, {14, 15, 16}, {17, 18, 19}};

		int row = m1.length;
		int column = m1[0].length;

		int column2 = m2[0].length;

		int[][] m3 = new int[row][column2];
		for (int i = 0; i < m3.length; i++) {
			for (int j = 0; j < m3[0].length ; j++ ) {
				m3[i][j] = 0;
			}
		}

		System.out.println("row " + row + " " + column + " " + column2);

		int sum = 0;
		for (int i = 0; i < row; i++) {
			for (int j = 0; i < column2; j++) {
				for (int k = 0; k < column; k++) {
					sum = sum + m1[i][k] * m2[k][j];
				}
				m3[i][j] = sum;
				sum = 0;
			}
		}

		for (int i = 0; i < m3.length; i++) {
			for (int j = 0; j < m3[0].length ; j++ ) {
				System.out.println(m3[i][j] + "\t");
			}
			System.out.println("\n");
		}

	}
}