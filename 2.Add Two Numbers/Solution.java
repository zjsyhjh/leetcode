/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	ListNode vhead = new ListNode(-1);
    	ListNode cur = vhead;
    	int flag = 0;
    	while (l1 != null && l2 != null) {
    		int val = l1.val + l2.val;
    		ListNode node = new ListNode((val + flag) % 10);
    		cur.next = node;
    		cur = cur.next;
    		flag = (val + flag) / 10;
    		l1 = l1.next;
    		l2 = l2.next;
    	}
    	while (l1 != null) {
    		ListNode node = new ListNode((l1.val + flag) % 10);
    		cur.next = node;
    		cur = cur.next;
    		flag = (l1.val + flag) / 10;
    		l1 = l1.next;
    	}
    	while (l2 != null) {
    		ListNode node = new ListNode((l2.val + flag) % 10);
    		cur.next = node;
    		cur = cur.next;
    		flag = (l2.val + flag) / 10;
    		l2 = l2.next;
    	}
    	if (flag == 1) {
    		ListNode node = new ListNode(1);
    		cur.next = node;
    	}
    	return vhead.next;
    }
}