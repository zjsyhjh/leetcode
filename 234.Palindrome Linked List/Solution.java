/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
    	if (head == null || head.next == null) {
    		return true;
    	}
    	ListNode midNode = getMidNode(head);
    	ListNode head1 = head;
    	ListNode head2 = reverseList(midNode);
    	while (head1 != null && head2 != null) {
    		if (head1.val != head2.val) {
    			return false;
    		}
    		head1 = head1.next;
    		head2 = head2.next;
    	}
    	return true;
    }
    private ListNode getMidNode(ListNode head) {
    	ListNode slow = head;
    	ListNode fast = head;
    	while (fast.next != null && fast.next.next != null) {
    		fast = fast.next.next;
    		slow = slow.next;
    	}
    	return slow;
    }
    private ListNode reverseList(ListNode head) {
    	if (head == null || head.next == null) {
    		return head;
    	}
    	ListNode p = reverseList(head.next);
    	head.next.next = head;
    	head.next = null;
    	return p;
    }
}