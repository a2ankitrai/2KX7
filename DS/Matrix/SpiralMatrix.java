class SpiralMatrix {

	public static void printSpiral(int[][] matrix, int m, int n ) {

		int topRow = 0;
		int btmRow = m - 1;
		int leftCol = 0;
		int rightCol = n - 1;

		while (topRow <= btmRow && leftCol <= rightCol) {

			for (int i = leftCol; i <= rightCol; i++) {
				System.out.print(matrix[topRow][i]+" ");
			}
			topRow++;

			for(int i=topRow;i<=btmRow;i++){
				System.out.print(matrix[i][rightCol]+" ");
			}
			rightCol--;

			for(int i=rightCol;i>=leftCol;i--){
				System.out.print(matrix[btmRow][i]+" ");
			}
			btmRow--;

			for (int i=btmRow;i>=topRow ;i-- ) {
				System.out.print(matrix[i][leftCol]+" ");	
			}
			leftCol++;
		}

	}

	public static void main(String[] args) {

		int[][] m = new int[4][5];
		int ctr = 0;

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = ++ctr;
			}
		}

		System.out.println("Printing the matrix");

		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}

		printSpiral(m,4,5);
	}
}