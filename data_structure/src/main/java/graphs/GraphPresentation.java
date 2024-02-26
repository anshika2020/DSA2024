package graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphPresentation {
    // node class to create nodes
    class Node{
        int val;
        public List<Node> adjList = new ArrayList<>();
        public Node(int k){
            this.val=k;
        }
    }

    public void addEdges(int src, int dest){
        Node source = new Node(src);
        Node destinationb = new Node(dest);
        source.adjList.add(destinationb);
        destinationb.adjList.add(source);
    }
}
