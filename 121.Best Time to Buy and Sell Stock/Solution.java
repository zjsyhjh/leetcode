/*
 * dp1[i]记录从0-i之间的最小值
 * dp2[i]记录从i-nums.length的最大值
 */
public class Solution {
   
    private int[] dp1;
    private int[] dp2;

    public int maxProfit(int[] prices) {

        dp1 = new int[prices.length];
        dp2 = new int[prices.length];
        if (prices.length > 0) {
            dp1[0] = prices[0];
            dp2[prices.length - 1] = prices[prices.length - 1];
        }
        
        for (int i = 1; i < dp1.length; i++) {
            dp1[i] = Math.min(dp1[i - 1], prices[i]);
        }
        
        for (int i = dp2.length - 2; i >= 0; i--) {
            dp2[i] = Math.max(dp2[i + 1], prices[i]);
        }
        
        int ans = 0;
        for (int i = 0; i < prices.length; i++) {
            ans = Math.max(ans, dp2[i] - dp1[i]);
        }

        return ans;
    }
}
            
            
            

