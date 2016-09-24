/*
 * dp[i][j]表示通过跳j步到位置i
 */
import java.util.Arrays;

public class Solution {

	private boolean[][] dp;
    public boolean canCross(int[] stones) {
    	dp = new boolean[stones.length + 1][stones.length + 1];
    	dp[0][0] = true;
    	return dfs(stones, 0, 1);
    }

   	private boolean dfs(int[] stones, int pos, int units) {
   		int nextPos = find(stones, stones[pos] + units);
   		if (nextPos == -1 || dp[nextPos][units]) {
   			return false;
   		}
   		if (nextPos == stones.length - 1) {
   		    return true;
   		}
   		dp[nextPos][units] = true;
   		int[] offsets = {-1, 0, 1};
   		for (int offset : offsets) {
   			if (units + offset >= 0) {
   				if (dfs(stones, nextPos, units + offset)) {
   					return true;
   				}
   			}
   		}
   		return false;
   	}

   	private int find(int[] stones, int num) {
   		int index = Arrays.binarySearch(stones, num);
   		return (index >= 0 ? index : -1);
   	}
}