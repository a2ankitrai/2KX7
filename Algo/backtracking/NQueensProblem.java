public class NQueensProblem {

	public static int n = 4;


	public static boolean isRowSafe(int[][] board, int row) {

		for (int i = 0; i < n; i++) {
			if (board[row][i] == 1) {
				return false;
			}
		}
		return true;
	}

	public static boolean isColumnSafe(int[][] board, int col) {

		for (int i = 0; i < n; i++) {
			if (board[i][col] == 1) {
				return false;
			}
		}
		return true;
	}

	public static boolean isDiagonalSafe(int[][] board, int row, int col) {

		/* Check the left upper diagonal */
		for (int i = row, j = col; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}

		/*check left lower diagonal */
		for (int i = row, j = col; i < n && j >= 0; i++, j--) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}

	public static boolean isSafe(int[][] board, int row, int col) {
		boolean rowSafe = isRowSafe(board, row);
		boolean columnSafe = isColumnSafe(board, col);
		boolean diagonalSafe = isDiagonalSafe(board, row, col);

		return rowSafe && columnSafe && diagonalSafe;
	}

	private static void placeQueen(int[][] board, int row, int col) {
		board[row][col] = 1;
	}

	private static void removeQueen(int[][] board, int row, int col) {
		board[row][col] = 0;
	}

	public static boolean solveNQueen(int[][] board, int col) {

		if (col >= n) {
			return true;
		}

		for (int i = 0; i < n; i++) {
			if (isSafe(board, i, col)) {
				placeQueen(board, i, col);
				if (solveNQueen(board, col + 1)) { return true; }
				removeQueen(board, i, col);
			}
		}
		return false;
	}

	public static void printMatrix(int[][] n) {
		int l = n.length;

		for (int i = 0 ; i < l; i++) {
			for (int j = 0; j < l; j++) {
				System.out.print(n[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int[][] a = new int[n][n];
		System.out.println(solveNQueen(a, 0));
		printMatrix(a);
	}
}