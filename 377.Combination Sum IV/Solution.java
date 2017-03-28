/*
 * dp[i]表示组成i的方式的总数
 */
public class Solution {

    private int[] dp;

    public int combinationSum4(int[] nums, int target) {
        
        dp = new int[target + 1];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                dp[nums[i]] = 1;
            }
        }
        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (i - nums[j] >= 0) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }

        return dp[target];
    }
}

