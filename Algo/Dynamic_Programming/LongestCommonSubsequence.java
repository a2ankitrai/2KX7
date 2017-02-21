class LongestCommonSubsequence {

	static int lcsR(String a , String b) {

		if (a.length() == 0 || b.length() == 0) {
			return 0;
		}

		if (a.charAt(a.length() - 1) == b.charAt(b.length() - 1)) {
			return 1 + lcsR(a.substring(0, a.length() - 1), b.substring(0, b.length() - 1));
		} else {
			return Math.max(lcsR(a, b.substring(0, b.length() - 1)),
			                lcsR(a.substring(0, a.length() - 1), b));
		}

	}

	public static int getLongestCommonSubsequence(String a, String b) {
		int m = a.length();
		int n = b.length();
		int[][] dp = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 0;
				} else if (a.charAt(i - 1) == b.charAt(j - 1)) {
					dp[i][j] = 1 + dp[i - 1][j - 1];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}

		return dp[m][n];
	}


	public static void main(String[] args) {

		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";

		System.out.println(lcsR(s1, s2));
		System.out.println(getLongestCommonSubsequence(s1, s2));
	}
}