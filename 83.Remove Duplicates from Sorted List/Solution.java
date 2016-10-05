/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
        	if (cur.val == pre.val) {
        		cur = cur.next;
        	} else {
        		pre.next = cur;
        		pre = cur;
        		cur = cur.next;
        	}
        }
        pre.next = cur;
        return head;
    }
}