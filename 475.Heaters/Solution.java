public class Solution {

    public int findRadius(int[] houses, int[] heaters) {
    	Arrays.sort(heaters);
    	int res = 0;
        for (int house : houses) {
        	int index = Arrays.binarySearch(heaters, house);
        	if (index < 0) {
        		index = ~index;
        		int dis1 = (index - 1 >= 0) ? house - heaters[index - 1] : Integer.MAX_VALUE;
        		int dis2 = (index < heaters.length) ? heaters[index] - house : Integer.MAX_VALUE;
        		res = Math.max(res, Math.min(dis1, dis2));
        	}
        }
        return res;
    }
}