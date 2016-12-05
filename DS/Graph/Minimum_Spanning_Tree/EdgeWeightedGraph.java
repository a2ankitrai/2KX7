import java.util.List;
import java.util.ArrayList;

public class EdgeWeightedGraph {
	private final int V; // number of vertices
	private int E; // number of edges
	private List<Edge>[] adj; // adjacency lists
	public EdgeWeightedGraph(int V) {
		this.V = V;
		this.E = 0;
		adj = (List<Edge>[]) new ArrayList[V];
		for (int v = 0; v < V; v++)
			adj[v] = new ArrayList<Edge>();
	}
	public int V() { return V; }
	public int E() { return E; }
	public void addEdge(Edge e) {
		int v = e.either(), w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}
	public Iterable<Edge> adj(int v)
	{ return adj[v]; }

}