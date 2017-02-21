class MaximizeDifference {

	static int maxDiff(int[] a) {

		int[] diff = new int[a.length];

		for (int i = 0 ; i < a.length ; i++) {
			diff[i] = a[i] - i;
		}

		int max = diff[0];
		int min = diff[0];

		for (int d : diff) {
			System.out.print(d + " ");
		}

		for (int i = 1 ; i < diff.length; i++) {
			if(max < diff[i]){
				max = diff[i];
			}
			if(min > diff[i]){
				min = diff[i];
			}
		}
		System.out.println();
		return max - min;
	}

	public static void main(String[] args) {
		
		int arr[] = {9, 15, 4, 12, 13};
		int b[] = {-1, -2, -3, 4, 10};

	//		System.out.println(maxDiff(arr));

		System.out.println();	
		System.out.println(maxDiff(b));


	}
}