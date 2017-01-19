/**
* Given an array of n elements, where each element is at most k away from its target position, devise an algorithm that sorts in O(n log k) time. 
*/

import java.util.PriorityQueue;

public class SortKSortedArray {

	public static void sortArray(int[] ar, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);

		for (int i = 0; i < k && i < ar.length; i++) {
			pq.add(ar[i]);
		}

		int n = ar.length;

		for (int i = k, ti = 0; ti < n; i++, ti++) {
			if (i < n) {
				int temp = pq.poll();
				pq.add(ar[i]);
				ar[ti] = temp;
			} else {
				ar[ti] = pq.poll();
			}
		}
	}

	public static void main(String[] args) {

		int k = 3;
		int arr[] = {2, 6, 3, 56, 12, 8};

		sortArray(arr, k);

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}
}