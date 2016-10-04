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
    public List<Integer> rightSideView(TreeNode root) {
        res = new ArrayList<>();
       	solve(root);
       	return res;
    }

    private void solve(TreeNode pNode) {
    	if (pNode == null) {
    		return;
    	}
    	Queue<TreeNode > que = new LinkedList<>();
    	que.offer(pNode);
    	while (que.size() > 0) {
    		int size = que.size();
    		boolean flag = true;
    		while (size > 0) {
    			TreeNode node = que.poll();
    			if (flag) {
    				res.add(node.val);
    				flag = false;
    			}
    			if (node.right != null) {
    				que.offer(node.right);
    			}
    			if (node.left != null) {
    				que.offer(node.left);
    			}
    			size--;
    		}
    	}
    }
}