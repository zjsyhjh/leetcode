public class Solution {
    public String removeKdigits(String num, int k) {
    	if (num.length() == k) {
    		return "0";
    	}
        ArrayList<Character> l = new ArrayList<>();
        int n = k;
        for (int i = 0; i < num.length(); i++) {
        	char ch = num.charAt(i);
        	while (l.size() > 0 && n > 0  && ch < l.get(l.size() - 1)) {
        		l.remove(l.size() - 1);
        		n--;
        	}
        	l.add(ch);
        }
        StringBuilder str = new StringBuilder();
        for (char ch : l) {
        	str.append(ch);
        }
        String res = str.substring(0, num.length() - k);
        int index = 0;
        while (index < res.length() && res.charAt(index) == '0') {
        	index++;
        }
        if (index >= res.length()) {
        	return "0";
        }
        return res.substring(index);
    }
}