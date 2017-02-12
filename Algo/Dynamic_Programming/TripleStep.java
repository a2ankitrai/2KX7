/**A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3
steps at a time. Implement a method to count how many possible ways the child can run up the
stairs.
*/

import java.util.Arrays;

class TripleStep {

	public static int countWaysR(int n) {

		if (n < 0) {return 0;}
		if (n == 0) {return 1;}
		else {
			return countWaysR(n - 1) + countWaysR(n - 2) + countWaysR(n - 3);
		}
	}

	public static int countWaysDP(int n) {
		int[] memo = new int[n + 1];
		Arrays.fill(memo, -1);
		return countWaysDP(n, memo);
	}

	public static int countWaysDP(int n, int[] memo) {
		if (n < 0) { return 0; }
		else if (n == 0) {return 1;}
		else if (memo[n] > -1) {
			return memo[n];
		} else {
			memo[n] = countWaysDP(n - 1, memo) + countWaysDP(n - 2, memo) + countWaysDP(n - 3, memo);
			return memo[n];
		}
	}

	public static void main(String[] args) {

		int n = 20 ;

		System.out.println("REcursive: " + countWaysR(n));

		System.out.println("DP: " + countWaysDP(n));

	}
}