/*
 * dp[i]表示包含s[i]的能匹配括号的最大长度
 * 如果s[i] == ')'
 * 1) s[i - 1] == '(', dp[i] = dp[i - 2] + 2;
 * 2) s[i - 1] == ')'
 * 		1) s[i - dp[i - 1] - 1] == '(', dp[i] = dp[i - 1] + 2 + dp[i - dp[i - 1] - 2];
 */
public class Solution {

	private int[] dp;
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
        	return 0;
        }
        dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
        	if (s.charAt(i) == ')') {
        		if (s.charAt(i - 1) == '(') {
        			if (i >= 2) {
        				dp[i] = dp[i - 2] + 2;
        			} else {
        				dp[i] = 2;
        			}
        		} else {
        			int index = i - dp[i - 1] - 1;
        			if (index >= 0 && s.charAt(index) == '(') {
        				dp[i] = dp[i - 1] + 2;
        				if (index - 1 >= 0) {
        					dp[i] += dp[index - 1];
        				}
        			}
        		}
        	}
        }
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
        	ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}