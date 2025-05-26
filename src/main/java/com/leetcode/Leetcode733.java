package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Leetcode733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int targetColour = image[sr][sc];

        dfs(image, color, targetColour, sr, sc);

        return image;
    }

    private void dfs(int[][] image, int color, int targetColour, int sr, int sc) {

        if(sr<0 || sc<0 || sr>=image.length || sc>=image[0].length || image[sr][sc]!=targetColour) return;
//        int rowMax = image.length, colMax = image[0].length;

        image[sr][sc] = color;

        //top
        dfs(image, color, targetColour, sr-1, sc);
        dfs(image, color, targetColour, sr+1, sc);
        dfs(image, color, targetColour, sr, sc+1);
        dfs(image, color, targetColour, sr, sc-1);
    }
}
