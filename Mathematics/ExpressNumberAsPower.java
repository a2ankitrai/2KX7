/**
* Check if a number can be expressed as x^y
*Given a positive integer n,
*find if it can be expressed as x^y where y > 1 and x > 0 and x and y both are both integers.
*/

class ExpressNumberAsPower {

	public static boolean checkNumber(int n) {

		if (n == 1) return true;

		int k = (int)Math.sqrt(n);

		for (int x = 2; x <= k; x++) {
			int y = 2;

			int p = (int)Math.pow(x, y);

			while (p <= n && p > 0) {
				if (p == n) {
					return true;
				}

				y++;
				p = (int)Math.pow(x, y);
			}
		}
		return false;
	}

	public static void main(String[] args) {

		int num  = 1;

		System.out.println("Is " + num + " expressible : " + checkNumber(num));

	}

}