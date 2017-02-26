class MaxProductSubArray {

	static int getMaxProduct(int[] a) {

		int maxHere = 1;
		int minHere = 1;

		int maxSoFar = 1;

		for (int i = 1 ; i < a.length ; i++) {
			if (a[i] > 0 ) {
				maxHere *= a[i];
				minHere = Math.min(minHere * a[i], 1);
			} else if (a[i] == 0) {
				maxHere = 1;
				minHere = 1;
			} else {
				int temp = maxHere;
				maxHere = Math.max(minHere * a[i], 1);
				minHere = temp * a[i];
			}
			if(maxSoFar < maxHere){
				maxSoFar = maxHere;
			}
		}
		return maxSoFar;
	}

	public static void main(String[] args) {
		
		int arr[] = {1, -2, -3, 0, 7, -8, -2};
        System.out.println("Maximum Sub array product is "+
                            getMaxProduct(arr));

	}
}