package com.leetcode;

public class Leetcode547 {
    int count = 0;

    public int findCircleNum(int[][] isConnected) {

        count = isConnected[0].length;
        int n = count;

        int[] parents = new int[n];

        //initialise parents arr
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(parents, i, j);
                }
            }
        }


        return count;

    }

    private void union(int[] parents, int i, int j) {

        int pi = find(parents, i);
        int pj = find(parents, j);

        if (pi != pj) {
            count--;
            parents[pi] = pj;
        }
        //else if pi==pj they are already part of same group
    }

    private int find(int[] parents, int x) {
        if (parents[x] != x) {
            parents[x] = find(parents, parents[x]);
        }

        return parents[x];
    }
}
