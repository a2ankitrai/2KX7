class CelebrityProblem {

	static int n  = 4;
	static int[][] matrix = {{0, 0, 1, 0},
		{0, 0, 1, 0},
		{0, 0, 0, 0},
		{0, 0, 1, 0}
	};

	static int knows(int a, int b) {
		return matrix[a][b];
	}

	static int findCelebrity() {

		int a = 0;
		int b = n - 1;

		while (a < b) {
			if (knows(a, b) == 1) {
				a++;
			} else {
				b--;
			}
		}

		for (int i = 0; i < n; i++) {
			if ((i != a) && (knows(a, i) == 1 && knows(i, a) == 0)) {
				return -1;
			}
		}
		return a;
	}

	public static void main(String[] args) {


		System.out.println(findCelebrity());



	}




}