package com.leetcode;

import java.util.Arrays;

public class Leetcode1334_FloydWarshall {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] dist = new int[n][n];

        for(int i=0;i<n;i++) for(int j=0;j<n;j++) dist[i][j] = Integer.MAX_VALUE/2;

        //fill initial distances
        for(int[] edge : edges) {
            dist[edge[0]][edge[1]] = edge[2];
            dist[edge[1]][edge[0]] = edge[2];
        }

        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(dist[i][k] + dist[k][j] < dist[i][j]){
                        dist[i][j] = dist[i][k] + dist[k][j];
                        dist[j][i] = dist[i][k] + dist[k][j];//bidirectional

                    }
                }
            }
        }

        int minReachable = Integer.MAX_VALUE, resCity = 0;
        for(int i=0;i<n;i++)
        {
            int count = 0;
            for(int j=0;j<n;j++)
            {
                if(dist[i][j]<=distanceThreshold) count++;
            }
            if(minReachable>=count) {
                minReachable = count;
                resCity = i;
            }
        }

        return resCity;

    }
}
