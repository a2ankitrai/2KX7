class Power {

	public static long pow (int num, int p) {

		if (p < 0) {
			throw new IllegalArgumentException("n must be >= 0");
		}

		if (p == 0) {
			return 1;
		} else {
			return num * pow(num, p - 1);
		}
	}

	public static long power2(int num, int p) {

		if (p == 0)
			return 1;

		if (p % 2 == 0) {
			return pow(num, p / 2) * pow(num, p / 2);
		} else {
			return num * pow(num, p / 2) * pow(num, p / 2);
		}

	}

	public static void main(String[] args) {

		System.out.println(power2(2, 5));
	}

}