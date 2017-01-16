import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;


public class QuickFindUF {

	private int[] id;

	public QuickFindUF(int N) {
		this.id = new int[N];
		for (int i = 0; i < N; i++) {
			id[i] = i;
		}
	}

	public void union(int p, int q) {
		
		int pid = id[p];
		int qid = id[q];

		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid) {
				id[i] = qid;
			}
		}
	}

	public boolean connected(int p, int q) {
		return id[p] == id[q];
	}


	public static void main(String[] args) throws IOException {

		Scanner sc = new Scanner(new File("tinyUF.txt"));
		int N = sc.nextInt();

		QuickFindUF uf = new QuickFindUF(N);

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