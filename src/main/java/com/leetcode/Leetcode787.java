package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode787 {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        int[][] cost = new int[n][k + 2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        for (int[] flight : flights) {
            graph.get(flight[0]).add(new int[] { flight[2], flight[1] });
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[] { 0, 0, src });//cost, stops, node

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int currPrice = node[0];
            int currStopsCount = node[1];
            int currNode = node[2];

            if (currNode == dst)
                return currPrice;

            if (currStopsCount > k)
                continue;

            for (int[] neigh : graph.get(currNode)) {
                int neighp = neigh[0];
                int neighval = neigh[1];

                int newPrice = neighp + currPrice;

                if (newPrice < cost[neighval][currStopsCount + 1]) {
                    cost[neighval][currStopsCount + 1] = newPrice;
                    pq.offer(new int[] { newPrice, currStopsCount + 1, neighval });
                }
            }

        }

        return -1;
    }
}
