import java.util.Queue;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class KruskalMST {

	private double weight;
	private Queue<Edge> mst = new LinkedList<>();

	public KruskalMST(EdgeWeightedGraph G) {

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		for (Edge e : G.edges()) {
			pq.add(e);
		}

		// run greedy algorithm
		UF uf = new UF(G.V());
		while (!pq.isEmpty() && mst.size() < G.V() - 1) {
			Edge e = pq.poll();
			int v = e.either();
			int w = e.other(v);
			if (!uf.connected(v, w)) { // v-w does not create a cycle
				uf.union(v, w);  // merge v and w components
				mst.offer(e);  // add edge e to mst
				weight += e.weight();
			}
		}

	}

	public Iterable<Edge> edges() {
		return mst;
	}

	public double weight() {
		return weight;
	}

	public static void main(String[] args) throws IOException{

		String fileName = null;
		if (args.length > 0) {
			fileName = args[0];
		}
		Scanner sc = new Scanner(new File(fileName));

		EdgeWeightedGraph g = new EdgeWeightedGraph(sc);
		KruskalMST mst = new KruskalMST(g);
		for (Edge e : mst.edges()) {
			System.out.println(e);
		}		
		System.out.println(String.format("%.2f\n", mst.weight()));
	}

}