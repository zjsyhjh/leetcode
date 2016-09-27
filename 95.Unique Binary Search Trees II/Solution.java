/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {

    public List<TreeNode> generateTrees(int n) {

    	if (n == 0) {
    		return new ArrayList<>();
    	}

    	return dfs(1, n);
    }

    private List<TreeNode> dfs(int st, int ed) {

    	List<TreeNode > tree = new ArrayList<>();

    	if (st > ed) {
    		tree.add(null);
    		return tree;
    	}

    	for (int mid = st; mid <= ed; mid++) {
    		List<TreeNode > ltree = dfs(st, mid - 1);
    		List<TreeNode > rtree = dfs(mid + 1, ed);

    		for (TreeNode lnode : ltree) {
    			for (TreeNode rnode : rtree) {
    				TreeNode rt = new TreeNode(mid);
    				rt.left = lnode;
    				rt.right = rnode;
    				tree.add(rt);
    			}
    		}
    	}

    	return tree;
    }

}