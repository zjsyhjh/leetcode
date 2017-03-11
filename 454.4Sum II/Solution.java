public class Solution {

	private HashMap<Integer, Integer> mp = new HashMap<>();
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        for (int i = 0; i < A.length; i++) {
        	for (int j = 0; j < B.length; j++) {
        		int s = A[i] + B[j];
        		if (mp.containsKey(s)) {
        			mp.put(s, mp.get(s) + 1);
        		} else {
        			mp.put(s, 1);
        		}
        	}
        }

        int count = 0;
        for (int i = 0; i < C.length; i++) {
        	for (int j = 0; j < D.length; j++) {
        		int s = (C[i] + D[j]) * (-1);
        		if (mp.containsKey(s)) {
        			count += mp.get(s);
        		}
        	}
        }
        return count;
    }
}