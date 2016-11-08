import java.util.ArrayList;
import java.util.List;

class GraphTest {
	
	public static void main(String[] args) {
		Graph g1  = new Graph();

		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");
		Vertex v3 = new Vertex("3");
		Vertex v4 = new Vertex("4");
		Vertex v5 = new Vertex("5");
		
		List<Vertex> v1List = new ArrayList<Vertex>();
		v1List.add(v2);
		v1List.add(v5);
		
		List<Vertex> v2List = new ArrayList<Vertex>();
		v2List.add(v1);
		v2List.add(v5);
		v2List.add(v3);
		v2List.add(v4);
		
		List<Vertex> v3List = new ArrayList<Vertex>();
		v3List.add(v2);
		v3List.add(v4);
		
		List<Vertex> v4List = new ArrayList<Vertex>();
		v4List.add(v2);
		v4List.add(v5);
		v4List.add(v3);
		
		List<Vertex> v5List = new ArrayList<Vertex>();
		v5List.add(v4);
		v5List.add(v1);
		v5List.add(v2);
		
		g1.verticesMap.put(v1, v1List);
		g1.verticesMap.put(v2, v2List);
		g1.verticesMap.put(v3, v3List);
		g1.verticesMap.put(v4, v4List);
		g1.verticesMap.put(v5, v5List);
		
		// g1.printGraph();
		//g1.breadthFirstSearch(v3);
		g1.depthFirstSearch();
	}
}