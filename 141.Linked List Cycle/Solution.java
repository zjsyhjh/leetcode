/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
    	if (head == null) {
    		return false;
    	}
        ListNode node1 = head, node2 = head;
        while (node2 != null) {
        	node2 = node2.next;
        	if (node1 == node2) {
        		return true;
        	}
        	if (node2 != null) {
        		node2 = node2.next;
        		if (node1 == node2) {
        			return true;
        		}
        		node1 = node1.next;
        	}
        }
        return false;
    }
}