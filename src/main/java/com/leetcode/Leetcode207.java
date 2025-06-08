package com.leetcode;

import java.sql.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Leetcode207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        //build graph
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[numCourses];
        Queue<Integer> que = new LinkedList<>();
        List<Integer> finishOrder = new ArrayList<>();

        for(int i=0;i<numCourses;i++)
        {
            graph.add(new ArrayList<>());
        }

        for(int[] prereq : prerequisites)
        {
            graph.get(prereq[0]).add(prereq[1]);
            indegree[prereq[1]]++;
        }

        for(int i=0;i<numCourses;i++) if(indegree[i]==0) que.offer(i);

        //bfs style kahn's algo implementation
        while(!que.isEmpty())
        {
            Integer node = que.poll();
            finishOrder.add(node);

            for(int neigh : graph.get(node)){
                if(--indegree[neigh]==0) que.offer(neigh);
            }

        }

        return finishOrder.size()==numCourses ? true : false;
    }
}
