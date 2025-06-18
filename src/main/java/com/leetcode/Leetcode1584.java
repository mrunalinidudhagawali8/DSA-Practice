package com.leetcode;

import org.springframework.boot.web.server.Cookie;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode1584 {
    int[] parent, rank;
    public int minCostConnectPoints(int[][] points) {

        int n = points.length;
        int totalWeight = 0;

        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->(a[1]-b[1]));

        //construct neigh graph
        for (int i = 0; i < n; i++) points[i] = new int[]{i, points[i][0], points[i][1]};
        List<List<int[]>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                List<int[]> list = graph.get(i);
                int node1 = points[i][0], node1x = points[i][1], node1y = points[i][2];
                //calculate dist between point0 and point1
                if (i != j) {
                    int node2 = points[j][0], node2x = points[j][1], node2y = points[j][2];

                    int horzDist = Math.abs(node1x - node2x);
                    int vertDist = Math.abs(node1y - node2y);

                    list.add(new int[]{node2, horzDist + vertDist});
                }
            }
        }

        pq.offer(new int[]{0, 0});

        while(!pq.isEmpty())
        {
            int[] node = pq.poll();
            int curr = node[0], cost = node[1];
            if(visited[node[0]]) continue;
            visited[node[0]] = true;
            totalWeight += cost;
            for(int[] neigh : graph.get(node[0])){
                if(!visited[neigh[0]]) pq.offer(neigh);
            }
        }

        return totalWeight;

    }
}
