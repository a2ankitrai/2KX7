class RatInMaze {

	static int n = 4;

	public static boolean isAllowed(int[][] maze, int x, int y) {
		return (x >= 0 && x < n && y >= 0 && y < n && maze[x][y] == 1);
	}

	public static boolean solution(int[][] maze) {

		int[][] solution = new int[maze.length][maze.length];

		int[] xMove = {1, 0, -1, 0};
		int[] yMove = {0, 1, 0, -1};

		maze[0][0] = 5;
		if (solutionUtil(maze, 0, 0, xMove, yMove)) {
			return true;
		};
		return false;
	}

	public static boolean solutionUtil(int[][] maze, int x, int y, int[] xMove, int[] yMove) {
		if (x == n - 1 && y == n - 1) {
			maze[x][y] = 5;
			return true;
		}

		for (int k = 0; k < 4; k++) {
			int newX = x + xMove[k];
			int newY = y + yMove[k];

			if (isAllowed(maze, newX, newY)) {
				maze[newX][newY] = 5;
				if (solutionUtil(maze, newX, newY, xMove, yMove)) {
					return true;
				}
				maze[newX][newY] = 1;
			}
		}
		return false;
	}

	public static void printPath(int[][] maze) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(maze[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int[][] maze = {{1, 0, 0, 0},
			{1, 1, 0, 1},
			{0, 1, 0, 0},
			{1, 1, 1, 1}
		};

		System.out.println(solution(maze));

		printPath(maze);

	}
}