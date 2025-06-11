package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode1631 {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        int[][] dist = new int[m][n];
        int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

        for(int row[]: dist) Arrays.fill(row, Integer.MAX_VALUE);

        //priority queue one element is <MaxMinEffortSoFar, row, col>
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        pq.offer(new int[] { 0, 0, 0 });
        dist[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[1], c = curr[2], currefforts = curr[0];

            if (r == m - 1 && c == n - 1)
                return currefforts;
            //explore up down left right
            //check bounds

            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];

                if (nr < 0 || nc < 0 || nr >= m || nc >= n)
                    continue;

                // 🤯 Calculate stepEffort and newEffort
                int stepEffort = Math.abs(heights[r][c] - heights[nr][nc]);
                // here we want to keep the max effort for this step across the path to be as low as possible
                int newEffort = Math.max(currefforts, stepEffort);

                if (newEffort < dist[nr][nc]) {
                    dist[nr][nc] = newEffort;
                    pq.offer(new int[] { newEffort, nr, nc });
                }

            }

        }

        return -1;
    }
}
