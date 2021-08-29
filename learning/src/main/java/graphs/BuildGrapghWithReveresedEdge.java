package graphs;

import java.util.*;

public class BuildGrapghWithReveresedEdge {
    static class Node
    {
        Integer val;
        Vector<Node> neighbours = new Vector<Node>(0);
        Node(Integer _val)
        {
            val = _val;
            neighbours.clear();
        }
    };


    static Node build_other_graph(Node node)
    {
        // create a queue
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Set<Integer> visited = new HashSet<>();
        visited.add(node.val);
        if(!queue.isEmpty()){
            Node current = queue.remove();
            System.out.println(current.val);
            for(Node n:current.neighbours ){
                if(!visited.contains(n.val)){
                    queue.add(n);
                    visited.add(n.val);
                }
            }
        }
        return node;
    }
}
