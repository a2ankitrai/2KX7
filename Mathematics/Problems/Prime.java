import java.util.Arrays;

class Prime {

	public static boolean isPrimeBruteForce(int n) {
		for (int i = 2; i < n; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}

	public static boolean isPrime(int n) {
		if (n <= 1) return false;

		if (n == 2) return true;

		if (n % 2 == 0) return false;

		for (int i = 3; i < n; i += 2) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}

	/**
	* Sieve of Eratosthenes will generate all the primes from 2 to a given number n.
	*/
	public static boolean[] sieve(int n) {
		boolean[] prime = new boolean[n + 1];
		Arrays.fill(prime, true);
		prime[0] = false;
		prime[1] = false;
		double m = Math.sqrt(n);

		for (int i = 2; i <= m; i++){
			if (prime[i]){
				for (int k = i * i; k <= n; k += i)
					prime[k] = false;
			}
		}

		return prime;
	}

	public static void main(String[] args) {

		long startTime = 0, endTime = 0, elapsedTime = 0;
		int number = 351;


		startTime = System.nanoTime();
		System.out.println("Prime Check by isPrimeBruteForce: " + number + " -> " + isPrimeBruteForce(number));
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		System.out.println("Time Consumed by isPrimeBruteForce: " + elapsedTime);

		startTime = System.nanoTime();
		System.out.println("Prime Check by isPrime: " + number + " -> " + isPrime(number));
		endTime = System.nanoTime();
		elapsedTime = endTime - startTime;
		System.out.println("Time Consumed by isPrime: " + elapsedTime);

		System.out.println("Generate prime numbers through sieve: ");

		boolean[] prime = sieve(number);

		for(int i=0; i< prime.length; i++){
			if(prime[i] == true){
				System.out.print(i+" ");
			}
		}

	}
}