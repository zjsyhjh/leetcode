public class Solution {

	private int[] res;
    public int removeDuplicates(int[] nums) {
    	if (nums == null || nums.length == 0) {
    		return 0;
    	}
		res = new int[nums.length];
		res[0] = nums[0];
		int l = 1;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] == nums[i - 1]) {
				continue;
			}
			res[l++] = nums[i];
		}
		System.arraycopy(res, 0, nums, 0, l);
		return l;
    }
}