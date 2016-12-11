class ShortestPath {

	int[] edgeTo;
	double[] distTo;


	public ShortestPath(EdgeWeightedDigraph g) {

	}

	private void relax(DirectedEdge e) {
		int v = e.from();
		int w = e.to();
		if (distTo[w] > distTo[v] + e.weight()) {
			distTo[w] = distTo[v] + e.weight();
			edgeTo[w] = v;
		}
	}

	private void relax(EdgeWeightedDigraph g, int v) {
		for (DirectedEdge e : g.adj(v)) {
			int w = e.to();
			if (distTo[w] > distTo[v] + e.weight()) {
				distTo[w] = distTo[v] + e.weight();
				edgeTo[w] = v;
			}
		}
	}
}