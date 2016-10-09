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
    private boolean isBinaryTree = true;
    public boolean isBalanced(TreeNode root) {
        traverseTree(root);
        return isBinaryTree;
    }
    
    private int traverseTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = traverseTree(root.left);
        int rightDepth = traverseTree(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            isBinaryTree = false;
        }
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }
}
