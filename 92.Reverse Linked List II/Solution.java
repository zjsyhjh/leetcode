/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n) {
            return head;
        }
        ListNode newHead = new ListNode(-1);
        newHead.next = head;
    	ListNode st = newHead;
        for (int i = 1; i <= m - 1; i++) {
        	st = st.next;
        }
        ListNode ed = st.next;
        for (int i = m; i < n; i++) {
        	ed = ed.next;
        }
        if (m == 1) {
            head = ed;
        }
        ed = ed.next;
       	ListNode p = dfs(m, st.next, st, ed);
       	p.next = ed;
       	return head;
    }


    private ListNode dfs(int m, ListNode p, ListNode st, ListNode ed) {
    	if (p.next == ed) {
    		if (m != 1) {
    		    st.next = p;
    		}
    		return p;
    	}
    	ListNode q = dfs(m, p.next, st, ed);
    	q.next = p;
    	return p;
    }
}