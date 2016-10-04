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

	private List<Integer> nums;
    public int kthSmallest(TreeNode root, int k) {
        nums = new ArrayList<>();
        inorder(root);
        return nums.get(k - 1);
    }

    private void inorder(TreeNode root) {
    	if (root == null) {
    		return;
    	}
    	inorder(root.left);
    	nums.add(root.val);
    	inorder(root.right);
    }
}