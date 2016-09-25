/*
 * sum[i]表示从第0行到第i行的某些连续的列的和
 * 设需要找的矩阵的和为x, 则curSum - x >= k, 从而curSum - k >= x;
 * curSum为从第0行到当前行某些连续列的和, 可以二分查找是否存在符合的x
 */
import java.util.TreeSet;

public class Solution {

	private int[] sum;
    public int maxSumSubmatrix(int[][] matrix, int k) {
    	if (matrix == null) {
    		return 0;
    	}
    	int row = matrix.length;
    	int col = matrix[0].length;
    	int ans = Integer.MIN_VALUE;
    	for (int i = 0; i < col; i++) {
    		sum = new int[row];
    		for (int j = i; j < col; j++) {
    			int curSum = 0;
    			TreeSet<Integer> set = new TreeSet<>();
    			set.add(0);
    			for (int r = 0; r < row; r++) {
    				sum[r] += matrix[r][j];
    				curSum += sum[r];
    				Integer x = set.ceiling(curSum - k);
    				if (x != null) {
    					ans = Math.max(ans, curSum - x);
    				}
    				set.add(curSum);
    			}
    		}
    	}
    	return ans;
   }
}