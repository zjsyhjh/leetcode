/*
 * dpMin[i]表示结尾为i的子数组的乘积的最小值
 * dpMax[i]表示结尾为i的子数组的乘积的最大值
 * dpMin[i] = min(dpMin[i - 1] * nums[i], nums[i], dpMax[i - 1] * nums[i]);
 * dpMax[i] = max(dpMax[i - 1] * nums[i], nums[i], dpMin[i - 1] * nums[i]);
 */
public class Solution {

	private int[] dpMin;
	private int[] dpMax;
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return 0;
        }
        dpMin = new int[nums.length];
        dpMax = new int[nums.length];

        dpMin[0] = dpMax[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
        	dpMin[i] = Math.min(dpMin[i - 1] * nums[i], nums[i]);
        	dpMin[i] = Math.min(dpMin[i], dpMax[i - 1] * nums[i]);
        	dpMax[i] = Math.max(dpMax[i - 1] * nums[i], nums[i]);
        	dpMax[i] = Math.max(dpMax[i], dpMin[i - 1] * nums[i]);
        }

        int ans = dpMax[0];
        for (int i = 1; i < nums.length; i++) {
        	ans = Math.max(ans, dpMax[i]);
        }
        return ans;
    }
}