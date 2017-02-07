class PrimMSTAdjacencyMatrix {

	int[][] graph ;
	int V;

	public PrimMSTAdjacencyMatrix(int[][] graph, int V) {
		this.graph = graph;
		this.V = V;

		// Array to store constructed MST
		int[] parent = new int[V];

		// Key values used to pick minimum weight edge in cut
		int key[] = new int [V];

		// To represent set of vertices not yet included in MST
		Boolean mstSet[] = new Boolean[V];

		// Initialize all keys as INFINITE
		for (int i = 0; i < V ; i++ ) {
			key[i] = Integer.MAX_VALUE;
			mstSet[i] = false;
		}

		// include first 1st vertex in MST.
		key[0] = 0;
		parent[0] = -1; // First node is always root of MST

		for (int count = 0; count < V; count++) {
			int u = minKey(key, mstSet);

			// Add the picked vertex to the MST Set
			mstSet[u] = true;

			// Update key value and parent index of the adjacent
			// vertices of the picked vertex. Consider only those
			// vertices which are not yet included in MST
			for (int v = 0; v < V; v++) {
				if (graph[u][v] != 0 && mstSet[v] == false && graph[u][v] < key[v]) {
					parent[v] = u;
					key[v] = graph[u][v];
				}
			}
		}

		printMST(parent, V, graph);

	}

	// A utility function to find the vertex with minimum key
	// value, from the set of vertices not yet included in MST
	int minKey(int key[], Boolean mstSet[]) {
		// Initialize min value
		int min = Integer.MAX_VALUE, min_index = -1;

		for (int v = 0; v < V; v++)
			if (mstSet[v] == false && key[v] < min) {
				min = key[v];
				min_index = v;
			}

		return min_index;
	}

	// A utility function to print the constructed MST stored in parent[]
	void printMST(int parent[], int n, int graph[][]) {
		System.out.println("Edge   Weight");
		for (int i = 1; i < V; i++)
			System.out.println(parent[i] + " - " + i + "    " +
			                   graph[i][parent[i]]);
	}

	public static void main(String[] args) {

		int graph[][] = new int[][] {{0, 2, 0, 6, 0},
			{2, 0, 3, 8, 5},
			{0, 3, 0, 0, 7},
			{6, 8, 0, 0, 9},
			{0, 5, 7, 9, 0},
		};

		PrimMSTAdjacencyMatrix mst = new PrimMSTAdjacencyMatrix(graph, 5);

	}

}