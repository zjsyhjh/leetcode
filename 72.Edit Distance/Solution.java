public class Solution {

	private int[][] dp;
    public int minDistance(String word1, String word2) {
    	if (word1 == null) {
    		return (word2 == null ? 0 : word2.length());
    	}
    	if (word2 == null) {
    		return (word1 == null ? 0 : word1.length());
    	}

    	dp = new int[word1.length() + 1][word2.length() + 1];
    	for (int i = 0; i <= word1.length(); i++) {
    		dp[i][0] = i;
    	}
    	for (int j = 0; j <= word2.length(); j++) {
    		dp[0][j] = j;
    	}

    	for (int i = 1; i <= word1.length(); i++) {
    		for (int j = 1; j <= word2.length(); j++) {
    			if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
    				dp[i][j] = dp[i - 1][j - 1];
    			} else {
    				dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
    			}
    		}
    	}
    	return dp[word1.length()][word2.length()];
    }
}