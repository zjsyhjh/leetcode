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
    public int sumNumbers(TreeNode root) {
        return dfs(root, "");
    }
    
    private int dfs(TreeNode root, String path) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return Integer.valueOf(path.concat(String.valueOf(root.val)));
        }
        return dfs(root.left, path.concat(String.valueOf(root.val))) + dfs(root.right, path.concat(String.valueOf(root.val)));
    }
}