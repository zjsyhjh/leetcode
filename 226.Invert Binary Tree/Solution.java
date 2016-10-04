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
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
        	return null;
        }
        TreeNode lNode = root.left;
        TreeNode rNode = root.right;
        root.left = invertTree(rNode);
        root.right = invertTree(lNode);
        return root;
    }
}