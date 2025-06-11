package com.leetcode;

import java.util.*;

public class Leetcode847 {
    public int shortestPathLength(int[][] graph) {

        int n = graph.length;
        int minDistCoveredSoFar = Integer.MAX_VALUE;

        List<List<Integer>> grid  = new ArrayList<>();
        int[][] dist = new int[n][n];
        Set<Integer> expectedvisits= new HashSet<>();

        for(int i=0;i<n;i++) expectedvisits.add(i);

        for(int i=0;i<n;i++)
        {
            grid.add(new ArrayList<>());
        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<graph[i].length;j++)
            {
                grid.get(i).add(graph[i][j]);
            }
        }

        //initialize dist with max value
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        PriorityQueue<Node> que = new PriorityQueue<>((a,b)->{ int visitedDiff = Integer.compare(b.visited.size(), a.visited.size()); // More visited is better
        if (visitedDiff != 0) {
            return visitedDiff;
        }
        return Integer.compare(a.distCovered, b.distCovered) ;}
        );


        for(int i=0;i<n;i++)
        {
            que.offer(new Node(i, 0, new HashSet<>(List.of(i))));
        }

        while(!que.isEmpty())
        {
            Node curr = que.poll();

            if(curr.visited.equals(expectedvisits)) Math.min(curr.distCovered, minDistCoveredSoFar);

            for(int i=0;i<grid.get(curr.node).size();i++)
            {
                int neigh = grid.get(curr.node).get(i);
                int newDist = curr.distCovered+1;

                if(dist[curr.node][i]>newDist) {
                    dist[curr.node][i] = newDist;
                    que.offer(new Node(neigh, newDist, curr.visited));
                }

            }
        }


        return minDistCoveredSoFar;


    }

    static class Node{
        int node;
        int distCovered;
        Set<Integer> visited;

        public Node(int node, int distCovered, Set<Integer> nodesVisited){
            this.node = node;
            this.distCovered = distCovered;
            this.visited=nodesVisited;
        }
    }
}
