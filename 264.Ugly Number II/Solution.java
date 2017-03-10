public class Solution {

	private List<Integer> uglyNums;
    public int nthUglyNumber(int n) {
    	uglyNums = new ArrayList<>();
    	uglyNums.add(1);
    	int index = 0;
    	int t2 = 0, t3 = 0, t5 = 0;
    	while (index < n - 1) {
    		int num = uglyNums.get(index);
    		while (uglyNums.get(t2) * 2 <= num) {
    			t2++;
    		}
    		while (uglyNums.get(t3) * 3 <= num) {
    			t3++;
    		}
    		while (uglyNums.get(t5) * 5 <= num) {
    			t5++;
    		}
    		if (uglyNums.get(t2) * 2 <= uglyNums.get(t3) * 3 && uglyNums.get(t2) * 2 <= uglyNums.get(t5) * 5) {
    		    uglyNums.add(uglyNums.get(t2) * 2);
    			t2++;
    		} else if (uglyNums.get(t3) * 3 <= uglyNums.get(t2) * 2 && uglyNums.get(t3) * 3 <= uglyNums.get(t5) * 5) {
    		    uglyNums.add(uglyNums.get(t3) * 3);
    			t3++;
    		} else {
    		    uglyNums.add(uglyNums.get(t5) * 5);
    			t5++;
    		}
    		index += 1;
    	}
    	return uglyNums.get(n - 1);
    }
}