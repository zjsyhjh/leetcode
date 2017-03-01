import java.util.Random;

public class Solution {

	public static Random rand = new Random();

    public int findKthLargest(int[] nums, int k) {
    	return findKth(nums, nums.length - k, 0, nums.length - 1); 
    }

    private int findKth(int[] nums, int pos, int st, int ed) {
    	int index = partition(nums, st, ed);
    	if (index == pos) {
    		return nums[index];
    	} else if (index < pos) {
    		return findKth(nums, pos, index + 1, ed);
    	} else {
    		return findKth(nums, pos, st, index - 1);
    	}
    }

    private int partition(int[] nums, int st, int ed) {
    	int index = rand.nextInt(ed - st + 1) + st;
    	swap(nums, st, index);
    	int pivot = nums[st];
    	while (st < ed) {
    		while (st < ed && nums[ed] >= pivot) ed--;
    		if (st < ed) {
    			nums[st] = nums[ed];
    			st++;
    		}
    		while (st < ed && nums[st] <= pivot) st++;
    		if (st < ed) {
    			nums[ed] = nums[st];
    			ed--;
    		}
    	}
    	nums[st] = pivot;
    	return st;
    }

    private void swap(int[] nums, int i, int j) {
    	int temp = nums[i];
    	nums[i] = nums[j];
    	nums[j] = temp;
    }


    public static void main(String[] args) {
    	Solution obj = new Solution();
    	int[] nums = {1, 3, 2, 4, 5, 6};
    	int num = obj.findKthLargest(nums, 3);
    	System.out.println("num = " + num);
    }
}