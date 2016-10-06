public class Solution {
    public int removeElement(int[] nums, int val) {
        int indexIsVal = 0, indexIsNotVal = 0;
        while (indexIsVal < nums.length && indexIsNotVal < nums.length) {
        	while (indexIsVal < nums.length && nums[indexIsVal] != val) {
        		indexIsVal++;
        	}
        	while (indexIsNotVal < nums.length && nums[indexIsNotVal] == val) {
        		indexIsNotVal++;
        	}
        	if (indexIsVal < nums.length && indexIsNotVal < nums.length && indexIsVal < indexIsNotVal) {
        		int tmp = nums[indexIsVal];
        		nums[indexIsVal] = nums[indexIsNotVal];
        		nums[indexIsNotVal] = tmp;
        		indexIsVal++;
        		indexIsNotVal++;
        	} else {
        		indexIsNotVal++;
        	}
        }
        int count = 0;
       	indexIsNotVal = 0;
       	while (indexIsNotVal < nums.length && nums[indexIsNotVal] != val) {
       		indexIsNotVal++;
       		count++;
       	}
       	return count;
    }
}