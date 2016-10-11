/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
        	return null;
        }
        if (head.next == null) {
        	return new TreeNode(head.val);
        }
        ListNode midNode = getMidNode(head);
        TreeNode root = new TreeNode(midNode.val);
        root.left = sortedListToBST(head);
        root.right = sortedListToBST(midNode.next);
        return root;
    }

    private ListNode getMidNode(ListNode head) {
    	ListNode slow = head;
    	ListNode fast = head;
    	ListNode pre = null;
    	while (fast != null) {
    	    fast = fast.next;
    	    if (fast != null) {
    	        pre = slow;
    	        slow = slow.next;
    	        fast = fast.next;
    	    }
    	}
    	pre.next = null;
    	return slow;
    }
}