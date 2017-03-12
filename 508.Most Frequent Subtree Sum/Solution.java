/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;

public class Solution {

	private HashMap<Integer, Integer> mp = new HashMap<>();
	private List<Integer> ans = new ArrayList<>();
    public int[] findFrequentTreeSum(TreeNode root) {
       	dfs(root);
       	int maxCount = 0;
        for (Integer value : mp.values()) {
            if (value > maxCount) maxCount = value;
        }
       	for (Map.Entry<Integer, Integer> entry : mp.entrySet()) {
       		if (entry.getValue() == maxCount) {
       			ans.add(entry.getKey());
       		}
       	}
       	int[] res = new int[ans.size()];
       	for (int i = 0; i < ans.size(); i++) {
       	    res[i] = ans.get(i);
       	}
       	return res;
    }

    private int dfs(TreeNode root) {
    	if (root == null) {
    		return 0;
    	}
    	int leftSum = dfs(root.left);
    	int rightSum = dfs(root.right);
    	int sum = leftSum + rightSum + root.val;

    	if (mp.containsKey(sum)) {
    		mp.put(sum, mp.get(sum) + 1);
    	} else {
    		mp.put(sum, 1);
    	}

    	return sum;
    }
}