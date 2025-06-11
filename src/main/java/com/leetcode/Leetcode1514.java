package com.leetcode;

import java.util.*;

public class Leetcode1514 {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        List<List<NodeData>> graph = new ArrayList<>();
        double[] probs = new double[n];

        //initialize array
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        //construct graph
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0], v = edges[i][1];
            double prob = succProb[i];

            graph.get(u).add(new NodeData(prob, v));
            graph.get(v).add(new NodeData(prob, u)); // because it's undirected
        }

        Arrays.fill(probs, 0);

        PriorityQueue<NodeData> pq = new PriorityQueue<>((a, b) -> Double.compare(b.probability, a.probability));

        pq.offer(new NodeData(1.0, start_node));
        probs[start_node] = 1.0;

        while (!pq.isEmpty()) {
            NodeData currNode = pq.poll();
            double cp = currNode.probability;
            int cv = currNode.num;

            if (cv == end_node)
                return cp;

            for (NodeData neigh : graph.get(cv)) {
                double np = neigh.probability;
                int nv = neigh.num;

                double newprob = cp*np;

                if (newprob > probs[nv]) {
                    probs[nv] = newprob;
                    pq.offer(new NodeData(newprob, nv));
                }

            }
        }

        return 0;

    }

    static class NodeData {
        double probability;
        int num;

        public NodeData(double probability, int num) {
            this.probability = probability;
            this.num = num;
        }
    }
}
