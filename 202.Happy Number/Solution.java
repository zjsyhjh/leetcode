import java.util.HashSet;

public class Solution {

	private HashSet<Integer> set;
    public boolean isHappy(int n) {
    	set = new HashSet<>();
		while (!set.contains(n)) {
			set.add(n);
			String s = Integer.toString(n);
			int sum = 0;
			for (int i = 0; i < s.length(); i++) {
				int num = s.charAt(i) - '0';
				sum += num * num;
			}
			n = sum;
		}
		return n == 1;   
    }
}