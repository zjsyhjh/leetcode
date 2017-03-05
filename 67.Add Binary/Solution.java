/**
 * Created by iHge2k on 2017/3/5.
 */
public class Solution {

    public String addBinary(String a, String b) {

        String ans = "";
        int index1 = a.length() - 1, index2 = b.length() -1, add = 0;
        while (index1 >= 0 || index2 >= 0 || add == 1) {

            add += index1 >= 0 ? (a.charAt(index1--) - '0') : 0;
            add += index2 >= 0 ? (b.charAt(index2--) - '0') : 0;
            ans += Integer.toString(add % 2 );
            add /= 2;
        }
        return new StringBuilder(ans).reverse().toString();
    }
}
