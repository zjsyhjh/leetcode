import java.util.*;
/*
public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || wordDict == null) {
        	return false;
        }
        for (int i = 0; i < s.length(); i++) {
        	String subStr1 = s.substring(0, s.length() - i);
        	String subStr2 = s.substring(i, s.length());
        	if (wordDict.contains(subStr1)) {
        		if (subStr1.length() == s.length()) {
        			return true;
        		}
        		String s1 = s.substring(s.length() - i, s.length());
        		if (dfs(s1, wordDict)) {
        			return true;
        		}
        	}
        	if (wordDict.contains((subStr2))) {
        		if (subStr2.length() == s.length()) {
        			return true;
        		}
        		String s2 = s.substring(0, i);
        		if (dfs(s2, wordDict)) {
        			return true;
        		}
        	}
        }
        return false;
    }

    private boolean dfs(String s, Set<String> wordDict) {
    	for (int i = 0; i < s.length(); i++) {
        	String subStr1 = s.substring(0, s.length() - i);
        	String subStr2 = s.substring(i, s.length());
        	if (wordDict.contains(subStr1)) {
        		if (subStr1.length() == s.length()) {
        			return true;
        		}
        		String s1 = s.substring(s.length() - i, s.length());
        		if (dfs(s1, wordDict)) {
        			return true;
        		}
        	}
        	if (wordDict.contains((subStr2))) {
        		if (subStr2.length() == s.length()) {
        			return true;
        		}
        		String s2 = s.substring(0, i);
        		if (dfs(s2, wordDict)) {
        			return true;
        		}
        	}
        }
        return false;
    }
}
*/

public class Solution {
	private boolean[] dp;
	public boolean wordBreak(String s, Set<String> wordDict) {
		dp = new boolean[s.length()];
		for (int i = 0; i < s.length(); i++) {
			String ss = s.substring(0, i + 1);
			if (wordDict.contains(ss)) {
				dp[i] = true;
			} else {
				for (int j = 0; j < i; j++) {
					if (dp[j] && wordDict.contains(ss.substring(j + 1, i + 1))) {
						dp[i] = true;
						break;
					}
				}
			}
		}
		return dp[s.length() - 1];
	}
}