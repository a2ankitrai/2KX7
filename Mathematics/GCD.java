class GCD {

	public static int gcd(int a, int b) {
		for (int i = Math.min(a, b); i >= 1; i--) {
			if (a % i == 0 && b % i == 0) return i;
		}
		return 0;
	}

	public static int gcdEuclid(int a, int b) {
		if (b == 0) return a;
		return gcdEuclid(b, a % b);
	}

	public int LCM(int a, int b) {
		return b * a / gcdEuclid(a, b);
	}

	public static void main(String[] args) {

		System.out.println("GCD of 2336 and 1314: " + gcd(2336, 1314));
		System.out.println("GCD of 2336 and 1314: " + gcdEuclid(2336, 1314));
	}
}