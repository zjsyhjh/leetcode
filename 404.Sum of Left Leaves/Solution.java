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
    public int sumOfLeftLeaves(TreeNode root) {
		return dfs(root, false);        
    }


    private int dfs(TreeNode node, boolean fromLeft) {
    	if (node == null) {
    		return 0;
    	}
    	if (node != null && node.left == null && node.right == null) {
    		return (fromLeft ? node.val : 0);
    	}
    	return dfs(node.left, true) + dfs(node.right, false);
    }
}