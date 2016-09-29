public class Solution {
	private String[] res;
    public String convert(String s, int numRows) {
        if (numRows == 1) {
        	return s;
        }
        res = new String[numRows];
        for (int i = 0; i < numRows; i++) {
        	res[i] = "";
        }
        boolean flag = false;
        int index = 0;
       	for (char ch : s.toCharArray()) {
       		res[index] += ch;
       		if (index == numRows - 1 || index == 0) {
       			flag = !flag;
       		}
       		if (flag) {
       			index++;
       		} else {
       			index--;
       		}
       	}
       	String ans = "";
       	for (String ss : res) {
       		ans += ss;
       	}
       	return ans;
    }
}