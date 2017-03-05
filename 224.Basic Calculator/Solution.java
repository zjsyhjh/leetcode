/**
 * Created by iHge2k on 2017/3/5.
 */

import java.util.*;

public class Solution {

    private Stack<Integer> nums = new Stack<>();
    private Stack<Character> op = new Stack<>();

    public int calculate(String s) {
        int index = 0;
        while (index < s.length()) {
            if (s.charAt(index) == ' ') {
                index += 1;
                continue;
            }
            if (isSymbol(s.charAt(index))) {
                op.push(s.charAt(index));
                index += 1;
            } else if (s.charAt(index) == ')') {
                op.pop();
                if (!op.empty() && op.peek() != '(' && nums.size() >= 2) {
                    cal(nums.pop());
                }
                index += 1;
            } else {
                int ed = index + 1;
                while (ed < s.length() && isNum(s.charAt(ed))) {
                    ed += 1;
                }
                String str = s.substring(index, ed);
                index = ed;
                cal(Integer.parseInt(str));
            }
        }
        return nums.pop();
    }

    private void cal(int b) {
        if (!nums.empty() && !op.empty() && op.peek() != '(') {
            int a = nums.pop();
            char ch = op.pop();
            if (ch == '+') {
                nums.push(a + b);
            } else {
                nums.push(a - b);
            }
        } else {
            nums.push(b);
        }
    }

    private boolean isNum(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private boolean isSymbol(char ch) {
        if (ch == '+' || ch == '-' || ch == '(') {
            return true;
        }
        return false;
    }
}
