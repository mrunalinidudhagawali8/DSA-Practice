package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Leetcode778 {
    public int swimInWater(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;

        int[][] time = new int[row][col];

        for(int[] singlerow : time) Arrays.fill(singlerow, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);

        pq.offer(new int[]{0,0,0});
        time[0] = new int[]{0};

        int[][] dirs = {{0,1}, {1,0}, {0,-1},{-1,0}};

        while(!pq.isEmpty())
        {
            int[] curr = pq.poll();

            int currTime = curr[0], r = curr[1], c = curr[2];

            if(r==row-1 && c==col-1) return currTime;

            for(int[] dir : dirs)
            {
                int nr = r+dir[0];
                int nc = c+dir[1];

                if(nr<0 ||nc<0 || nc>=col || nr>=row) continue;



                int stepTime = Math.abs(grid[nr][nc]-grid[r][c]);

                int newTime = Math.max(currTime, stepTime);

                //check if this neigh step is lower than the curr
                if (newTime < time[nr][nc]) {
                    //check if this neigh step is lower than the curr
                    if (grid[nr][nc] <= grid[r][c]) {
                        time[nr][nc] = newTime;
                        pq.offer(new int[] { currTime, nr, nc });
                    } else {
                        time[nr][nc] = newTime;
                        pq.offer(new int[] { currTime + newTime, nr, nc });
                    }
                }
            }
        }


        return -1;
    }
}
