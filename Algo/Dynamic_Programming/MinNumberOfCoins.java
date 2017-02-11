class MinNumberOfCoins {

	public static int minNumCoinsR(int[] coins, int v) {

		if (v == 0) {
			return 0;
		}

		int minNum = Integer.MAX_VALUE;

		for (int i = 0; i < coins.length; i++) {
			if (coins[i] <= v) {

				int subRes = minNumCoinsR(coins, v - coins[i]);

				if (subRes != Integer.MAX_VALUE && subRes + 1 < minNum)	{
					minNum = subRes + 1;
				}
			}
		}
		return minNum;
	}

	public static int minNumCoinsDP(int[] coins, int v) {

		// table[i] will be storing the minimum number of coins
		// required for i value.  So table[V] will have result
		int[] table = new int[v + 1];

		// Base case (If given value V is 0)
		table[0] = 0;

		// Initialize all table values as Infinite
		for (int i = 1; i <= v; i++) {
			table[i] = Integer.MAX_VALUE;
		}

		// Compute minimum coins required for all
		// values from 1 to v
		for (int i = 1; i <= v; i++) {

			for (int j = 0; j < coins.length; j++) {
				if (coins[j] <= i) {
					int sub_res = table[i - coins[j]];
					if (sub_res != Integer.MAX_VALUE && sub_res + 1 < table[i])
						table[i] = sub_res + 1;
				}
			}

		}

		return table[v];
	}

	public static void main(String[] args) {

		int[] coins =  {25, 10, 5};
		int v = 30;

		int[] coins2 = {9, 6, 5, 1};
		int v2 = 11;

		System.out.println(" MinNumberOfCoinsR for 1: " + minNumCoinsDP(coins, v));

		System.out.println(" MinNumberOfCoinsR for 2: " + minNumCoinsDP(coins2, v2));

	}

}