package com.leetcode;

import java.sql.Array;
import java.util.*;

public class Leetode261 {

    public boolean validTree(int n, int[][] edges) {

        if (edges.length != n - 1) return false;

        List<List<Integer>> graph = new ArrayList<>();

        //initialise graph with n empty lists
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        //build graph adjacency list
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            graph.get(u).add(v);
            graph.get(v).add(u); //considering the graph is undirected (however we are not considering how the tree will be
        }

        boolean[] visited = new boolean[n];

        if (!hasCycleDfs(graph, 0, -1, visited)) {
            for (boolean viistDone : visited) {
                if (!viistDone) return false;
            }
            return true;
        }
        return false;


    }

    public boolean validTreeUnionFind(int n, int[][] edges) {
        if (edges.length != n - 1) return false;

        int[] parents = new int[n];

        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        //build graph adjacency list
        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            int pu = find(parents, u);
            int pv = find(parents, v);

            if (pu == pv)//both are part of same componenets
                return false;

            parents[pu] = pv;
        }

        return true;

    }

    private int find(int[] parents, int x) {
        if (parents[x] != x) {
            parents[x] = find(parents, parents[x]);

        }
        return parents[x];
    }



public boolean validTreeBFS(int n, int[][] edges) {

    if (edges.length != n - 1) return false;

    List<List<Integer>> graph = new ArrayList<>();

    //initialize graph
    for (int i = 0; i < n; i++) {
        graph.add(new ArrayList<>());
    }

    //construct graph
    for (int[] edge : edges) {

        int u = edge[0];
        int v = edge[1];

        graph.get(u).add(v);
        graph.get(v).add(u);
    }


    boolean[] visited = new boolean[n];
    int[] parents = new int[n];
    Arrays.fill(parents, -1);

    Queue<Integer> que = new LinkedList<>();

    que.add(0);
    while (!que.isEmpty()) {
        Integer curr = que.poll();

        if (visited[curr]) continue;

        visited[curr] = true;

        for (int neigh : graph.get(curr)) {
            if (!visited[neigh]) {
                parents[neigh] = curr;
                que.offer(neigh);
            } else if (parents[curr] != neigh) {
                return false; //found a cycle, we can return false
            }
        }
    }

    for (boolean v : visited) {
        if (!v) return false;
    }
    return true;
}


private boolean hasCycleDfs(List<List<Integer>> graph, int node, int parent, boolean[] visited) {

    visited[node] = true;

    for (int neigh : graph.get(node)) {
        if (!visited[neigh]) {
            if (hasCycleDfs(graph, neigh, node, visited)) return true; // found a cycle
        } else if (neigh != parent) {
            return true; // found a cycle
        }
    }

    return false;//chance of a tree
}
}
