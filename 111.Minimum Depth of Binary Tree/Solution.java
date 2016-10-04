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
	private int res;
    public int minDepth(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	res = Integer.MAX_VALUE;
    	dfs(root, 1);
    	return res;
    }

    private void dfs(TreeNode pNode, int curDepth) {
    	if (pNode.left == null && pNode.right == null) {
    		res = Math.min(curDepth, res);
    	}
    	if (pNode.left != null) {
    		dfs(pNode.left, curDepth + 1);
    	}
    	if (pNode.right != null) {
    		dfs(pNode.right, curDepth + 1);
    	}
    }
}