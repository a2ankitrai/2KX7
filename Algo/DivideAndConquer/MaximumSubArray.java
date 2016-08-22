class MaximumSubArray {

	static class SubArrayObject {
		int maxLeft;
		int maxRight;
		int sum;

		public SubArrayObject(int maxLeft, int maxRight, int sum) {
			this.maxLeft = maxLeft;
			this.maxRight = maxRight;
			this.sum = sum;
		}
	}

	public SubArrayObject getMaxCrossingSubArray(int[] a, int low, int mid, int high) {
		int leftSum = Integer.MIN_VALUE;
		int sum = 0;
		int maxLeft = 0;
		for (int i = mid; i >= low; i--) {
			sum += a[i];
			if (sum > leftSum) {
				leftSum = sum;
				maxLeft = i;
			}
		}

		int rightSum = Integer.MIN_VALUE;
		sum = 0;
		int maxRight = 0;
		for (int j = mid + 1; j <= high ; j++ ) {
			sum += a[j];
			if (sum > rightSum) {
				rightSum = sum;
				maxRight = j;
			}
		}
		SubArrayObject maxCrossingSubArray = new SubArrayObject(maxLeft, maxRight, leftSum + rightSum);
		return maxCrossingSubArray;
	}

	public SubArrayObject getMaxSubArray(int[] a, int low, int high) {

		if (high == low) {
			SubArrayObject	sAO = new SubArrayObject(low, high, a[low]);
			return sAO;
		} else {
			int mid = (low + high) / 2;
			SubArrayObject maxLeftSubArray = getMaxSubArray(a, low, mid);
			SubArrayObject maxRightSubArray = getMaxSubArray(a, mid + 1, high);
			SubArrayObject maxCrossingSubArray = getMaxCrossingSubArray(a, low, mid, high);

			if (maxLeftSubArray.sum >= maxRightSubArray.sum && maxLeftSubArray.sum >= maxCrossingSubArray.sum) {
				return maxLeftSubArray;
			} else if (maxRightSubArray.sum >= maxLeftSubArray.sum && maxRightSubArray.sum >= maxCrossingSubArray.sum) {
				return maxRightSubArray;
			} else {
				return maxCrossingSubArray;
			}
		}
	}

	public static void main(String[] args) {
		MaximumSubArray msa = new MaximumSubArray();
		int[] a = {13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7};
		SubArrayObject maxSubArray = null;
		maxSubArray = msa.getMaxSubArray(a, 0, a.length - 1);
		if (maxSubArray != null) {
			System.out.println("Left Index: " + maxSubArray.maxLeft);
			System.out.println("Right Index: " + maxSubArray.maxRight);
			System.out.println("Sum: " + maxSubArray.sum);
		} else {
			System.out.println("Max sub array not found");
		}
	}

}