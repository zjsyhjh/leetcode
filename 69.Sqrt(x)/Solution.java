public class Solution {
    public int mySqrt(int x) {
        if (x == 0) {
        	return 0;
        }
        return binarySerach(1, x / 2 + 1, x);
    }

    private int binarySerach(int low, int high, int target) {
    	while (low <= high) {
    		int mid = (low + high) >> 1;
    		if (mid > target / mid) {
    			high = mid - 1;
    		} else if (mid < target / mid) {
    			low = mid + 1;
    		} else {
    			return mid;
    		}
    	}
    	return low - 1;
    }
}