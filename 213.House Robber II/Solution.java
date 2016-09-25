/*
 * dp1表示取了第一个的最大收益
 * dp2表示没有取第一个的最大收益
 */
public class Solution {

    private int[] dp1;
    private int[] dp2;
    private int ans;

    public int rob(int[] nums) {
        dp1 = new int[nums.length];
        dp2 = new int[nums.length];
        ans = 0;
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        dp1[1] = dp1[0] = nums[0];
        dp2[1] = nums[1];

        for (int i = 2; i < nums.length - 1; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
            ans = Math.max(ans, dp1[i]);
            ans = Math.max(ans, dp2[i]);
        }
        dp1[nums.length - 1] = dp1[nums.length - 2];
        dp2[nums.length - 1] = Math.max(dp2[nums.length - 2], dp2[nums.length - 3] + nums[nums.length - 1]);
        ans = Math.max(ans, dp1[nums.length - 1]);
        ans = Math.max(ans, dp2[nums.length - 1]);

        return ans;
    }
}
        
