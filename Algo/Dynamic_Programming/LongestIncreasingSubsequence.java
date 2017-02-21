import java.util.Arrays;

public class LongestIncreasingSubsequence {

	 public static int lengthOfLIS(int[] nums) {
         int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            dp[i] = x;
            if(i == len) len++;
        }
        return len;
    }

    public int lengthOfLIS2(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for (int i = 1; i < dp.length; i++) {
            int maxval = 0;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    maxval = Math.max(maxval, dp[j]);
                }
            }
            dp[i] = maxval + 1;
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
	
	public static void main(String[] args) {
		
		int[] a = {10,9,2,5,3,7,101,18};
		System.out.println(lengthOfLIS(a));
		int[] lis = LIS(a);
		
		for(int i : lis){
			System.out.print(i+" ");
		}
	}
}
