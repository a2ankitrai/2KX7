import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class QuickUnionFind {

	private int[] id;

	public QuickUnionFind(int N) {
		id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	private int root(int i) {

		while (id[i] != i) {
			i = id[i];
		}
		return i;
	}

	public boolean connected(int p, int q) {
		return root(p) == root(q);
	}

	public void union(int p, int q){
		int i = root(p);
		int j = root(q);
		id[i] = j;
	}

	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(new File("tinyUF.txt"));
		int N = sc.nextInt();

		QuickUnionFind uf = new QuickUnionFind(N);

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