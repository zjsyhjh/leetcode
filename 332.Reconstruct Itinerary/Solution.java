/**
 * Created by iHge2k on 2017/3/4.
 */

import java.util.*;

public class Solution {

    private Map<String, Queue<String>> g = new HashMap<>();
    private LinkedList<String> ans = new LinkedList<>();

    public List<String> findItinerary(String[][] tickets) {

        for (int i = 0; i < tickets.length; i++) {
            if (!g.containsKey(tickets[i][0])) {
                g.put(tickets[i][0], new PriorityQueue<>());
            }
            g.get(tickets[i][0]).offer(tickets[i][1]);
        }
        String from = "JFK";
        dfs(from);
        return ans;
    }

    private void dfs(String from) {
        Queue<String> que = g.get(from);

        while (que != null && !que.isEmpty()) {
            dfs(que.poll());
        }

        ans.addFirst(from);
    }
}
