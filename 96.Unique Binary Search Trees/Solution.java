/*
 * dp[i]表示i个节点构成的BST的数目
 * i个节点的BST的构成方法有左子树0个节点，右子树i - 1个节点；左子树1个节点，右子树i - 2个节点
 * 以此类推
 * dp[0] = dp[1] = 1, dp[2] = 2;
 * dp[i] = (dp[0] * dp[i - 1]) + (dp[1] * dp[i - 2]) + ... + (dp[i - 1] * dp[0]);
 */ 
public class Solution {

    private int[] dp;

    public int numTrees(int n) {
        dp = new int[n + 1];
        return dfs(n);
    }

    private int dfs(int n) {
        if (n == 0 || n == 1) {
            return dp[n] = 1;
        }
        if (dp[n] != 0) {
            return dp[n];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += dfs(i) * dfs(n - i - 1);
        }
        return dp[n] = ans;
    }
}
            
        

