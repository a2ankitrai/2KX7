import java.util.Scanner;
import java.io.File;
import java.io.IOException;

class MST {

	public MST(EdgeWeightedGraph g) {

	}

	Iterable<Edge> edges() {
		return null;
	}

	double weight() {
		return 0.0;
	}

	public static void main(String[] args) throws IOException {

		String fileName = null;
		if (args.length > 0) {
			fileName = args[0];
		}
		Scanner sc = new Scanner(new File(fileName));

		EdgeWeightedGraph g = new EdgeWeightedGraph(sc);
		MST mst = new MST(g);
		for (Edge e : mst.edges()) {
			System.out.println(e);
		}
		System.out.println(String.format("%.2f\n", mst.weight()));

	}

}