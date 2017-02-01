class KnightTourProblem {

	public static int n = 8;

	private static boolean isSafe(int row , int col, int[][] board) {
		return (row >= 0 && row < n && col >= 0 && col < n && board[row][col] == -1);
	}

	public static void printTour(int[][] board) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void initializeBoardMatrix(int[][] board) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				board[i][j]  = -1;
			}
		}
	}

	public static boolean solveKT() {
		int[][] board = new int[n][n];

		initializeBoardMatrix(board);


		/* xMove[] and yMove[] define next move of Knight.
		   xMove[] is for next value of x coordinate
		   yMove[] is for next value of y coordinate */
		int[] xMove = {2, 1, -1, -2, -2, -1, 1, 2};
		int[] yMove = {1, 2, 2, 1, -1, -2, -2, -1};

		board[0][0] = 0;

		if (!solveKTUtil(0, 0, 1, board, xMove, yMove)) {
			System.out.println("Solution does not exists");
			return false;
		}
		else{
			printTour(board);
			return true;
		}
	}

	public static boolean solveKTUtil(int x, int y, int moveNum, int[][] board, int[] xMove, int[] yMove) {

		if (moveNum == n * n) {
			return true;
		}

		for (int k = 0; k < 8; k++) {
			int nextX = x + xMove[k];
			int nextY = y + yMove[k];

			if (isSafe(nextX, nextY, board)) {
				board[nextX][nextY] = moveNum;
				if (solveKTUtil(nextX, nextY, moveNum + 1, board, xMove, yMove))
					return true;
				board[nextX][nextY] = -1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		solveKT();
	}
}





















