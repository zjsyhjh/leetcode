/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode midNode = getMidNode(head);
        ListNode nextNode = midNode.next;
        midNode.next = null;
        ListNode l = sortList(head);
        ListNode r = sortList(nextNode);
        return mergeSort(l, r);
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

    private ListNode mergeSort(ListNode l, ListNode r) {
    	ListNode vhead = new ListNode(0);
    	ListNode cur = vhead;
    	while (l != null && r != null) {
    		if (l.val <= r.val) {
    			cur.next = l;
    			l = l.next;
    		} else {
    			cur.next = r;
    			r = r.next;
    		}
    		cur = cur.next;
    	}
    	if (l == null) {
    		cur.next = r;
    	} else {
    		cur.next = l;
    	}
    	return vhead.next;
    }
}