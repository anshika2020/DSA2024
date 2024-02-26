package trees;

import java.util.ArrayList;
import java.util.List;

public class BoundaryWalkTreeOrderTraversal {

    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int d){
            this.data= d;
        }
    }
    // handle an empty tree as a speical edge case

    // create a recusive function to execute on every node
     // function : dfs(node)
         // Base case: if lead node then do something if neccessary
          // recursive case: Not a leaf node

    // preoder
    // inorder
    // post oder

  // simple template
    /*
    function dfs(node)
 {
 // print out of add node value based on ordee traversal
    if node.left is not null
       dfs(node.left)
    if node.right is not null
        dfs(node.right)
     */

    /*
    Preorder traversal: root-->left--.right
     */

    static List<Integer> orderTraversal(Node root, String orderName){
        List<Integer> result = new ArrayList<>();

        if(orderName.equalsIgnoreCase("pre")) {
            preorderTraversal(root, result);
        }else if (orderName.equalsIgnoreCase("in")){
            inorderTraversal(root,result);
        }else{
            postOrderTraversal(root, result);
        }
        return result;
    }

    static void preorderTraversal(Node root,  List<Integer> result){
        // base case
        if(root==null) return;
            result.add(root.data);
            if (root.left != null) {
                preorderTraversal(root.left, result);
            }
            if (root.right != null) {
                preorderTraversal(root.right, result);
            }
    }
  //in order traversal: left-->root-->right
  static void inorderTraversal(Node root,  List<Integer> result){
      // base case
      if(root==null) return;
      if (root.left != null) {
          preorderTraversal(root.left, result);
      }
      result.add(root.data);
      if (root.right != null) {
          preorderTraversal(root.right, result);
      }
  }
    //post order  ; left-->right-->root
    static void postOrderTraversal(Node root,  List<Integer> result){
        // base case
        if(root==null) return;
        if (root.left != null) {
            preorderTraversal(root.left, result);
        }
        if (root.right != null) {
            preorderTraversal(root.right, result);
        }
        result.add(root.data);
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        // left nodes
        root.left = new Node(8);
        root.left.left = new Node(7);
        root.left.right = new Node(9);
        // right nodes
        root.right = new Node(12);
        root.right.left = new Node(11);
        root.right.right = new Node(14);
        System.out.println( orderTraversal(root,"pre"));
        System.out.println( orderTraversal(root,"in"));
        System.out.println( orderTraversal(root,""));
    }
}
