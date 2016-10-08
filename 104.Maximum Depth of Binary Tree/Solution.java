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
    private int maxdepth = 0;
    public int maxDepth(TreeNode root) {
        traverseTree(root, 1);
        return maxdepth;
    }

    private void traverseTree(TreeNode root, int depth) {

        if (root != null && root.left == null && root.right == null) {
            maxdepth = (depth > maxdepth ? depth : maxdepth);
            return;
        }

        if (root != null) {
            traverseTree(root.left, depth + 1);
            traverseTree(root.right, depth + 1);
        }
    }
}
