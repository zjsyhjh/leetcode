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
    
    private List<String> paths;
    public List<String> binaryTreePaths(TreeNode root) {
        paths = new ArrayList<>();
        dfs(root, "");
        return paths;
    }
    private void dfs(TreeNode root, String path) {
        if (root == null) {
            return;
        }
        if(root.left == null && root.right == null) {
            paths.add(path.concat(String.valueOf(root.val)));
            return;
        }
        if (root.left != null) {
            dfs(root.left, path.concat(String.valueOf(root.val) + "->"));
        }
        if (root.right != null) {
            dfs(root.right, path.concat(String.valueOf(root.val) + "->"));
        }
    }
}