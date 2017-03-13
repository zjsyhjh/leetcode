public class Solution {

	private int[][] dp;
    public int findTargetSumWays(int[] nums, int S) {
    	int sum = 0;
    	for (int num : nums) {
    		sum += num;
    	}
    	if (S > sum || S < -sum) {
    	    return 0;
    	}
    	dp = new int[nums.length][(sum << 1) + 1];
    	dp[0][nums[0] + sum]++;
    	dp[0][sum - nums[0]]++;
    	for (int i = 1; i < nums.length; i++) {
    		for (int j = 0; j <= (sum << 1); j++) {
    			if (dp[i - 1][j] > 0) {
    				if (j + nums[i] <= (sum << 1)) dp[i][j + nums[i]] += dp[i - 1][j];
    				if (j - nums[i] >= 0) dp[i][j - nums[i]] += dp[i - 1][j];
    			}
    		}
    	}
    	return dp[nums.length - 1][sum + S];
    }
}