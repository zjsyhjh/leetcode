/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
public class Solution {

	private List<List<Integer>> result;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        List<Integer> l = new ArrayList<Integer>();
        dfs(root, sum, l);
        return result;
    }

    private void dfs(TreeNode root, int sum, List<Integer> l) {
        if (root == null) {
            return;
        }
    	if (root.left == null && root.right == null) {
    		if (sum == root.val) {
    			l.add(root.val);
    			result.add(new ArrayList(l));
    			l.remove(l.size() - 1);
    		}
    		return;
    	}
    	if (root.left != null) {
    		l.add(root.val);
    		dfs(root.left, sum - root.val, l);
    		l.remove(l.size() - 1);
    	}
    	if (root.right != null) {
    		l.add(root.val);
    		dfs(root.right, sum - root.val, l);
    		l.remove(l.size() - 1);
    	}
    }
}