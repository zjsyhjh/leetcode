/**
 * Created by iHge2k on 2017/3/6.
 */

import java.util.*;

public class Solution {

    private Stack<String > stack = new Stack<>();
    public String decodeString(String s) {
        String tmp = "";
        int index = 0;
        while (index < s.length()) {
            if (isNum(s.charAt(index))) {
                int n = 0;
                while (index < s.length() && isNum(s.charAt(index))) {
                    n *= 10;
                    n += s.charAt(index) - '0';
                    index += 1;
                }
                stack.push(Integer.toString(n));
            } else if (isChar(s.charAt(index))) {
                tmp = "";
                while (index < s.length() && isChar(s.charAt(index))) {
                    tmp += Character.toString(s.charAt(index));
                    index += 1;
                }
                stack.push(tmp);
            } else if (s.charAt(index) == '[') {
                stack.push("[");
                index += 1;
            } else {
                StringBuilder res = new StringBuilder();
                while (!stack.peek().equals("[")) {
                    String ss = stack.pop();
                    res.insert(0, ss);
                }
                stack.pop();
                String str = res.toString();
                if (!stack.empty() && isNum(stack.peek().charAt(0))) {
                    int count = Integer.parseInt(stack.pop());
                    for (int i = 0; i < count - 1; i++) {
                        res.append(str);
                    }
                }
                str = res.toString();
                stack.push(str);
                index += 1;
            }
        }
        String ans = "";
        while (!stack.empty()) {
            tmp = stack.pop();
            tmp += ans;
            ans = tmp;
        }
        return ans;
    }

    private boolean isNum(char ch) {
        return ch >= '0' && ch <= '9';
    }

    private boolean isChar(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z');
    }
}