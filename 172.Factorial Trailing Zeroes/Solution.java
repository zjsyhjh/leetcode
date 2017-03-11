public class Solution {
    public int trailingZeroes(int n) {
        int num = n / 5;
        
        if (num == 0) return 0;
    
        return num + trailingZeroes(n/5);
    }
}
