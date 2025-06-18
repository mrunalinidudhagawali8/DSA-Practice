package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * You are given an integer n, the number of cities numbered from 1 to n. You are also given a list connections, where each connections[i] = [city1, city2, cost] represents the cost to connect city1 and city2 together.
 *
 * Return the minimum cost to make all cities connected.
 * If it is impossible, return -1.
 *
 * A connected graph means:
 *
 * There is a path between any two cities.
 *
 * n = 3
 * connections = [[1,2,5],[1,3,6],[2,3,1]]
 * 6
 *
 * Explanation:
 * Choose edges (2–3) with cost 1 and (1–2) with cost 5.
 * (1–3) is not needed.
 *
 * Constraints:
 * 1 <= n <= 10000
 *
 * 1 <= connections.length <= 10^4
 *
 * connections[i].length == 3
 *
 * 1 <= city1, city2 <= n
 *
 * city1 != city2
 *
 * 0 <= cost <= 10^6
 *
 * No repeated connection, i.e., each pair appears at most once
 *
 * The input is guaranteed to form a connected graph if possible.
 */
public class Leetcode1135 {
    int parent[];
    int rank[];

    public int minimumCost(int n, int[][] connections) {

        parent = new int[n];
        rank = new int[n];

        for(int i=0;i<n;i++)
        {
            parent[i] = i;
        }

        Arrays.sort(connections, Comparator.comparing(a->a[2]));

        int totalWeight = 0;
        int edgeCount = 0;

        for(int[] conn : connections)
        {
            int x = conn[0]-1, y = conn[1]-1, weight = conn[2];

            if(find(x)!=find(y))
            {
                union(x, y);
                totalWeight += weight;
                edgeCount++;
            }
        }

        return edgeCount == n-1 ? totalWeight : -1;
    }
    public int find(int x)
    {
        if(parent[x]!=x)
        {
            parent[x] = find(x);
        }

        return parent[x];
    }


    public void union(int x, int y)
    {
        int px = find(x);
        int py = find(y);

        if(rank[px]<rank[py]){
            parent[px] = py;
        }else{
            parent[py] = px;
            rank[px]++;
        }
    }
}
