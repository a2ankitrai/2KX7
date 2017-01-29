import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.Stack;

// Same as AdjListGraph but have directed edges
public class DirectedGraph {

	private int v;
	private LinkedList<Integer> adjList[];
	private boolean[] marked;

	public DirectedGraph(int verticesSize) {
		adjList = (LinkedList<Integer>[])new LinkedList[verticesSize];
		v = verticesSize;
		marked = new boolean[verticesSize];

		for (int i = 0; i < verticesSize; i++) {
			adjList[i] = new LinkedList<Integer>();
		}

	}

	public void addEdge(int v, int w) {
		try {
			adjList[v].add(w);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("The vertex does not exists");
		}
	}

	public boolean detectCycle() {

		boolean[] visited = new boolean[v];
		boolean[] recStack = new boolean[v];

		for (int i = 0; i < v; i++) {
			if (detectCycleHelper(visited, recStack, i)) {
				return true;
			}
		}
		return false;
	}

	public boolean detectCycleHelper(boolean[] visited, boolean[] recStack, int source) {

		if (!visited[source]) {
			visited[source] = true;
			recStack[source] = true;
			Iterator<Integer> it = adjList[source].iterator();

			while (it.hasNext()) {
				int n = it.next();
				if (!visited[n] && detectCycleHelper(visited, recStack, n)) {
					return true;
				} else if (recStack[n]) {
					return true;
				}
			}
		}
		recStack[source] = false;
		return false;
	}

	public void bfs(int s) {
		boolean[] visited = new boolean[v];

		Queue<Integer> q = new LinkedList<Integer>();
		visited[s] = true;
		q.offer(s);

		while (!q.isEmpty()) {
			Integer ns = q.poll();

			System.out.println(ns + " ");

			Iterator<Integer> it = adjList[ns].listIterator();

			while (it.hasNext()) {
				int n = it.next();
				if (!visited[n]) {
					visited[n] = true;
					q.offer(n);
				}
			}
		}

	}

	public void dfs(int source) {
		Stack<Integer> s = new Stack<Integer>();
		Stack<Integer> op = new Stack<Integer>();

		marked[source] = true;
		s.push(source);

		while (!s.isEmpty()) {
			Integer ns = s.pop();

			Iterator<Integer> it = adjList[ns].descendingIterator();

			while (it.hasNext()) {
				int n = it.next();
				if (!marked[n]) {
					marked[n] = true;
					s.push(n);
				}
			}
			op.push(ns);
		}

		while (!op.isEmpty()) {
			System.out.print(op.pop() + " ");
		}
	}

	public void dfsRecursive(int source) {
		boolean[] marked = new boolean[v];
		int[] edgeTo = new int[v];

		dfsRecursiveMain(source, marked, edgeTo);
	}

	public void dfsRecursiveMain(int s, boolean[] marked, int[] edgeTo) {
		marked[s] = true;
		for (int w : adjList[s]) {
			if (!marked[w]) {
				dfsRecursiveMain(w, marked, edgeTo);
				edgeTo[w] = s;
			}
		}
	}

	void topologicalSortHelper(int v, boolean[] marked, Stack<Integer> s) {

		marked[v] = true;

		for (int i : adjList[v]) {
			if (!marked[i]) {
				topologicalSortHelper(i, marked, s);
			}
		}
		s.push(v);
	}

	public void topologicalSort() {
		Stack<Integer> op = new Stack<Integer>();
		boolean[] marked = new boolean[v];

		for (int i = 0; i < v; i++) {
			if (!marked[i]) {
				topologicalSortHelper(i, marked, op);
			}
		}

		while (!op.isEmpty()) {
			System.out.print(op.pop() + " ");
		}
	}

	public static void main(String[] args) {
		DirectedGraph g = new DirectedGraph(4);

		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 3);
		//	g.addEdge(3, 3);

		DirectedGraph g2 = new DirectedGraph(3);

		g2.addEdge(0, 1);
		g2.addEdge(1, 2);
		g2.addEdge(0, 2);
		

		System.out.println("G1 Cycle Detecion: " + g.detectCycle());

		System.out.println("G2 Cycle Detecion: " + g2.detectCycle());
	}
}