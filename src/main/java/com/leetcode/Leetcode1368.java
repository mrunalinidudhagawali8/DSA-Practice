package com.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Leetcode1368 {
    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[][] dirs  = {{0,-1},{0,1},{1,0},{-1,0}};

        //1:right (i,j+1)
        //2:left (i,j-1)
        //3:low (i+1,j)
        //4:up (i-1,j)

        //start at (0,0)
        pq.offer(new int[]{0,0});

        int totalCost = 0;
        while(!pq.isEmpty())
        {
            int[] node = pq.poll();
            int x = node[0];
            int y = node[1];
            visited[x][y] = true;

            if(x==m-1 && y==n-1) return totalCost;

            int nextMove = grid[x][y];

            for(int[] neigh : dirs){
                int nx = neigh[0]+x;
                int ny = neigh[1]+y;

                if(nx<m && ny<n && nx>=0 && ny>0 && !visited[nx][ny]){

                }
                else continue;

            }
        }

        return totalCost;

    }
}
