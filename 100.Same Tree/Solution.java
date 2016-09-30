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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (isSame(p, q)) {
            if (p != null) {
                if (!isSameTree(p.left, q.left)) {
                    return false;
                }
                if (!isSameTree(p.right, q.right)) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }
    private boolean isSame(TreeNode p, TreeNode q) {
        if (p == null && q != null) {
            return false;
        }
        if (p != null && q == null) {
            return false;
        }
        if (p == null && q == null) {
            return true;
        }
        if (p.val == q.val) {
            return true;
        }
        return false;
    }
}