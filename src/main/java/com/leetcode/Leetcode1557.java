package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Leetcode1557 {
    public static void main(String[] args) {

        //[[0,1],[0,2],[2,5],[3,4],[4,2]]
        List<List<Integer>> edges = new ArrayList<>();
        List<Integer> edge1 = List.of(0,1);
        List<Integer> edge2 = List.of(0,2);
        List<Integer> edge3 = List.of(2,5);
        List<Integer> edge4 = List.of(3,4);
        List<Integer> edge5 = List.of(4,2);
        edges.add(edge1);
        edges.add(edge2);
        edges.add(edge3);
        edges.add(edge4);
        edges.add(edge5);

        System.out.println(findSmallestSetOfVertices(6, edges));
    }
    public static List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {

        //dfs with neighs
        List<List<Integer>> graph = new ArrayList<>();
        boolean[] visited = new boolean[n];
        List<Integer> res = new ArrayList<>();

        for(int i=0;i<n;i++) graph.add(new ArrayList<>());

        //construct graph
        for(List<Integer> edge : edges) graph.get(edge.get(0)).add(edge.get(1));

        Stack<Integer> stack = new Stack<>();
        List<List<Integer>> sccs = new ArrayList<>();

        //1. create stack
        for(int i=0;i<n;i++)
        {
            if(!visited[i]) dfs1(i, graph, visited, stack);
        }

        //2. reverse graph
        List<List<Integer>> revGraph = new ArrayList<>();

        for(int i=0;i<n;i++) revGraph.add(new ArrayList<>());

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<graph.get(i).size();j++)
            {
                revGraph.get(graph.get(i).get(j)).add(i);
            }
        }

        //3. iterate over stack and revgraph to add sccs
        Arrays.fill(visited, false);
        while(!stack.isEmpty())
        {
            Integer node = stack.pop();
            if(!visited[node])
            {
                List<Integer> component = new ArrayList<>();
                dfs2(node, visited, revGraph, component);
                sccs.add(component);
            }
        }

        //filling res
        for(List<Integer> scc : sccs)
        {
            res.add(scc.get(0));
        }

        return res;

    }

    private static void dfs2(Integer node, boolean[] visited, List<List<Integer>> revGraph, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for(Integer neigh : revGraph.get(node))
        {
            if(!visited[neigh]) dfs2(neigh, visited, revGraph, component);
        }
    }

    private static void dfs1(int node, List<List<Integer>> graph, boolean[] visited, Stack<Integer> stack) {

        visited[node] = true;

        for(int neigh : graph.get(node)){
            if(!visited[neigh]) dfs1(neigh, graph, visited, stack);
            visited[neigh] = true;
        }
        stack.push(node);
    }
}
