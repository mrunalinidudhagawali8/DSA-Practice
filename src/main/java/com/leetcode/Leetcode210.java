package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode210 {
    List<Integer> res = new ArrayList<>();

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> graph = new ArrayList<>();

        boolean[] recstack = new boolean[numCourses];
        boolean[] visited = new boolean[numCourses];

        //construct graph
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] pre : prerequisites) {
            graph.get(pre[1]).add(pre[0]); // pre[1] -> pre[0]
        }

        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(i, visited, recstack, graph))
                return new int[0];
        }

        Collections.reverse(res);

        return res.stream().mapToInt(i -> i).toArray();
    }

    boolean hasCycle(int node, boolean[] visited, boolean[] recstack, List<List<Integer>> graph) {
        if (recstack[node])
            return true;//has cycle
        if (visited[node])
            return false;

        visited[node] = true;
        recstack[node] = true;

        for (int neigh : graph.get(node)) {
            if (hasCycle(neigh, visited, recstack, graph)) {
                return true;
            }
        }

        recstack[node] = false;
        res.add(node);

        return false;
    }
}
