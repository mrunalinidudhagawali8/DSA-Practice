package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode743 {
    public int networkDelayTime(int[][] times, int n, int k) {

        //construct graph
        List<List<int[]>> graph = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int[] time : times)
        {
            graph.get(time[0]).add(new int[]{time[1], time[2]});
        }

        int[] dist = new int[n+1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[k] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);

        pq.offer(new int[]{k, 0});

        while(!pq.isEmpty())
        {
            int[] curr = pq.poll();
            int node = curr[0];
            int time = curr[1];

            if(time>dist[node]) continue;

            for(int[] neigh : graph.get(node)){
                int next = neigh[0], weigh = neigh[1];
                if(time+weigh<dist[next]){
                    dist[next] = time+weigh;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        int res = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            res = Math.max(res, dist[i]);
        }
        return res;

    }
}
