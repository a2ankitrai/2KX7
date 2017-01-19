import java.util.*;

class KthLargestElement {

	public static int getKthLargest(int[] a, int k) {

		PriorityQueue<Integer> pq = new PriorityQueue<>(k, new Comparator<Integer>() {
			@Override
			public int compare(Integer i1, Integer i2) {
				return Integer.compare(i2, i1);
			}
		});

		for (int i : a) {
			pq.add(i);
		}

		int count = 1;
		/*while(!pq.isEmpty()){
			kthLarge = pq.poll();
		}*/

		while(count < k && !pq.isEmpty()){
			pq.poll();
			count++;
		}

		return pq.poll();
	}

	public static void main(String[] args) {

		int[] arr = {1, 23, 12, 9, 30, 2, 50};

		System.out.println(getKthLargest(arr, 3));

	}
}