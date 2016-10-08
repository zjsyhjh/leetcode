public class Solution {
    public void wiggleSort(int[] nums) {
    	if (nums == null || nums.length == 1) {
    		return;
    	}
		Arrays.sort(nums);
		int len = nums.length;
		int left = (len - 1) >> 1;
		int right = (len - 1);
		int[] tmp = new int[len];
		for (int i = 0; i < len; i++) {
			if ((i & 1) == 0) {
				tmp[i] = nums[left];
				left--;
			} else {
				tmp[i] = nums[right];
				right--;
			}
		}
		System.arraycopy(tmp, 0, nums, 0, len);
    }
}