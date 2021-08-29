package graphs;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    private int numberofNode;
    List<List<Integer>> edges;

    public Graph(int n){
        this.numberofNode = n;
        edges= new ArrayList<>();
        for(int i=0;i<n;i++){
            edges.add(i, new ArrayList<>());
        }
    }

     public void addEdges( int src, int dest){
        edges.get(src).add(dest);
        edges.get(dest).add(src);

    }
     public List<List<Integer>> addEdges1( int src, int dest){
         edges.get(src).add(dest);
        edges.get(dest).add(src);
        return edges;
    }
}
