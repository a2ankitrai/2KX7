import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.Stack;

// Error
public class AdjListGraph {

	private int v;
	private LinkedList<Integer> adjList[];

	public AdjListGraph(int verticesSize) {
		adjList = (LinkedList<Integer>[])new LinkedList[verticesSize];
		v = verticesSize;
		/* for (List<Integer> listNode : adjList) {
			listNode = new LinkedList<Integer>();
		}*/
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
		boolean[] visited = new boolean[v];

		Stack<Integer> s = new Stack<Integer>();
		visited[source] = true;
		s.push(source);

		while (!s.isEmpty()) {
			Integer ns = s.pop();

			System.out.println(ns + " ");

			Iterator<Integer> it = adjList[ns].descendingIterator();

			while (it.hasNext()) {
				int n = it.next();
				if (!visited[n]) {
					visited[n] = true;
					s.push(n);
				}
			}
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

	public static void main(String[] args) {
		AdjListGraph g = new AdjListGraph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		System.out.println("Following is Breadth First Traversal " +
		                   "(starting from vertex 2)");

		g.bfs(2);

		System.out.println("Following is Depth First Traversal " +
		                   "(starting from vertex 2)");

		g.dfs(2);
	}
}