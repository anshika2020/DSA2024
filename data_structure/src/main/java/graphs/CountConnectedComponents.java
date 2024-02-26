package graphs;

import java.util.*;

public class CountConnectedComponents {
  // dfs approach using adjacency list
    // n is the number of edges
    // list edges is the list of all provided edges*
    /*

    How to solve:
    1. Create an adjacency list such that adj[v] contains all the adjacent vertices of vertex v
    2. Initialize a set or array to track teh visited vertices
    3.Define a counter veriable and initialize to 0
    4.Iterate over vertex v in edges and if the vertex is not in visited array
         a) start dfs call from it and add every vertex visited
    5. Everytime new dfs start increment the counter
    6.at the end return the counter


    What do we need :
    1. Build graph
    1. need an set to store visited vertex
    2. need an int counter to count the number of visited vertex
     */

    // build a graph




    public static int number_of_connected_components(int n, List<List<Integer>> edges) {
        // create variable to count the number of dfs calls
        int count =0;
        // create a boolean array to store visited vertices
        boolean[] visited = new boolean[n];
        //create a map object of integer and list so that one vertex can contain all adjacency vertices
        Map<Integer, List<Integer>> adjList = new HashMap(n);

        // now need to initialize new Arraylist at every key/ index
        for(int i=0;i<n;i++){
            adjList.put(i, new ArrayList<>());
        }

        // create the adjacency List
        for(List<Integer> edge:edges){
            //now set source to target
            if(!adjList.get(edge.get(0)).contains(edge.get(1))){
                adjList.get(edge.get(0)).add(edge.get(1));
            }
            // now set dest to source
            if(!adjList.get(edge.get(1)).contains(edge.get(0))){
                adjList.get(edge.get(1)).add(edge.get(0));
            }
        }

        // iterate through given number of vertices
        for(int i=0;i<n;i++){
            if(!visited[i]){
                dfsHelper(visited, adjList, i);
                count++;
            }
        }
        return count;
    }

    static void dfsHelper(boolean[] visited,Map<Integer, List<Integer>> adjList, int i){
        List<Integer> list = adjList.get(i);
        for(Integer num : list){
            if(!visited[num]){
                visited[num] = true;
                dfsHelper(visited,adjList,num);
            }
        }

    }

    public static void main(String[] args) {
        int nodes = 5;
        Integer [][] num= {{0 , 1},{1 , 2},{3 , 4}};
        List<List<Integer>> adjLists = new ArrayList<>();
        for (Integer[] n : num) {
            adjLists.add(Arrays.asList(n));
        }
        System.out.println(number_of_connected_components(nodes,adjLists));
    }


}
