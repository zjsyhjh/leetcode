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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
        	return null;
        }
        while (true) {
        	if (root.val > Math.max(p.val, q.val)) {
        		root = root.left;
        	} else if (root.val < Math.min(p.val, q.val)) {
        		root = root.right;
        	} else {
        		return root;
        	}
        }
    }
}