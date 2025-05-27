package com.leetcode;

public class Leetcode684 {

    public int[] findRedundantConnection(int[][] edges) {

        int[] parent = new int[edges.length+1];

        //initialize parent
        for(int i=0;i<parent.length;i++) parent[i] = i;

        int[] extraEdge = new int[2];

        for(int i=0;i<edges.length;i++)
        {
            union(edges[i][0], edges[i][1], parent, extraEdge);
        }

        return extraEdge;
    }

    private void union(int x, int y, int[] parent, int[] extraEdge){

        int px = find(x, parent);
        int py = find(y, parent);

        if(px==py) //edge already exists, save extra edge
        {
            extraEdge = new int[]{x,y};
        }

        parent[px] = py;
    }

    private int find(int x, int[] parent){

        if(x!=parent[x]) {
            parent[x] = find(parent[x], parent);
        }

        return parent[x];
    }
}
