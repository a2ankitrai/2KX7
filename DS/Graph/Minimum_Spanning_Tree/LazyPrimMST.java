import java.util.Queue;
import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class LazyPrimMST {

	private boolean[] marked;		// MST vertices
	private Queue<Edge> mst;		// MST edges
	private PriorityQueue<Edge> pq;	// PQ of edges


	public LazyPrimMST(EdgeWeightedGraph G) {
		pq = new PriorityQueue<>();
		mst = new LinkedList<>();
		marked = new boolean[G.V()];
		visit(G, 0);

		while (!pq.isEmpty()) {
			Edge e = pq.poll();
			int v = e.either();
			int w = e.other(v);

			if (marked[v] && marked[w]) {
				continue;
			}

			mst.offer(e);

			if (!marked[v]) {
				visit(G, v);
			}

			if (!marked[w]) {
				visit(G, w);
			}

		}
	}

	public void visit(EdgeWeightedGraph G, int v) {
		marked[v] = true;
		for (Edge e : G.adj(v)) {
			if (!marked[e.other(v)])
				pq.offer(e);
		}
	}

	public Iterable<Edge> edges() {
		return mst;
	}

	/*public double weight() {
		return weight;
	}*/

	public static void main(String[] args) throws IOException {

		String fileName = null;
		if (args.length > 0) {
			fileName = args[0];
		} else {
			System.out.println("Please pass file name in command line arguements");
			return;
		}
		Scanner sc = new Scanner(new File(fileName));

		EdgeWeightedGraph g = new EdgeWeightedGraph(sc);
		LazyPrimMST mst = new LazyPrimMST(g);
		for (Edge e : mst.edges()) {
			System.out.println(e);
		}
		//	System.out.println(String.format("%.2f\n", mst.weight()));
	}

}