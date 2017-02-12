class RobotInAGrid {

	int[][] grid;
	int n;

	public RobotInAGrid(int[][] grid, int n) {
		this.grid = grid;
		this.n = n;
	}

	private boolean isStepSafe(int x, int y) {
		return (x >= 0 && x < n && y >= 0 && y < n && grid[x][y] == 1);
	}

	public boolean isPath() {

		int[] xMove = {0, 1};
		int[] yMove = {1, 0};

		grid[0][0] = 9;

		if (isPath(0, 0, xMove, yMove)) {
			return true;
		}
		return false;
	}

	public boolean isPath(int x, int y, int[] xMove, int[] yMove) {

		if (x == n - 1 && y == n - 1) {
			grid[n - 1][n - 1] = 9;
			return true;
		}

		for (int i = 0 ; i < xMove.length; i++) {

			int newX = x + xMove[i];
			int newY = y + yMove[i];

			if (isStepSafe(newX, newY)) {
				grid[newX][newY] = 9;
				if (isPath(newX, newY, xMove, yMove)) {return true;}
				grid[newX][newY] = 1;
			}
		}
		return false;
	}

	public void printPath() {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int[][] grid = {{1, 0, 0, 0},
						{1, 1, 0, 1},
						{0, 1, 0, 0},
						{1, 1, 1, 1}
		};
		RobotInAGrid rg = new RobotInAGrid(grid, 4);
		if (rg.isPath()) {
			rg.printPath();
		} else {
			System.out.println("No path possible");
		}

	}
}