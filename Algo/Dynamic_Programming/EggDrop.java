class EggDrop {

	/*Recursive Function to get minimum number of trials needed in worst
	case with n eggs and k floors */
	public static int dropEggRecursive(int n, int k) {

		// If there are no floors, then no trials needed. OR if there is
		// one floor, one trial needed.
		if (k == 1 || k == 0) {
			return k;
		}


		// We need k trials for one egg and k floors
		if (n == 1) {
			return k;
		}

		int min = Integer.MAX_VALUE;
		int tempRes = Integer.MAX_VALUE;

		for (int x = 1 ; x <= k; x++) {
			tempRes = Math.max(dropEggRecursive(n - 1, x - 1), dropEggRecursive(n, k - x));
			if (tempRes < min) {
				min = tempRes;
			}
		}
		return min + 1;
	}

	public static int dropEggDP(int n, int k) {
		int[][] eggFloor = new int[n + 1][k + 1];
		int res;
		int i, j, x;

		// We need one trial for one floor and0 trials for 0 floors
		for (i = 1; i <= n; i++) {
			eggFloor[i][1] = 1;
			eggFloor[i][0] = 0;
		}


		// We always need j trials for one egg and j floors.
		for (j = 1; j <= k; j++) {
			eggFloor[1][j] = j;
		}


		 // Fill rest of the entries in table using optimal substructure
        // property	
		for (i = 2; i <= n; i++) {
			for (j = 2; j <= k; j++) {
				eggFloor[i][j] = Integer.MAX_VALUE;
				for (x = 1 ; x <= j; x++) {
					res = 1 + Math.max(eggFloor[i - 1][x - 1], eggFloor[i][j - x]);
					if (res < eggFloor[i][j]) {
						eggFloor[i][j] = res;
					}
				}
			}
		}

		for (int p = 0 ; p < n + 1; p++) {
			System.out.println("");
			for (int q = 0 ; q < k + 1; q++) {
				System.out.print(eggFloor[p][q] + " ");
			}
		}
		System.out.println();
		return eggFloor[n][k];
	}

	public static void main(String[] args) {

		int n = 2, k = 36;
//		System.out.println(" number of trials Recursive " + dropEggRecursive(n, k));
		System.out.println(" number of trials DP " + dropEggDP(n, k));



	}

}