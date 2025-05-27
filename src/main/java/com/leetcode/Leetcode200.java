package com.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Leetcode200 {

    public int numIslands(char[][] grid) {
        int connectedLandsCount = 0;

        Map<Pair, Boolean> landMapVisit = new HashMap<>();


        //populate landMapVisit
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0; j<grid[0].length;j++)
            {
                if(grid[i][j]=='1'){
                    dfs(grid, i, j);
                    connectedLandsCount++;

                }
            }
        }

        return connectedLandsCount;
    }

    private void dfs(char[][] grid, int r, int c) {

        if(r<0 || r>=grid.length || c<0 || c>=grid[0].length) return;

        if(grid[r][c]=='0') return;

        grid[r][c] = '0';

        dfs(grid, r-1, c);
        dfs(grid, r+1, c);
        dfs(grid, r, c-1);
        dfs(grid, r, c+1);

    }

}

