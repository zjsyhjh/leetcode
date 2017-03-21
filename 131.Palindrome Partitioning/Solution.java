import java.util.*;

public class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(result, new ArrayList<>(), s, 0);
        return result;
    }

    private void dfs(List<List<String>> res, List<String> tmp, String s, int st) {
        if (st == s.length()) {
            res.add(new ArrayList<>(tmp));
            return;
        }
        for (int i = st; i < s.length(); i++) {
            if (isPalindrome(s, st, i)) {
                tmp.add(s.substring(st, i + 1));
                dfs(res, tmp, s, i + 1);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s, int st, int ed) {
        while (st < ed) {
            if (s.charAt(st++) != s.charAt(ed--)) {
                return false;
            }
        }
        return true;
    } 
}