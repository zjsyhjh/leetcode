/*
 * dp[i][j]表示s[0...i-1]与p[0...j-1]能够匹配
 * 如果p[j-1]=='.'或者s[i-1]==p[j-1],则dp[i][j] = dp[i - 1][j - 1];
 * 否则如果p[j-1]=='*', 则
 * 1) p[j-1]等于0个p[j-2], 即p[j-2]*为空, dp[i][j] = dp[i][j-2];
 * 2) p[j-1]等于1个p[j-2], dp[i][j] = dp[i][j - 1] && (s[i - 1] == p[j - 2])
 * 3) p[j-1]等于多个p[j-2], dp[i][j] = dp[i - 1][j] && (s[i - 1] == p[j - 2])
 */
public class Solution {

	private boolean[][] dp;
	public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        dp = new boolean[n + 1][m + 1];

        dp[0][0] = true;
        for (int i = 1; i < m && p.charAt(i) == '*'; i += 2) {
        	dp[0][i + 1] = true;
        }

        for (int i = 1; i <= n; i++) {
        	for (int j = 1; j <= m; j++) {
        		if (p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1)) {
        			dp[i][j] = dp[i - 1][j - 1];
        		} else if (j > 1 && p.charAt(j - 1) == '*') {
        			dp[i][j] = dp[i][j - 2] || (dp[i - 1][j] && (s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.'));
        		}
        	}
        }
        return dp[n][m];
    }
}