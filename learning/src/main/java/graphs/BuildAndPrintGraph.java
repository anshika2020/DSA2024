package graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildAndPrintGraph {
    private List<List<Integer>> adj = new ArrayList<>();

    //A class to store a grapgh edges
    static class Edge {
        // to connect two vertex we need create edge with source(vertex1) and destination(vertext2)
        int src;
        int dest;

        public Edge(int s, int d) {
            this.src = s;
            this.dest = d;
        }
    }

    // A constructor to construct a graph
    public BuildAndPrintGraph(List<Edge> edges) {
        //find maximum number of vertex
        int n = 0;
        for (Edge e : edges) {//
            n = Integer.max(n, Integer.max(e.src, e.dest));
        }

        // allocate memory for the adjacency list
        for (int i = 0; i <= n; i++) {
            adj.add(i, new ArrayList<>());
        }

        // add edges to undirect graph
        for (Edge currentEdge : edges) {
            adj.get(currentEdge.src).add(currentEdge.dest);
            // for undirected
            //  adj.get(currentEdge.dest).add(currentEdge.src);
        }
    }

    static void printGraph(BuildAndPrintGraph graph) {
        int src = 0;
        int n = graph.adj.size();
        while (src < n) {
            // print current vertex and all its neighboring vertices
            for (int dest : graph.adj.get(src)) {
                System.out.println("(" + src + "-->" + dest + ")");
            }
            src++;
        }

    }

    public static void main(String[] args) {
        // for undirected graph
//        List<Edge> egdes = new ArrayList<>();
//        egdes.add(new Edge(0,1));
//        egdes.add(new Edge(1,2));
//        egdes.add(new Edge(2,3));
//        egdes.add(new Edge(3,1));
//        egdes.add(new Edge(2,0));

        // Input: List of edges in a digraph (as per the above diagram)
        List<Edge> edges = Arrays.asList(new Edge(0, 1), new Edge(1, 2),
                new Edge(2, 0), new Edge(2, 1), new Edge(3, 2),
                new Edge(4, 5), new Edge(5, 4));
        BuildAndPrintGraph graph1 = new BuildAndPrintGraph(edges);
        printGraph(graph1);
    }

}
