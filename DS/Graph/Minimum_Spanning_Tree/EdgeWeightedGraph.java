import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

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

	public EdgeWeightedGraph(Scanner sc) {

		this.V = sc.nextInt();
		System.out.println("V" + ": " + V);
		this.E = sc.nextInt();
		System.out.println("E" + ": " + E);

		adj = (List<Edge>[]) new ArrayList[V];
		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<Edge>();
		}

		int edgeCount = E;

		while (edgeCount > 0) {
			int u = sc.nextInt();
			int v = sc.nextInt();
			double weight = sc.nextDouble();
			
			addEdge(new Edge(u, v, weight));
			edgeCount--;
		}
	}

	public int V() { return V; }
	public int E() { return E; }

	public void addEdge(Edge e) {
		int v = e.either(), w = e.other(v);
		adj[v].add(e);
		adj[w].add(e);
		E++;
	}

	// Allow self loops and parallel edges.
	public Iterable<Edge> adj(int v)
	{ return adj[v]; }

	/**
	 * Returns all edges in this edge-weighted graph.
	 * To iterate over the edges in this edge-weighted graph, use foreach notation:
	 * {@code for (Edge e : G.edges())}.
	 *
	 * @return all edges in this edge-weighted graph, as an iterable
	 */
	public Iterable<Edge> edges() {
		List<Edge> list = new ArrayList<Edge>();
		for (int v = 0; v < V; v++) {
			int selfLoops = 0;
			for (Edge e : adj(v)) {
				if (e.other(v) > v) {
					list.add(e);
				}
				// only add one copy of each self loop (self loops will be consecutive)
				else if (e.other(v) == v) {
					if (selfLoops % 2 == 0) list.add(e);
					selfLoops++;
				}
			}
		}
		return list;
	}

}