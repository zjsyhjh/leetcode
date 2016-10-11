import java.util.List;
import java.util.Iterator;

public class Solution {

	private int[][] dp;

    public int minimumTotal(List<List<Integer>> triangle) {

    	dp = new int[triangle.size()][triangle.size()];
    	for (int i = 0; i < triangle.size(); i++) {
    		for (int j = 0; j < triangle.size(); j++) {
    			dp[i][j] = 0x3f3f3f3f;
    		}
    	}
    	Iterator<List<Integer> > iter1 = triangle.iterator();

    	if (iter1.hasNext()) {
    		List<Integer> l = iter1.next();
    		for (int i = 0; i < l.size(); i++) {
    			dp[0][i] = l.get(i);
    		}
    	}
    	int index = 1;
    	while (iter1.hasNext()) {
    		List<Integer> l = iter1.next();
    		dp[index][0] = dp[index - 1][0] + l.get(0);
    		for (int i = 1; i < l.size(); i++) {
    			dp[index][i] = Math.min(dp[index - 1][i - 1], dp[index - 1][i]) + l.get(i); 
    		}
    		index += 1;
    	}

    	int ans = 0x3f3f3f3f;
    	for (int i = 0; i < triangle.size(); i++) {
    		ans = Math.min(ans, dp[index - 1][i]);
    	}

    	return ans;
    }
}