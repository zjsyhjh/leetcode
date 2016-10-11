/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root != null) {
        	solve(root);
        }
    }

    private void solve(TreeLinkNode pNode) {
    	Queue<TreeLinkNode> que = new LinkedList<>();
    	que.offer(pNode);
    	while (que.size() > 0) {
    		int size = que.size();
    		TreeLinkNode pre = null;
    		while (size > 0) {
    			TreeLinkNode node = que.poll();
    			if (node != null) {
    				node.next = pre;
    				que.offer(node.right);
    				que.offer(node.left);
    			}
    			pre = node;
    			size--;
    		}
    	}
    }
}