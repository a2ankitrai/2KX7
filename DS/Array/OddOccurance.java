//find the element occurring odd number of times

class OddOccurance {

	public int getOddOccurrence(int[] a,int n) {
		int result = 0;

		for (int i = 0; i < n; i++) {
			result ^= a[i];
		}
		return result;
	}

	public static void main(String[] args) {
		OddOccurance occur = new OddOccurance();
		int ar[] = new int[] {2, 3, 5, 4, 5, 2, 4, 5, 5, 2, 4, 4, 2};
		int n = ar.length;
		System.out.println(occur.getOddOccurrence(ar, n));
	}

}