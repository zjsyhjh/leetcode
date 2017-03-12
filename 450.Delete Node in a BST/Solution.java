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

    public TreeNode deleteNode(TreeNode root, int key) {
		if (root == null) {
			return null;
		}

		if (key < root.val) {
			root.left = deleteNode(root.left, key);
		} else if (key > root.val) {
			root.right = deleteNode(root.right, key);
		} else {
			if (root.left == null) {
				return root.right;
			}
			if (root.right == null) {
				return root.left;
			}
			root.val = findReplaceNode(root, root.left, true);
		}
		return root;
    }

    private int findReplaceNode(TreeNode pre, TreeNode cur, boolean isLeft) {
    	if (cur.right == null) {
    		if (isLeft) {
    			pre.left = cur.left;
    		} else {
    			pre.right = cur.left;
    		}
    		return cur.val;
    	}
    	return findReplaceNode(cur, cur.right, false);
    }
}