import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

class EdgeWeightedDigraph {

	private static final String NEWLINE = System.getProperty("line.separator");

	private final int V;
	private int E;
	private List<DirectedEdge>[] adj;

	public EdgeWeightedDigraph(int V) {

		if (V < 0)
			throw new IllegalArgumentException("Number of vertices in a Digraph must be nonnegative");

		this.V = V;
		this.E = 0;
		adj = (List<DirectedEdge>[]) new List[V];

		for (int v = 0; v < V; v++) {
			adj[v] = new ArrayList<DirectedEdge>();
		}
	}

	public EdgeWeightedDigraph(List<String> ip) {
		this(Integer.parseInt(ip.get(0)));
		Iterator<String> it = ip.iterator();
		int V = Integer.parseInt(it.next());
		int E = Integer.parseInt(it.next());

		if (E < 0) throw new IllegalArgumentException("Number of edges must be nonnegative");

		for (int i = 0; i < E; i++) {
			int v = Integer.parseInt(it.next());
			int w = Integer.parseInt(it.next());

			validateVertex(v);
			validateVertex(w);
			double weight = Double.parseDouble(it.next());
			addEdge(new DirectedEdge(v, w, weight));
		}
	}

	private int V() {
		return V;
	}

	private int E() {
		return E;
	}

	private void validateVertex(int v) {
		if (v < 0 || v >= V)
			throw new IllegalArgumentException("vertex " + v + " is not between 0 and " + (V - 1));
	}

	public void addEdge(DirectedEdge e) {
		validateVertex(e.from());
		validateVertex(e.to());
		adj[e.from()].add(e);
		E++;
	}

	public Iterable<DirectedEdge> adj(int v) {
		validateVertex(v);
		return adj[v];
	}

	public Iterable<DirectedEdge> edges() {
		List<DirectedEdge> edges = new ArrayList<DirectedEdge>();

		for (int v = 0 ; v < V; v++) {
			for (DirectedEdge edge  : adj(v)) {
				edges.add(edge);
			}
		}
		return edges;
	}

	public String toString() {
		StringBuilder s = new StringBuilder();
		s.append(V + " " + E + NEWLINE);
		for (int v = 0; v < V; v++) {
			s.append(v + ": ");
			for (DirectedEdge e : adj[v]) {
				s.append(e + "  ");
			}
			s.append(NEWLINE);
		}
		return s.toString();
	}

	public static void main (String[] args) throws IOException {

		Scanner sc = new Scanner(new File("tinyEWD.txt"));

		List<String> ip = new ArrayList<String>();
		while (sc.hasNext()) {
			String s = sc.next();
			ip.add(s);
		}
		sc.close();

		EdgeWeightedDigraph g = new EdgeWeightedDigraph(ip);
		System.out.println(g);
	}

}