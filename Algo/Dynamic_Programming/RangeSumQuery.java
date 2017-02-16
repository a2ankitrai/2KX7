/**
*Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
*
*
*/

class RangeSumQuery {
	int[] nums;

	public RangeSumQuery(int[] nums) {
		for (int i = 1; i < nums.length; i++)
			nums[i] += nums[i - 1];

		this.nums = nums;
	}

	public  int sumRange(int i, int j) {
		if (i == 0)
			return nums[j];

		return nums[j] - nums[i - 1];
	}

	public static void main(String[] args) {
		
		int[] a = new int[]{-2, 0, 3, -5, 2, -1};

		RangeSumQuery rs = new RangeSumQuery(a);

		System.out.println("sumRange(0, 2): "+ rs.sumRange(0, 2));
		System.out.println("sumRange(2, 5): "+ rs.sumRange(2, 5));
		System.out.println("sumRange(0, 5): "+ rs.sumRange(0, 5));

	}
}
