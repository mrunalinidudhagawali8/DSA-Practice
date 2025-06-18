//package com.leetcode;
//
//import java.util.*;
//
//public class Leetcode1486 {
//    int[] parent;
//    int[] rank;
//    List<List<Edge>> allMSTs;
//    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
//
//        allMSTs = new ArrayList<>();
//        parent = new int[n];
//        rank = new int[n];
//
//        for(int i=0;i<n;i++) parent[i] = i;
//
//        Arrays.sort(edges, Comparator.comparing(a->a[2]));
//
//        dfs(n, edges, allMSTs, new ArrayList<>());
//
//
//    }
//
//    private void dfs(int n, int[][] edges, List<List<Edge>> allMSTs, List<Edge> currMST) {
//        if(currMST.size()==n-1)
//        {
//            allMSTs.add(currMST);
//            return;
//        }
//
//        for(int[] edge : edges)
//        {
//            int u = edge[0], v = edge[1], weight = edge[2];
//
//            if(find(u)!=find(v))
//            {
//                union(u, v);
//                currMST.add(new Edge(u, v, weight));
//            }
//        }
//    }
//
//    class UnionFind {
//        int[] parent;
//
//        public UnionFind(int n) {
//            parent = new int[n];
//            for (int i = 0; i < n; i++) parent[i] = i;
//        }
//
//        public UnionFind(UnionFind uf) {
//            this.parent = Arrays.copyOf(uf.parent, uf.parent.length);
//        }
//
//        public int find(int x) {
//            if (x != parent[x]) parent[x] = find(parent[x]);
//            return parent[x];
//        }
//
//        public void union(int x, int y) {
//            int px = find(x);
//            int py = find(y);
//            parent[px] = py;
//        }
//    }
//
//
//    class Edge{
//        int x;
//        int y;
//        int weight;
//
//        Edge(int x, int y, int weight)
//        {
//            this.x = x;
//            this.y = y;
//            this.weight = weight;
//        }
//    }
//}
