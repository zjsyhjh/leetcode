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
    public List<Integer> postorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        solve(root);
        return res;
    }

    private void solve(TreeNode p) {
        Stack<WrapperNode> s = new Stack<>();
        while (p != null || !s.empty()) {
            while (p != null) {
                WrapperNode node = new WrapperNode(p, false);
                s.push(node);
                p = p.left;
            }
            if (!s.isEmpty()) {
                WrapperNode node = s.pop();
                if (node.isSecondTraversal) {
                    res.add(node.node.val);
                    p = null;
                } else {
                    node.isSecondTraversal = true;
                    s.push(node);
                    p = node.node.right;
                }
            }
        }
    }

    class WrapperNode {
        public TreeNode node;
        public boolean isSecondTraversal;
        public WrapperNode(TreeNode node, boolean isSecondTraversal) {
            this.node = node;
            this.isSecondTraversal = isSecondTraversal;
        }
    }
}