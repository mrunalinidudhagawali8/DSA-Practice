package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode1971 {
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        List<List<Integer>> graph = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }

        //build graph
        for(int[] edge: edges){
            int i = edge[0];
            int j = edge[1];

            graph.get(i).add(j);
            graph.get(j).add(i);
        }

        boolean[] visited = new boolean[n];

        return dfs(graph, destination, visited, source);
    }

    private boolean dfs(List<List<Integer>> graph, int destination, boolean[] visited, int source) {
        if(source==destination) return true;
        if(visited[source]) return false;

        visited[source] = true;

        for(Integer neighb : graph.get(source)){

            if(dfs(graph, destination, visited, source)){
                return true;
            }

        }

        return false;
    }
}
