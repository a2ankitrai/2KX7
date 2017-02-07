class AdjMatrixGraph {

	private int[][] adjMatrix;
	private int v;

	public AdjMatrixGraph(int v) {
		this.v = v;
		adjMatrix = new int[v][v];
	}

	public void makeEdge(int to, int from, int edge) {
		try {
			adjMatrix[to][from] = edge;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("The vertices does not exists");
		}
	}

	public int getEdge(int to, int from) {
		try {
			return adjMatrix[to][from];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("The vertices does not exists");
		}
		return -1;
	}

	
	
}