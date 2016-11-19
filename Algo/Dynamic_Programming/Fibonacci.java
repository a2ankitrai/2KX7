class Fibonacci {

	public static int traditionalFibonacci(int n) {
		if (n == 0) return 0;
		if (n == 1) return 1;

		else {
			return traditionalFibonacci(n - 1) + traditionalFibonacci(n - 2);
		}
	}


	public int fibonacciMemo(int n) {
		int[] memo  = new int[n + 1];

		for (int i = 0; i < memo.length ; i++ ) {
			memo[i] = -1;
		}

		return fibonacciMemoAux(n, memo);
	}

	public int fibonacciMemoAux(int n, int[] memo) {
		if (n == 0) return 0;
		if (n == 1) return 1;
		if (memo[n] != -1) {
			return memo[n];
		} else {
			return fibonacciMemoAux(n - 1, memo) + fibonacciMemoAux(n - 2, memo);
		}
	}






	public static void main(String[] args) {
		int n = 12;

		System.out.println(traditionalFibonacci(n));

		Fibonacci fib = new Fibonacci();

		System.out.println(fib.fibonacciMemo(n));
	}
}