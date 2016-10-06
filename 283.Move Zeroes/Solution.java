public class Solution {
    public void moveZeroes(int[] nums) {
        int index_zero = 0, index_nozero = 0;
        while (index_nozero < nums.length) {
        	while (index_nozero < nums.length && nums[index_nozero] == 0) {
        		index_nozero++;
        	}
        	while (index_zero < nums.length && nums[index_zero] != 0) {
        		index_zero++;
        	}
        	if (index_nozero < nums.length && index_zero < nums.length && index_zero < index_nozero) {
        		int tmp = nums[index_zero];
        		nums[index_zero] = nums[index_nozero];
        		nums[index_nozero] = tmp;
        		index_nozero++;
        		index_zero++;
        	} else {
        		index_nozero++;
        	}
        }
    }
}