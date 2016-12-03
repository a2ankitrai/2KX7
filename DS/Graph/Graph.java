
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Queue;


public class Graph {

	HashMap<Vertex, List<Vertex>> verticesMap;

	public Graph() {
		this.verticesMap = new HashMap<Vertex, List<Vertex>>();
	}

	public void printGraph() {
		for (Entry<Vertex, List<Vertex>> entry : verticesMap.entrySet()) {
			Vertex u = entry.getKey();
			List<Vertex> adjList = entry.getValue();

			System.out.print("|" + u.name + "|" + "=> ");
			for (Vertex v : adjList) {
				System.out.print(v.name + "--> ");
			}
			System.out.println();
		}
	}

	public void breadthFirstSearch(Vertex s) {
		for (Vertex u : verticesMap.keySet()) {
			if (u == s) {
				continue;
			}
			u.color = Vertex.Color.WHITE;
			u.distance = -1;
			u.parent = null;
		}
		s.color = Vertex.Color.GRAY;
		System.out.println(s.name);
		s.distance = 0;
		s.parent = null;

		Queue<Vertex> q = new LinkedList<Vertex>();
		q.offer(s);

		while (!q.isEmpty()) {
			Vertex u = q.poll();
			List<Vertex> adjList = verticesMap.get(u);
			for (Vertex v : adjList) {
				if (v.color == Vertex.Color.WHITE) {
					v.color = Vertex.Color.GRAY;
					System.out.println(v.name);
					v.distance = u.distance + 1;
					v.parent = u;
					q.offer(v);
				}
			}
			u.color = Vertex.Color.BLACK;
		}

	}

	public void depthFirstSearch() {
		for (Vertex u : verticesMap.keySet()) {
			u.color = Vertex.Color.WHITE;
			u.parent = null;
		}
		int time = 0;
		for (Vertex u : verticesMap.keySet()) {
			if (u.color == Vertex.Color.WHITE)
				dfsVisit(u, time);
		}
	}

	public void dfsVisit(Vertex u, int time) {
		time++;
		u.discoveryTime = time;
		u.color = Vertex.Color.GRAY;
		System.out.println(u.name + " Discovery: " + time);
		for (Vertex v : verticesMap.get(u)) {
			if (v.color == Vertex.Color.WHITE) {
				v.parent = u;
				dfsVisit(v, time);
			}
		}
		u.color = Vertex.Color.BLACK;
		time++;
		u.finishedTime = time;
	}
}