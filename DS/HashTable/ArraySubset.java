import java.util.*;

class ArraySubset {


	public static boolean isSubset(int[] a, int[] b) {

		HashSet<Integer> set = new HashSet<>();
		for (int i : a) {
			set.add(i);
		}

		for (int i : b) {
			if (!set.contains(i)) {
				return false;
			}
		}

		return true;
	}


	public static void main(String[] args) {

		int[] a  = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int[] b = new int[] {3, 5, 8, 9};
		int[] c = new int[] {2, 12, 23};

		System.out.println("Array subset a, b: " + isSubset(a, b));

		System.out.println("Array subset a, c: " + isSubset(a, c));

	}
}