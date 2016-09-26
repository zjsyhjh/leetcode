public class Solution {

	private int[] result;
    public int removeDuplicates(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
    	result = new int[nums.length]; 
    	int count = 1;
    	result[0] = nums[0];
    	int l = 1;
    	for (int i = 1; i < nums.length; i++) {
    		if (nums[i] == nums[i - 1]) {
    			count++;
    			if (count > 2) {
    				continue;
    			}
    			result[l++] = nums[i]; 
    		} else {
    			result[l++] = nums[i];
    			count = 1;
    		}
    	}
    	/*
    	for (int i = 0; i < l; i++) {
    		nums[i] = result[i];
    	}*/
    	System.arraycopy(result, 0, nums, 0, l);
    	return l;
    }
}