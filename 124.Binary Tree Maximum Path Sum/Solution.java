/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        dfs(root);
        return maxSum;
    }

    private int dfs(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	int leftSum = dfs(root.left);
    	int rightSum = dfs(root.right);
    	int sum = root.val;
    	if (leftSum > 0) {
    		sum += leftSum;
    	}
    	if (rightSum > 0) {
    		sum += rightSum;
    	}
    	maxSum = Math.max(maxSum, sum);
    	return Math.max(root.val, Math.max(root.val + leftSum, root.val + rightSum));
    }
}