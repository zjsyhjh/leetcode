import java.util.*;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
    	if (nums == null || nums.length == 0) {
    		return false;
    	}
    	if (k <= 0) {
    		return false;
    	}
    	List<Num > l = new ArrayList<>();
    	for (int i = 0; i < nums.length; i++) {
    		l.add(new Num(nums[i], i));
    	}
    	Collections.sort(l, new NumComparator());
    	/*
    	for (Num num : l) {
    	    System.out.println(num.num + " " + num.index);
    	}*/
    	for (int i = 1; i < l.size(); i++) {
    		if (l.get(i).num == l.get(i-1).num && l.get(i).index - l.get(i-1).index <= k) {
    			return true;
    		}
    	}
    	return false;
    }
    class Num {
    	public int num;
    	public int index;
    	public Num(int num, int index) {
    		this.num = num;
    		this.index = index;
    	}
    }
   	class NumComparator implements Comparator<Num> {
   		public int compare(Num num1, Num num2) {
   			if (num1.num != num2.num) {
   				return num1.num - num2.num;
   			}
   			return num1.index - num2.index;
   		}
   	}
}