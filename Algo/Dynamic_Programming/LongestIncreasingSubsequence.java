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
	 
	 public static int[] LIS(int[] nums) {
         int[] dp = new int[nums.length];
        int len = 0;

        for(int x : nums) {
            int i = Arrays.binarySearch(dp, 0, len, x);
            if(i < 0) i = -(i + 1);
            if(i>0){
                dp[i] = x;	
            }
            if(i == len) len++;
        }
        return dp;
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
