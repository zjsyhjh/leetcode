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
	private List<Integer> res;
    public List<Integer> preorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        dfs(root);
        return res;
    }

    private void dfs(TreeNode root) {
    	if (root == null) {
    		return;
    	}
    	res.add(root.val);
    	dfs(root.left);
    	dfs(root.right);
    }
}