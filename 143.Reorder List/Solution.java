/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
        	return;
        }
        ListNode midNode = getMidNode(head);
        ListNode head1 = head;
        ListNode head2 = midNode.next;
        midNode.next = null;

        head2 = reverseList(head2);

       	while (head1 != null && head2 != null) {
       		ListNode cur1 = head1.next;
       		head1.next = head2;
       		ListNode cur2 = head2.next;
       		head2.next = cur1;
       		head1 = cur1;
       		head2 = cur2;
       	}
       	head = head1;
    }

    private ListNode reverseList(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	ListNode pre = head;
    	ListNode cur = head.next;
    	pre.next = null;
    	while (cur != null) {
    		ListNode next = cur.next;
    		cur.next = pre;
    		pre = cur;
    		cur = next;
    	}
    	return pre;
    }

    private ListNode getMidNode(ListNode head) {
    	ListNode slow = head;
    	ListNode fast = head;
    	while (fast.next != null && fast.next.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	return slow;
    }
}