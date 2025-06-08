package com.leetcode;

import java.sql.Array;
import java.util.*;

public class Leetcode802 {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> revGraph = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        int[] outDegree = new int[n];
        boolean[] safeNodes = new boolean[n];

        //initialize revGraph
        for (int i = 0; i < n; i++)
            revGraph.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                outDegree[i]++;
                revGraph.get(graph[i][j]).add(i);
            }
        }

        for (int i = 0; i < n; i++)
            if (outDegree[i] == 0)
                que.offer(i);

        while (!que.isEmpty()) {
            Integer node = que.poll();
            safeNodes[node] = true;
            for (int prev : revGraph.get(node)) {
                if (--outDegree[prev] == 0)
                    que.offer(prev);
            }
        }

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < n; i++)
            if (safeNodes[i])
                res.add(i);

        Collections.sort(res);

        return res;

    }
}
