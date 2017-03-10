import java.util.*;

public class Solution {

	private HashMap<Long, Integer> mp = new HashMap<>();
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
    	StringBuilder res = new StringBuilder();
    	res.append((numerator > 0) ^(denominator > 0) ? "-":"");

    	long num1 = Math.abs((long)numerator);
    	long num2 = Math.abs((long)denominator);
    	
    	res.append(Long.toString(num1/num2));
    	if ((num1 % num2) == 0) {
    		return res.toString();
    	}
    	res.append(".");
    	long num = num1 % num2;
    	mp.put(num, res.length());
    	while (num != 0) {
    		num *= 10;
    		res.append(num/num2);
    		num %= num2;
    		if (mp.containsKey(num)) {
    			int index = mp.get(num);
    			res.insert(index, "(");
    			res.append(")");
    			break;
    		}
    		mp.put(num, res.length());
    	}
    	return res.toString();
    }
}