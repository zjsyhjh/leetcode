public class Solution {

	private HashMap<Integer, Integer> mp =  new HashMap<>();
    public boolean checkSubarraySum(int[] nums, int k) {
    	mp.put(0, -1);
    	int sum = 0;
    	for (int i = 0; i < nums.length; i++) {
    		sum += nums[i];
    		if (k != 0) {
    			sum %= k;
    		}
    		Integer index = mp.get(sum);
    		if (index != null) {
    			if (i - index > 1) return true;
    		} else {
    			mp.put(sum, i);
    		}
    	}
    	return false;
    }
}