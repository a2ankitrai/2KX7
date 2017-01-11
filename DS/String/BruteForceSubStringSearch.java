class BruteForceSubStringSearch {

	public static int search(String text, String pat) {

		int N = text.length();
		int M = pat.length();

		for (int i = 0; i < N - M; i++) {

			int j ;
			for (j = 0 ; j < M; j++) {
				if (text.charAt(i + j) != pat.charAt(j)) {
					break;
				}
			}
			if (j == M) {
				return i;
			}
		}
		return -1;
	}

	public static int searchWithBackup(String text, String pat) {
		int i, N = text.length();
		int j, M = pat.length();

		for (i = 0, j = 0; i < N && j < M; i++) {
			if (text.charAt(i) == pat.charAt(j)) {
				j++;
			} else {
				i -= j;
				j = 0;
			}
		}
		if (j == M) {
			return i - M;
		} else {
			return -1;
		}

	}

	public static void main(String[] args) {

		String text = "ABACADABRAC";
		String pat = "ABRA";

		System.out.println(search(text, pat));

		System.out.println(searchWithBackup(text, pat));

	}

}