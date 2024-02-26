package trees.easy;

public class BalancedBSTfromGivenKeys {
/*
110. Balanced Binary Tree
 */
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int d) {
            this.data = d;
        }
    }
    /*
    Given an unsorted integer array that represents binary search tree keys, construct a heighted balanced BST from it.


     */
 // insert a node and we need one root and value
    public static Node insert(Node root, int keys){
        if(root==null){ // check if the root is null then create new node with value
            return new Node(keys); // creating new Node
        }
        System.out.println("Rootdata: "+ root.data);
        if(keys< root.data) { // if array value
            root.left = insert(root.left, keys);
            System.out.println("root.left.data :" + root.left.data);
        }else{
            root.right = insert(root.right,keys);
            System.out.println("root.right.data :" + root.right.data);
        }
        return root;
    }

    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left);
        System.out.print(root.data+",");
        inorder(root.right);
    }

    public static void main(String args[]){
        int keys[] = { 15, 10, 20, 8, 12, 16, 25 };

        Node root = null;
        for(int key:keys){
            root = insert(root,key);
        }
        inorder(root);
    }
}
