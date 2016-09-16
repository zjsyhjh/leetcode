public class Solution {

    public String reverseString(String s) {
        char[] ch = s.toCharArray();
        for (int i = 0; i < ch.length / 2; i++) {
            char tmp = ch[i];
            ch[i] = ch[ch.length - i - 1];
            ch[ch.length - i - 1] = tmp;
        }
        return new String(ch);
    }
}
        
