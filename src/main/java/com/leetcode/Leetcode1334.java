package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode1334 {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        List<List<Integer>> citiesinThreshold = new ArrayList<>();
        int[] dist = new int[n];
        int minReachable = Integer.MAX_VALUE;
        int ansCity = -1;

        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=0;i<n;i++) citiesinThreshold.add(new ArrayList<>());


        for (int i = 0; i < n; i++) {
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[i] = 0;
            for (int j = 0; j < n - 1; j++) {
                for (int[] edge : edges) {
                    int u = edge[0], v = edge[1], weight = edge[2];
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                    }
                    if (dist[v] != Integer.MAX_VALUE && dist[v] + weight < dist[u]) {
                        dist[u] = dist[v] + weight;
                    }
                }
            }

            int count = 0;
            //count total rechable wihtin threshold
            for(int k=0;k<n;k++)
            {
                if(k!=i && dist[k]<=distanceThreshold)
                {
                    count++;
                }
            }

            if(count<=minReachable)
            {
                minReachable = count;
                ansCity = i;
            }



        }

        return ansCity;
    }
}
