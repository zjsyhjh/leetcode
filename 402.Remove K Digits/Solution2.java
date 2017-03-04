/**
 * Created by iHge2k on 2017/3/4.
 */

import java.util.*;

public class Solution2 {

    public String removeKdigits(String num, int k) {
        if (k == 0) {
            return num;
        }
        if (k >= num.length()) {
            return "0";
        }
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && ch < deque.getLast()) {
                deque.pollLast();
                k -= 1;
            }
            deque.addLast(ch);
        }
        StringBuilder str = new StringBuilder();
        while (!deque.isEmpty()) {
            str.append(deque.pollFirst());
        }

        String res = str.substring(0, str.length() - k);
        int st = 0;
        while (st < res.length() &&  res.charAt(st) == '0') {
            st += 1;
        }
        return st == res.length() ? "0" : res.substring(st);
    }
}
