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
        if (root != null) {
            solve(root);
        }
        return res;
    }

    private void solve(TreeNode root) {
        Stack<WrapperNode> s = new Stack<>();
        s.push(new WrapperNode(root, false));
        while (!s.empty()) {
            WrapperNode wrapperNode = s.peek();
            while (wrapperNode.node.left != null) {
                s.push(new WrapperNode(wrapperNode.node.left, false));
            }
            wrapperNode = s.peek();
            while (wrapperNode.node != null) {
                if (wrapperNode.isSecondTraversal) {
                    res.add(s.pop().node.val);
                    if (s.isEmpty()) {
                        break;
                    }
                    wrapperNode = s.peek();
                } else {
                    wrapperNode.isSecondTraversal = true;
                    s.push(new WrapperNode(wrapperNode.node.right, false));
                    break;
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