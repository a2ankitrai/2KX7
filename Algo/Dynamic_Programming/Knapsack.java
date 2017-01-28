class Knapsack {

	public static int knapSackR(int W, int[] w, int[] v, int n) {

		// Base Case
		if (n == 0 || W == 0) {
			return 0;
		}

		// If weight of the nth item is more than Knapsack capacity W, then
		// this item cannot be included in the optimal solution
		if (w[n - 1] > W) {
			return knapSackR(W, w, v, n - 1);
		}

		// Return the maximum of two cases:
		// (1) nth item included
		// (2) not included
		else {
			return Math.max(v[n - 1] + knapSackR(W - w[n - 1], w, v, n - 1), knapSackR(W, w, v, n - 1));
		}
	}

	public static int knapSackDP(int W, int[] w, int[] v, int n) {

		int[][] k = new int[n + 1][W + 1];

		for (int i = 0; i <= n; i++) {

			for (int j = 0; j <= W; j++) {

				if (i == 0 || j == 0) {
					k[i][j] = 0;
				} else if (w[i - 1] <= j) {
					k[i][j] = Math.max(v[i - 1] + k[i - 1][j - w[i - 1]], k[i - 1][j]);
				} else {
					k[i][j] = k[i - 1][j];
				}
			}

		}

		for (int p = 0 ; p < n + 1; p++) {
			System.out.println("");
			for (int q = 0 ; q < W + 1; q++) {
				System.out.print(k[p][q] + " ");
			}
		}

		return k[n][W];
	}


	public static void main(String[] args) {
		int[] w = {1, 3, 4, 5};
		int[] v = {1, 4, 5, 7};
		int weight = 7;
		int n = v.length;

		System.out.println("Case 1: ");
		System.out.println("knapSackR: " + knapSackR(weight, w, v, n));
		System.out.println("knapSackDP: " + knapSackDP(weight, w, v, n));

		int val[] = new int[] {60, 100, 120};
		int wt[] = new int[] {10, 20, 30};
		int  W = 50;
		int n2 = val.length;

		System.out.println("Case 2: ");
		System.out.println("knapSackR: "+knapSackR(W, wt, val, n2));
		System.out.println("knapSackDP: "+knapSackDP(W, wt, val, n2));
	}
}