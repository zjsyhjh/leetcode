/*
 * dp[i] = min(dp[i], dp[i - coins[j]]) + 1);
 */
public class Solution {

	private int[] dp;
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0 || amount == 0) {
        	return 0;
        }
       	int len = amount;
       	int minNum = 0x3f3f3f3f;
       	for (int i = 0; i < coins.length; i++) {
       		len = Math.max(len, coins[i]);
       		minNum = Math.min(minNum, coins[i]);
       	}
        
        if (minNum > amount) {
            return -1;
        }
        
       	dp = new int[len + 1];
       	for (int i = 1; i <= amount; i++) {
       		dp[i] = 0x3f3f3f3f;
       	}

       	for (int i = 0; i < coins.length; i++) {
       		dp[coins[i]] = 1;
       	}

       	dp[0] = 0;
       	for (int i = 1; i <= amount; i++) {
       		for (int j = 0; j < coins.length; j++) {
       			if (i - coins[j] >= 0) {
       				dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
       			}
       		}
       	}
        if (dp[amount] == 0x3f3f3f3f) {
            return -1;
        }
        return dp[amount];
    }
}