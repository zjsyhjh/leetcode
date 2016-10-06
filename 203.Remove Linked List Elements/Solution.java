/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
    	if (head == null) {
    		return null;
    	}
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
        	while (cur != null && cur.val != val) {
        		pre = cur;
        		cur = cur.next;
        	}
        	if (cur != null) {
        		if (pre == null) {
        			ListNode p = head;
        			head = cur.next;
        			p = null;
        			pre = null;
        			cur = cur.next;
        		} else {
        			pre.next = cur.next;
        			ListNode p = cur;
        			cur = cur.next;
        			p = null;
        		}
        	}
        }
        return head;
    }
}