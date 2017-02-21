class Sudoku {

	int n;

	Sudoku(int n) {
		this.n = n;
	}

	public void printGrid(int[][] grid) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	class Unassigned {
		int row;
		int col;

		Unassigned(int row, int col) {
			this.row = row;
			this.col = col;
		}
	}

	Unassigned findUnassignedLocation(int grid[][]) {

		for (int row = 0; row < n; row++)
			for (int col = 0; col < n; col++)
				if (grid[row][col] == 0)
					return new Unassigned(row,col);

		return null;
	}

	boolean usedInRow(int grid[][], int row, int num) {
		for (int col = 0; col < n; col++)
			if (grid[row][col] == num)
				return true;
		return false;
	}

	boolean usedInCol(int grid[][], int col, int num) {
		for (int row = 0; row < n; row++)
			if (grid[row][col] == num)
				return true;
		return false;
	}

	boolean usedInBox(int grid[][], int boxStartRow, int boxStartCol, int num) {
		for (int row = 0; row < 3; row++)
			for (int col = 0; col < 3; col++)
				if (grid[row + boxStartRow][col + boxStartCol] == num)
					return true;
		return false;
	}

	boolean isSafe(int grid[][], int row, int col, int num) {
		/* Check if 'num' is not already placed in current row,
		   current column and current 3x3 box */
		return !usedInRow(grid, row, num) &&
		       !usedInCol(grid, col, num) &&
		       !usedInBox(grid, row - row % 3 , col - col % 3, num);
	}


	boolean SolveSudoku(int grid[][]) {

		Unassigned loc =  findUnassignedLocation(grid);
		if (loc == null)
			return true; // success!

		 int row = loc.row; 
		 int col = loc.col;

		// consider digits 1 to 9
		for (int num = 1; num <= 9; num++) {
			// if looks promising
			if (isSafe(grid, row, col, num)) {
				// make tentative assignment
				grid[row][col] = num;

				// return, if success, yay!
				if (SolveSudoku(grid))
					return true;

				// failure, unmake & try again
				grid[row][col] = 0;
			}
		}
		return false; // this triggers backtracking
	}

	public static void main(String[] args) {

		Sudoku s = new Sudoku(9);

		int grid[][] = {{3, 0, 6, 5, 0, 8, 4, 0, 0},
			{5, 2, 0, 0, 0, 0, 0, 0, 0},
			{0, 8, 7, 0, 0, 0, 0, 3, 1},
			{0, 0, 3, 0, 1, 0, 0, 8, 0},
			{9, 0, 0, 8, 6, 3, 0, 0, 5},
			{0, 5, 0, 0, 9, 0, 6, 0, 0},
			{1, 3, 0, 0, 0, 0, 2, 5, 0},
			{0, 0, 0, 0, 0, 0, 0, 7, 4},
			{0, 0, 5, 2, 0, 6, 3, 0, 0}
		};
		if (s.SolveSudoku(grid) == true)
			s.printGrid(grid);
		else
			System.out.println("No solution exists");
	}



}