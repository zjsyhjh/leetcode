import java.util.*;

public class Solution {
	private Set<Integer> set;
    public boolean containsDuplicate(int[] nums) {
      	if (nums == null || nums.length == 0 || nums.length == 1) {
      		return false;
      	}
      	set = new HashSet<>(nums.length + nums.length / 2);
      	for (int num : nums) {
      		if (set.contains(num)) {
      			return true;
      		}
      		set.add(num);
      	}
      	return false;
    }
}