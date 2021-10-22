package trees;

/*
This class is designed to create node for a tree
 */
public class Node {
    int data;
    LinkedListDS.Node right;
    LinkedListDS.Node left;
    protected Node(int d){
        this.data=d;
    }
}
