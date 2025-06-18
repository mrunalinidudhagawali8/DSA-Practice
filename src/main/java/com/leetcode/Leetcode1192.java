package com.leetcode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1192 {
    private int time = 0;

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {


        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (List<Integer> edge : connections) {
            int u = edge.get(0), v = edge.get(1);
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int[] tin = new int[n];
        int[] low = new int[n];

        boolean[] visited = new boolean[n];
        List<List<Integer>> bridges = new ArrayList<>();
        time = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, adj, visited, tin, low, bridges);
            }
        }

        return bridges;

    }

    private void dfs(int u, int parent, List<List<Integer>> conneadjtions, boolean[] visited, int[] tin, int[] low,
                     List<List<Integer>> bridges) {

        visited[u] = true;

        tin[u] = low[u] = time++;

        for (int v : conneadjtions.get(u)) {
            if (v == parent)
                continue; //skip the parent edge

            if (!visited[v]) {
                dfs(v, u, conneadjtions, visited, tin, low, bridges);
                low[u] = Math.min(low[u], low[v]);

                if (low[v] > tin[v]) {
                    bridges.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], tin[v]);
            }
        }
    }
}
