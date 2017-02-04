import java.util.Arrays;
import java.util.*;
class PairSum {

	static class Pair {
		int x, y;

		Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void printPair() {
			System.out.println(x + ", " + y);
		}
	}

	public static Pair checkForPair(int[] a, int x) {
		int i = 0, j = a.length - 1;

		while (i < j) {
			if (a[i] + a[j] == x) {
				return new Pair(a[i], a[j]);
			} else if (a[i] + a[j] > x) {
				j--;
			} else {
				i++;
			}
		}
		return null;
	}

	public static Pair checkForPair2(int[] a, int x) {

		HashSet<Integer> s = new HashSet<>();

		for (int i = 0 ; i < a.length; i++) {

			int diff = x - a[i];

			if (diff >= 0 && s.contains(diff)) {
				return new Pair(a[i], diff);
			}
			s.add(i);
		}
		return null;
	}

	public static void main(String[] args) {
		int[] a = { -8, 1, 4, 2, 10, 45};

		//	Arrays.sort(a);

		Pair p = checkForPair2(a, 12);
		if (p != null) {
			System.out.println("Pair found " + p.x + ", " + p.y);
		} else {
			System.out.println("No Pair found");
		}
	}
}