public class Solution {

    public String smallestGoodBase(String n) {
    	long num = Long.parseLong(n);
    	for (int len = Math.min((int)Math.pow(num, 0.5), 64); len >= 2; len--) {
    		long base = (long) Math.pow(num, 1.0 / len);
    		if (isBase(num, base, len)) return String.valueOf(base);
    	}
    	return String.valueOf(num - 1);
    }

    private boolean isBase(long s, long base, int len) {
    	long val = 1;
    	for (int i = 0; i <= len; i++) {
    		s -= val;
    		val *= base;
    	}
    	return s == 0;
    }


}