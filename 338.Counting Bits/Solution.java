/*
 * x & (x - 1) 去掉x的最后一个1
 */
public class Solution {

	private int[] dp;
    public int[] countBits(int num) {
    	dp = new int[num + 1];
       	dp[0] = 0;
       	for (int i = 1; i <= num; i++) {
       		dp[i] = dp[i & (i - 1)] + 1;
      	}
      	return dp;
    }
}