class MissingNumber {

 	static int missingNumber(int[]  nums) {
		int ret = 0;
		for (int i = 0; i < nums.length; ++i) {
			ret ^= i;
			ret ^= nums[i];
		}
		return ret ^= nums.length;
	}

	public static void main(String[] args) {
		
		int[] a = {0,2,3,1,4,5,7,6,8,9};

		System.out.println(missingNumber(a));

	}

}