package com.leetcode;

import java.util.Arrays;

public class Leetcode743_BellmanFord {
    public int networkDelayTime(int[][] times, int n, int k) {

        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        for(int i=1;i<=n;i++)
        {
            for(int[] time : times)
            {
                int u = time[0], v = time[1], w=time[2];

                int newTime = dist[u]+w;

                if(dist[u]!=Integer.MAX_VALUE && newTime<dist[v])
                {
                    dist[v] = newTime;
                }
            }
        }

        int maxTime = -1;

        for(int i=1;i<=n;i++)
        {
            if(dist[i]==Integer.MAX_VALUE) return -1;
            else maxTime = dist[i];
        }

        return maxTime;
    }
}
