/**
 * Created by iHge2k on 2017/3/3.
 */

import java.util.*;

public class Solution {

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[] > pairs = new ArrayList<>();
        k = Math.min(nums1.length * nums2.length, k);

        if (k == 0) {
            return pairs;
        }

        Queue<int[] > que = new PriorityQueue<>(k, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return (o1[0] + o1[1] - (o2[0] + o2[1]));
            }
        });

        for (int num1 : nums1) {
            for (int num2 : nums2) {
                que.offer(new int[]{num1, num2});
            }
        }

        while (k-- > 0) {
            pairs.add(que.poll());
        }

        return pairs;
    }

}
