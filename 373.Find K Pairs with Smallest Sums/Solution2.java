import java.util.*;



public class Solution2 {
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
    	List<int[]> pairs = new ArrayList<>();
        if (!check(nums1, nums2)) {
        	return pairs;
        }
        k = Math.min(k, nums1.length * nums2.length);
        Queue<int[]> que = new PriorityQueue<>(k, new Comparator<int[]>() {
        	public int compare(int[] o1, int[] o2) {
        		return (nums1[o1[0]] + nums2[o1[1]] - (nums1[o2[0]] + nums2[o2[1]]));
        	}
    	});

    	for (int i = 0; i < nums1.length && i < k; i++) {
    		que.offer(new int[]{i, 0});
    	}

    	while (!que.isEmpty() && k > 0) {
    		int[] index = que.poll();
    		pairs.add(new int[]{nums1[index[0]], nums2[index[1]]});
    		k -= 1;

    		if (index[1] + 1 < nums2.length) {
    			que.offer(new int[]{index[0], index[1] + 1});
    		}
    	}

    	return pairs;
    }

    private boolean check(int[] nums1, int[] nums2) {
    	if (nums1 == null || nums2 == null) {
    		return false;
    	}
    	if (nums1.length == 0 || nums2.length == 0) {
    		return false;
    	}
    	return true;
    }
 }  