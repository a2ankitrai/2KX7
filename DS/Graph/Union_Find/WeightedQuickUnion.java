import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

class WeightedQuickUnion {

	private int[] id;

	// extra array to count number of objects in the tree rooted at i
	private int[] sz;

	public WeightedQuickUnion(int N) {
		id = new int[N];
		sz = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}

	private int root(int i) {

		while (i != id[i]) {
			id[i] = id[id[i]]; // path compression.
			i = id[i];
		}
		return i;
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public void union(int p, int q) {
		int i = root(p);
		int j = root(q);

		if (i == j) {
			return;
		}

		if (sz[i] < sz[j]) {
			id[i] = j;
			sz[j] += sz[i];
		} else {
			id[j] = i;
			sz[i] += sz[j];
		}
	}

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(new File("tinyUF.txt"));
		int N = sc.nextInt();

		WeightedQuickUnion uf = new WeightedQuickUnion(N);

		while (sc.hasNextInt()) {

			int p = sc.nextInt();
			int q = sc.nextInt();

			if (!uf.connected(p, q)) {
				uf.union(p, q);
				System.out.println(p + " " + q);
			}

		}
		sc.close();
	}

}