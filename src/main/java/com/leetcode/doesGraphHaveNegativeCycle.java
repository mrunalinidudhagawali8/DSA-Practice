package com.leetcode;

import java.util.Arrays;

public class doesGraphHaveNegativeCycle {

    public boolean hasNegativeCycle(int n, int[][] edges){
       int[] dist = new int[n];
       Arrays.fill(dist, 0);//since all components may not be connected so safe in negative cycle detection

       for(int i=0;i<n;i++)//if update in iteration n-1th iteration exists
           // (meaning it still trying to improve after all possbible edges shortest path discovery iis a sign of negative cycle)
       {
           for(int [] edge : edges)
           {
               int u = edge[0];
               int v = edge[1];
               int w = edge[2];

               if(dist[u]+w<dist[v])
               {
                   dist[v]=dist[u]+w;

                   if(i==n-1) return true;
               }

           }
       }

       return false;
    }
}
