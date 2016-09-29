public class Solution {

	private void rotate(int[] nums, int st, int ed) {
		while (st < ed) {
			int tmp = nums[st];
			nums[st++] = nums[ed];
			nums[ed--] = tmp;
		}
	}

    public void rotate(int[] nums, int k) {
        if (nums.length == 0) {
        	return;
        }
        k %= nums.length;
        rotate(nums, 0, nums.length - 1);
        rotate(nums, 0, k - 1);
        rotate(nums, k, nums.length - 1);
    }
}