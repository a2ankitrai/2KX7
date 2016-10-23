class RodCutting {

	public int max(int... args) {
		int max = args[0];
		for (int i = 1; i < args.length; i++) {
			if (max < args[i]) {
				max = args[i];
			}
		}
		return max;
	}

	public int cutRod(int[] p, int n) {
		if (n == 0) {
			return 0;
		}
		int q = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			q = max(q, p[i] + cutRod(p, n - i - 1));
		}
		return q;
	}

	public int memoizedCutRod(int[] p, int n) {
		int[] r = new int[n];
		for (int i = 0; i < n ; i++ ) {
			r[i] = Integer.MIN_VALUE;
		}
		return memoizedCutRodAux(p, n , r);
	}

	public int memoizedCutRodAux(int[] p , int n , int[] r) {
		if (r[n] >= 0) {
			return r[n];
		}
		int q = Integer.MIN_VALUE;

		for (int i = 0; i < n; i++) {
			q = max(q, p[i] + memoizedCutRodAux(p, n - i - 1, r));
		}

		r[n] = q;
		return q;
	}


	public static void main(String[] args) {
		RodCutting rc =  new RodCutting();

		int[] p = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
		/*int[] p = {0, 1};*/

		System.out.println("\nNaive Recursive imlementation - \n");

		for (int i = 1; i <= p.length; i++) {
			System.out.println("Revenue for " + i + ": " + rc.cutRod(p, i));
		}

		System.out.println("\nMemoized Recursive imlementation - \n");

		for (int i = 0; i < p.length; i++) {
			System.out.println("Revenue for " + i + ": " + rc.memoizedCutRod(p, i));
		}



	}
}