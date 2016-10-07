public class Solution {
    public double myPow(double x, int n) {
    	if (x == 0) {
    		return 0;
    	}
        if (n < 0) {
        	return getPow(1 / x, n);
        }
        return getPow(x, n);
    }

    private double getPow(double x, int n) {
    	if (n == 0) {
    		return 1.0;
    	}
    	double y = getPow(x, n / 2);
    	if (n % 2 == 0) {
    		return y * y;
    	}
    	return y * y * x;
    }
}