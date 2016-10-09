/*
 * dp[i][j]表示到达(i,j)时的最小值，dp[i][j] = min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
 */
public class Solution {

    private int[][] dp;

    public int minPathSum(int[][] grid) {
        
        if (grid.length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        dp = new int[m][n];

        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}

        
