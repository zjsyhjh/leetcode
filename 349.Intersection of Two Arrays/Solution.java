import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


public class Solution {

	private Set<Integer> set;
	private List<Integer> array;
    public int[] intersection(int[] nums1, int[] nums2) {    
    	set = new HashSet<>();
    	array = new ArrayList<>();
    	for (int num : nums1) {
    		set.add(num);
    	}
    	for (int num : nums2) {
    		if (set.contains(num)) {
    			array.add(num);
    			set.remove(num);
    		}
    	}
    	int[] result = new int[array.size()];
    	for (int i = 0; i < array.size(); i++) {
    		result[i] = array.get(i);
    	}
    	return result;
    }
}