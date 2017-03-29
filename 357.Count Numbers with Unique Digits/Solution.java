/*
 * dp[i]表示i位数字的全部总数
 * dp[1] = 10;
 * dp[2] = 91
 * dp[i] = (dp[i - 1] - dp[i - 2]) * (11 - i) + dp[i - 1];
 */
public class Solution {
	
	private int[] dp;

    public int countNumbersWithUniqueDigits(int n) {
		dp = new int[11];
		dp[0] = 1;
		dp[1] = 10;
		dp[2] = 91;

		for (int i = 3; i <= 10; i++) {
			dp[i] = (dp[i - 1] - dp[i - 2]) * (11 - i) + dp[i - 1];
		}

		if (n > 10) {
			n = 10;
		}
		return dp[n];
    }
}