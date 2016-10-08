/*
 * dp[i]表示长度为i的合法数目，可以根据情况从dp[i - 1], dp[i - 2]推出dp[i]
 * 需要注意的是像: 010, 0, 001, 100, 301这种情况都为0
 */
public class Solution {
    
    private int[] dp;

    public int numDecodings(String s) {
        
        if (s.length() == 0 || !checkValid(s)) {
            return 0;
        }

        dp = new int[s.length()];
        dp[0] = 1;
        
        if (s.length() > 1) {
            if (s.charAt(0) == '1') {
                if (s.charAt(1) == '0') {
                    dp[1] = 1;
                } else {
                    dp[1] = 2;
                }
            } else if (s.charAt(0) == '2') {
                if (s.charAt(1) == '0' || s.charAt(1) > '6') {
                    dp[1] = 1;
                } else {
                    dp[1] = 2;
                }
            } else {
                dp[1] = 1;
            }
        }
                    
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i - 1) == '1') {
                if (s.charAt(i) == '0') {
                    dp[i] = dp[i - 2];
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            } else if (s.charAt(i - 1) == '2') {
                if (s.charAt(i) == '0') {
                    dp[i] = dp[i - 2];
                } else if (s.charAt(i) > '6') {
                    dp[i] = dp[i - 1];
                } else {
                    dp[i] = dp[i - 1] + dp[i - 2];
                }
            } else {
                dp[i] = dp[i - 1];
            }
        }
    
        return dp[s.length() - 1];
    }
    
    private boolean checkValid(String s) {
        if (s.charAt(0) == '0') {
            return false;
        }
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '0' && (s.charAt(i - 1) > '2' || s.charAt(i - 1) == '0')) {
                return false;
            }
        }
        return true;
    }
}
        
        

        

