public class Solution {
    public int findMinArrowShots(int[][] points) {
    	if (points == null || points.length == 0) {
    		return 0;
    	}
		Arrays.sort(points, (x, y) -> x[0] == y[0] ? x[1] - y[1] : x[0] - y[0]);
		int res = 1, minEnd = points[0][1];
		for (int i = 1; i < points.length; i++) {
			if (points[i][0] <= minEnd) {
				minEnd = Math.min(minEnd, points[i][1]);
			} else {
				res++;
				minEnd = points[i][1];
			}
		}       
		return res;
    }
}