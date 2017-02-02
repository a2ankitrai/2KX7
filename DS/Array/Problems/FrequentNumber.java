/**Given an integer array, find the most frequent number and it's count in the array. Write the

code in O(1) space. Eg 1 , 3, 4, 5, 2, 2, 3, 2 Output Most frequent number is 2.*/

class FrequentNumber {


	public static int getMostFrequent(int[] a) {

		int maxF = 0;

		int currentMaxNo = -1;

		for (int i = 0; i < a.length - 1; i++) {
			int currentMaxF = 0;

			for (int j = 1 ; j < a.length; j++) {
				if (a[i] == a[j]) {
					currentMaxF++;
				}
			}
			if (maxF < currentMaxF) {
				maxF  = currentMaxF;
				currentMaxNo = a[i];
			}
		}

		System.out.println(currentMaxNo + ": " + maxF);
		return currentMaxNo;
	}

	public static void main(String[] args) {

		int a[] = {1 , 3, 4, 5, 2, 2, 3, 2};

		System.out.println(getMostFrequent(a));
	}
}