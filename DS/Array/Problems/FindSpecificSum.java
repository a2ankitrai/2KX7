import java.util.*;

class FindSpecificSum {

	static class PairSum implements Comparable<PairSum> {

		int first;
		int second;
		int sum;

		public int compareTo(PairSum o) {
			return this.sum - o.sum;
		}

	}

	public static boolean noCommon(PairSum a, PairSum b) {
		if (a.first == b.first || a.second == b.second || a.first == b.second || a.second == b.first ) {
			return false;
		}
		return true;
	}

	public static void findFourElements(int[] a, int x) {

		int n =  a.length;
		PairSum[] aux = new PairSum[(n * (n - 1) ) / 2];

		int k = 0 ;
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				aux[k] = new PairSum();
				aux[k].first = a[i];
				aux[k].second = a[j];
				aux[k].sum = a[i] + a[j];
				k++;
			}
		}

		Arrays.sort(aux);

		int i = 0;
		int j = aux.length - 1;

		while (i < aux.length && j > 0) {
			if ((aux[i].sum + aux[j].sum == x ) && noCommon(aux[i], aux[j])) {
				System.out.println(aux[i].first + " " + aux[i].second + " " + aux[j].first + " " + aux[j].second);
				//return ;
				i++;j--;
			} else if (aux[i].sum + aux[j].sum < x ) {
				i++;
			} else {
				j--;
			}
		}

	}

	public static void main(String[] args) {
		int[] a = {10, 2, 3, 4, 5, 9, 7, 8};
		int x = 23;
		findFourElements (a, x);
	}
}