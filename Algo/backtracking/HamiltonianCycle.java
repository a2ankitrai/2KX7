class HamiltonianCycle {

	final int v = 5;
	int path[] ;

	public static boolean isPathExists(int[][] graph, int v1, int v2) {
		return (graph[v1][v2] == 1);
	}

	public boolean getCycle(int[][] graph, int[] cycle) {

		for (int i = 0; i < cycle.length; i++) {
			cycle[i] = -1;
		}
		cycle[0] = 0;

		if (getCycleUtil(graph, cycle, 0)) {
			return true;
		}

		return false;
	}

	public boolean getCycleUtil(int[][] graph, int[] path, int current) {

		if (current == v) {

			if (graph[path[current - 1]][path[0]] == 1) {
				return true;
			}
			return false;
		}


		for (int i = 1; i < v; i++) {
			if (isPathExists(graph, current, i)) {
				cycle[count] = i;
				if (getCycleUtil(graph, cycle, i, count + 1)) {
					return true;
				}
				cycle[count] = -1;
			}
		}
		return false;
	}

	public static void main(String[] args) {

		HamiltonianCycle hc = new HamiltonianCycle();

		int[][] adjMatGraph = {{0, 1, 0, 1, 0},
			{1, 0, 1, 1, 1},
			{0, 1, 0, 0, 1},
			{1, 1, 0, 0, 1},
			{0, 1, 1, 1, 0},
		};

		int[] output = new int[5];
		System.out.println(hc.getCycle(adjMatGraph, output));

		for (int i : output) {
			System.out.print(i + " ");
		}

	}
}