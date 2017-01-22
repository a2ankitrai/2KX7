
// Incomplete ...

public class CycleDetectionUnionFind {

	// Using disjoint sets: makeSet, Union, findset
	public boolean detectCycleUsingDisjointSet() {

		return true;
	}

	private int[] makeSet(AdjListGraph g) {
		int vertices = g.getVertices();
		int connectArr[] = new int[vertices];
		for (int i = 0; i < vertices; i++) {
			connectArr[i] = i;
		}
		return connectArr;
	}

	private int root(int i, int[] id) {

		while (i != id[i]) {
			id[i] = id[id[i]]; // path compression.
			i = id[i];
		}
		return i;
	}

	private boolean isConnected(int[] id, int p, int q){
		return false;
	}

	private void union(int[] id,int p, int q){

	}


	public static void main(String[] args) {
		AdjListGraph g = new AdjListGraph(4);


	}

}