import java.util.List;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Iterator;
import java.util.Stack;

class AdjMatrixGraph {

	private int[][] adjMatrix;
	private int v;

	public AdjMatrixGraph(int v) {
		this.v = v;
		adjMatrix = new int[v][v];
	}

	public void addEdge(int to, int from, int edge) {
		try {
			adjMatrix[to][from] = edge;
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("The vertices does not exists");
		}
	}

	public int getEdge(int to, int from) {
		try {
			return adjMatrix[to][from];
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("The vertices does not exists");
		}
		return -1;
	}

	public void bfs(int s) {
		boolean[] visited = new boolean[v];
		visited[s] = true;
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(s);

		while (!q.isEmpty()) {
			Integer ns = q.poll();
			System.out.print(ns+" ");	

			for (int i = 0; i < v; i++) {
				if (adjMatrix[ns][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.offer(i);
				} 
			}
		}
	}

	public void printGraph() {

		for (int i = 0; i < v; i++) {
			for (int j = 0; j < v; j++) {
				System.out.print(adjMatrix[i][j] + " ");
			}
			System.out.println();
		}

	}

	public static void main(String[] args) {

		AdjMatrixGraph g = new AdjMatrixGraph(4);

		g.addEdge(0, 1, 1);
		g.addEdge(0, 2, 1);
		g.addEdge(1, 2, 1);
		g.addEdge(2, 0, 1);
		g.addEdge(2, 3, 1);
		g.addEdge(3, 3, 1);

		g.printGraph();

		System.out.println("Following is Breadth First Traversal " +
		                   "(starting from vertex 2)");

		g.bfs(2);

	}

}