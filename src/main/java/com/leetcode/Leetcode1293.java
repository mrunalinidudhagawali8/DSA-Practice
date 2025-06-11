package com.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Leetcode1293 {

    public int shortestPath(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        int[][][] dist = new int[m][n][1];
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};


        for (int[][] layer : dist) {
            for (int[] row : layer) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }

        Deque<Node> deq = new ArrayDeque<>();
        dist[0][0][k] = 0;


        deq.offer(new Node( 0, 0, 0, k));

        while(!deq.isEmpty())
        {
            Node node = deq.poll();

            if(node.row==m-1 && node.col==n-1) return node.cost;

            for(int[] dir : dirs)
            {
                int nr = node.row+dir[0];
                int nc = node.col+dir[1];

                if(nr<0 || nc<0 || nr>=m || nc>=n) continue;


                int newK = node.remK - grid[nr][nc];
                if (newK < 0) continue;  // Cannot pass wall if no k left

                if (dist[nr][nc][newK] > node.cost + 1) {
                    dist[nr][nc][newK] = node.cost + 1;
                    deq.offer(new Node(nr, nc, node.cost + 1, newK));
                }

            }
        }
        return -1;
    }
    static class Node{
        int row;
        int col;
        int cost;
        int remK;

        public Node( int row, int col, int cost, int remK)
        {
            this.row = row;
            this.col = col;
            this.cost = cost;
            this.remK = remK;
        }
    }
}
