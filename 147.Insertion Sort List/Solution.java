/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode cur = head.next;
        head.next = null;
        while (cur != null) {
      		ListNode q = head;
      		ListNode pre = null;
      		while (q != null && q.val < cur.val) {
      			pre = q;
      			q = q.next;
      		}
      		if (q == null) {
      			pre.next = cur;
      			cur = cur.next;
      			pre.next.next = null;
      		} else {
      		    if (pre == null) {
      		        ListNode node = cur;
      		        cur = cur.next;
      		        node.next = head;
      		        head = node;
      		    } else {
      		        ListNode node = cur;
      		        cur = cur.next;
      		        node.next = q;
      		        pre.next = node;
      		    }
      		}
        }
        return head;
    }
}