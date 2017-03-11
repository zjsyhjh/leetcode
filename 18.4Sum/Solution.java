import java.util.*;

public class Solution {

	private List<List<Integer>> res = new ArrayList<List<Integer>>();
    public List<List<Integer>> fourSum(int[] nums, int target) {
    	Arrays.sort(nums);
    	for (int i = 0; i < nums.length - 3; i++) {
    		if (i != 0 && nums[i] == nums[i - 1]) {
    			continue;
    		}
    		for (int j = i + 1; j < nums.length -2; j++) {
    			if (j != i + 1 && nums[j] == nums[j - 1]) {
    				continue;
    			}
    			int l = j + 1, r = nums.length - 1;
    			while (l < r) {
    				int s = nums[i] + nums[j] + nums[l] + nums[r];
    				if (s == target) {
    					List<Integer> tmp = new ArrayList<>(4);
    					tmp.add(nums[i]);
    					tmp.add(nums[j]);
    					tmp.add(nums[l]);
    					tmp.add(nums[r]);
    					res.add(tmp);
    					l++;
    					r--;
    					while (l < r && nums[l] == nums[l - 1]) l++;
    					while (l < r && nums[r] == nums[r + 1]) r--;
    				} else if (s < target) {
    					l++;
    				} else {
    					r--;
    				}
    			}
    		}
    	}
    	return res;
    }
}