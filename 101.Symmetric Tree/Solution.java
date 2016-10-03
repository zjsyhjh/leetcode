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
    public boolean isSymmetric(TreeNode root) {
    	if (root == null) {
    		return true;
    	}
    	return isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode lNode, TreeNode rNode) {
    	if (lNode == null && rNode == null) {
    		return true;
    	}
    	if (lNode == null || rNode == null) {
    		return false;
    	}
    	if (lNode.val == rNode.val) {
    		return isSymmetric(lNode.left, rNode.right) && isSymmetric(lNode.right, rNode.left);
    	}
    	return false;
    }
}