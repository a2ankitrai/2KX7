public class DijkstraShortestPathAdjMat {

	int graph[][];
	int V;
	int src;

	public DijkstraShortestPathAdjMat(int graph[][], int src, int V) {
		this.graph = graph;
		this.src = src;
		this.V = V;

		// The output array. dist[i] will hold  the shortest distance from src to i
		int[] dist = new int[V];

		/* spSet[i] will true if vertex i is included in shortest
		 path tree or shortest distance from src to i is finalized */
		Boolean spSet[] = new Boolean[V];

		// Initialize all distances as INFINITE and stpSet[] as false
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
			spSet[i] = false;
		}

		// Distance of source vertex from itself is always 0
		dist[src] = 0;

		// Find shortest path for all vertices
		for (int count = 0; count < V - 1; count++) {

			// Pick the minimum distance vertex from the set of vertices
			// not yet processed. u is always equal to src in first
			// iteration.
			int u = minDistance(dist, spSet);

			// Mark the picked vertex as processed
			spSet[u] = true;

			// Update dist value of the adjacent vertices of the
			// picked vertex.
			for (int v = 0; v < V; v++) {

				// Update dist[v] only if is not in sptSet, there is an
				// edge from u to v, and total weight of path from src to
				// v through u is smaller than current value of dist[v]
				if (spSet[v] != true && graph[u][v] != 0 &&
				        dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) {
					dist[v] = dist[u] + graph[u][v];
				}
			}
		}
		printShortestPaths(dist);
	}

	int minDistance(int dist[], Boolean[] spSet) {
		int min = Integer.MAX_VALUE;
		int minIndex = -1;

		for (int v = 0; v < V; v++) {
			if (spSet[v] == false && dist[v] <= min) {
				min = dist[v];
				minIndex = v;
			}
		}

		return minIndex;
	}

	public void printShortestPaths(int[] dist) {
		System.out.println("Vertex   Distance from Source");
		for (int i = 0; i < V; i++)
			System.out.println(i + " \t\t " + dist[i]);
	}

	public static void main(String[] args) {

		int graph[][] = new int[][] {{0, 4, 0, 0, 0, 0, 0, 8, 0},
			{4, 0, 8, 0, 0, 0, 0, 11, 0},
			{0, 8, 0, 7, 0, 4, 0, 0, 2},
			{0, 0, 7, 0, 9, 14, 0, 0, 0},
			{0, 0, 0, 9, 0, 10, 0, 0, 0},
			{0, 0, 4, 14, 10, 0, 2, 0, 0},
			{0, 0, 0, 0, 0, 2, 0, 1, 6},
			{8, 11, 0, 0, 0, 0, 1, 0, 7},
			{0, 0, 2, 0, 0, 0, 6, 7, 0}
		};

		DijkstraShortestPathAdjMat dsp = new DijkstraShortestPathAdjMat(graph,2,9);

	}

}