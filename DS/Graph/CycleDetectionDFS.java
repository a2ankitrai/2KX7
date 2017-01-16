import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Stack;

class CycleDetectionDFS {

	public static boolean detectCycle(AdjListGraph g, int source) {
		boolean[] visited = new boolean[g.getVertices()];

		Set<Integer> visitedSet = new HashSet<>();
		Stack<Integer> s = new Stack<>();
		visitedSet.add(source);
		s.push(source);
		int parent = -1;

		while (!s.isEmpty()) {
			int current = s.pop();
			visitedSet.add(current);
			Iterator<Integer> it = g.getAdjList()[current].descendingIterator();

			while (it.hasNext()) {
				int n = it.next();
				if (!visitedSet.contains(n)) {					
					s.push(n);
					//from = current;
				} else if (n != parent) {
					return true;
				}
			}
		}

		return false;
	}

	public static boolean detectCycleRecursiveMain(AdjListGraph g) {
//		Set<Integer> visitedSet = new HashSet<>();
		int V = g.getVertices();
		boolean[] visited = new boolean[V];

		for (int i = 0; i < V; i++) {
			visited[i] = false;
		}

		for (int i = 0 ; i < V; i++) {
			if (!visited[i]) {
				if (detectCycleRecursive(g, i, visited, -1)) {
					return true;
				}
			}
		}
		return false;
	}

	private static boolean detectCycleRecursive(AdjListGraph g, int source,
	        boolean[] visited, int parent) {

		visited[source] = true;
		Integer n;

		Iterator<Integer> it = g.getAdjList()[source].iterator();

		while (it.hasNext()) {
			n = it.next();
			if (!visited[n]) {
				if (detectCycleRecursive(g, n, visited, source)) {
					return true;
				}
			} else if (n != source) {
				return true;
			}
		}
		return false;
	}


	public static void main(String[] args) {

		AdjListGraph g = new AdjListGraph(6);

		g.addEdge(0, 1);
		g.addEdge(0, 5);
		g.addEdge(1, 2);
//		g.addEdge(1, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);

		System.out.println("Cycle exists: " + detectCycleRecursiveMain(g));
		System.out.println("Cycle exists Iterative: " + detectCycle(g, 0));

		AdjListGraph g1 = new AdjListGraph(3);
		g1.addEdge(0, 1);
		g1.addEdge(1, 2);

		System.out.println("Cycle exists in g2: " + detectCycleRecursiveMain(g1));
		System.out.println("Cycle exists Iterative: " + detectCycle(g1, 0));

	}
}