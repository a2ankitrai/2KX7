import java.util.*;

class KthSmallestElement {

	static class HeapNode implements Comparable<HeapNode> {
		int val;
		int r, c;

		public HeapNode(int val, int r, int c) {
			this.val = val;
			this.r = r;
			this.c = c;
		}

		@Override
		public int compareTo(HeapNode o){
			return this.val - o.val;
		}
	}

	public static int getKthSmallest(int[][] mat, int k) {
		PriorityQueue<HeapNode> pq = new PriorityQueue<>(k);

		int n = mat[0].length;

		int count = 0;

		for (int j = 0; j < n; j++) {
			pq.add(new HeapNode(mat[0][j], 0, j));
		}

		HeapNode h = null;
		while (count != k) {
			h = pq.poll();
			pq.add(new HeapNode(mat[h.r+1][h.c], h.r+1 , h.c));
			
			count++;	
		}

		return h.val;
	}

	public static void main(String[] args) {

		int mat[][] = { {10, 20, 30, 40},
			{15, 25, 35, 45},
			{25, 29, 37, 48},
			{32, 33, 39, 50},
		};

		System.out.println(getKthSmallest(mat,7));
	}

}