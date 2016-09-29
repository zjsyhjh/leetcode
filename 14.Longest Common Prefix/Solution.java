public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
        	return "";
        }
        if (strs.length == 1) {
        	return strs[0];
        }
        String str1 = strs[0];
        for (int i = 1; i < strs.length; i++) {
        	str1 = getLCM(str1, strs[i]);
        	if (str1 == "") {
        		break;
        	}
        }
        return str1;
    }

    private String getLCM(String str1, String str2) {
    	String s = "";
    	for (int i = 0; i < str1.length(); i++) {
    		if (i < str2.length() && str1.charAt(i) == str2.charAt(i)) {
    			s += str1.charAt(i);
    		} else {
    			break;
    		}
    	}
    	return s;
    }
}