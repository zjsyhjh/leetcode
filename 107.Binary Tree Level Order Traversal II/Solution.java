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

	private LinkedList<List<Integer>> res;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	res = new LinkedList<>();
    	if (root != null) {
    	    bfs(root);
    	}
    	return res;
    }

    private void bfs(TreeNode root) {
    	Queue<TreeNode> que = new LinkedList<>();
    	que.offer(root);
    	while (que.size() > 0) {
    		int size = que.size();
    		List<Integer> l = new LinkedList<>();
    		while (size > 0) {
    			TreeNode node = que.peek();
    			que.poll();
    			l.add(node.val);
    			size--;
    			if (node.left != null) {
    				que.offer(node.left);
    			}
    			if (node.right != null) {
    				que.offer(node.right);
    			}
    		}
    		res.addFirst(l);
    	}
    }
}