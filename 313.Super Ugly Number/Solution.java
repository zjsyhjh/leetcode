public class Solution {

	private int[] ugly;
	private int[] ptr;
    public int nthSuperUglyNumber(int n, int[] primes) {
        ugly = new int[n + 1];
        ugly[1] = 1;
        ptr = new int[primes.length];
        for (int i = 0; i < ptr.length; i++){
        	ptr[i] = 1;
        }
       	int index = 1;
        while (index <= n) {
        	int minVal = Integer.MAX_VALUE;
        	for (int i = 0; i < primes.length; i++) {
        		minVal = Math.min(minVal, primes[i] * ugly[ptr[i]]);
        	}
        	ugly[++index] = minVal;
        	for (int i = 0; i < primes.length; i++) {
        		while (primes[i] * ugly[ptr[i]] <= minVal) ptr[i]++;
        	}
        }
        return ugly[n];
    }
}