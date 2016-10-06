/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p1 = head;
        ListNode p2 = head;
        for (int i = 1; i <= n; i++) {
        	p1 = p1.next;
        }
        if (p1 == null) {
        	head = head.next;
        } else {
        	while (p1.next != null) {
        		p1 = p1.next;
        		p2 = p2.next;
        	}
        	p2.next = p2.next.next;
        }
        return head;
    }
}