import java.util.*;

/**
 * Created by iHge2k on 2017/3/4.
 */


public class Solution {

    private Map<String, ArrayList<Edge>> g;
    private Set<String> mark;
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        g = new HashMap<String, ArrayList<Edge>>();
        for (int i = 0; i < equations.length; i++) {
            String u = equations[i][0];
            String v = equations[i][1];
            if (!g.containsKey(u)) {
                g.put(u, new ArrayList<>());
            }
            if (!g.containsKey(v)) {
                g.put(v, new ArrayList<>());
            }
            g.get(u).add(new Edge(v, values[i]));
            g.get(v).add(new Edge(u, 1.0 / values[i]));
        }

        double[] ans = new double[queries.length];

        for (int i = 0; i < queries.length; i++) {
            if (!g.containsKey(queries[i][0]) || !g.containsKey(queries[i][1])) {
                ans[i] = -1.0;
                continue;
            }
            mark = new HashSet<>(queries.length + 1);

            ans[i] = dfs(queries[i][0], queries[i][1], 1.0);

        }
        return ans;
    }

    private double dfs(String u, String goal, double res) {
        if (u.equals(goal)) {
            return res;
        }
        mark.add(u);
        for (Edge edge : g.get(u)) {
            if (mark.contains(edge.v)) continue;
            double ans = dfs(edge.v, goal, res * edge.w);
            if (ans != -1.0) {
                return ans;
            }
        }
        return -1.0;
    }

    private class Edge {
        String v;
        double w;
        Edge(String _v, double _w) {
            v = _v;
            w = _w;
        }
    }
}
