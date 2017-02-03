class GraphColoring {

	int V;

	GraphColoring(int V) {
		this.V = V;
	}

	public boolean graphColoring(int[][] g, int m) {

		int[] c = new int[g.length];

		for (int i = 0; i < g.length; i++) {
			c[i] = 0;
		}

		if (!graphColoringUtil(g, c, m , 0 )) {
			System.out.println("Solution does not exist");
			return false;
		}

		printSolution(c);
		return true;

	}


	public boolean isSafe(int v, int[][] g, int[] color, int c) {
		for (int i = 0 ; i < V; i++) {
			if (g[v][i] == 1 && color[i] == c) {
				return false;
			}
		}
		return true;
	}

	public boolean graphColoringUtil(int[][] g, int[] c, int m, int v) {

		if (v == V) {
			return true;
		}

		for (int i = 1; i <= m; i++) {

			if (isSafe(v, g, c, i)) {
				c[v] = i;
				if (graphColoringUtil(g, c, m, v + 1)) {
					return true;
				}
				c[v] = 0;
			}

		}

		return false;
	}

	public void printSolution(int[] v) {
		for (int i : v) {
			System.out.println(i);
		}
	}

	public static void main(String[] args) {

		GraphColoring c = new GraphColoring(4);

		/* Create following graph and test whether it is
		   3 colorable
		  (3)---(2)
		   |   / |
		   |  /  |
		   | /   |
		  (0)---(1)
		*/
		int graph[][] = {{0, 1, 1, 1},
			{1, 0, 1, 0},
			{1, 1, 0, 1},
			{1, 0, 1, 0},
		};
		int m = 3; // Number of colors
		c.graphColoring(graph, m);
	}

}