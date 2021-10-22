package trees;
// insertion in BST
public class BstInsertion {
    //Data structure to store a binary search tree node

    static class Node{
        int data;
        Node left;
        Node right;
// constructor to create a binary tree having a key
        public Node(int d, Node left, Node right){
            this.data =d;
            this.left = left;
            this.right = right;
        }
        public Node(){ }
        public Node(int d){
            this.data = d;
        }
    }

    // function to perform inorder traversal of a tree.
    public static void inorder(Node root){
     if(root==null){
         return;
     }else{
         inorder(root.left);
         System.out.print(root.data + " ");
         inorder(root.right);
     }

    }

    // recursive function to insert key into BST
    public static  Node insert(Node root, int key){
        // if the root is null then create a new node and return
        if(root==null) {
            return new Node(key);
        }

        // if the given key is less than the root node, recur for left subtree
        if(key<root.data){
         root.left = insert(root.left,key);
        }else{
            root.right = insert(root.right,key);
        }
        return root;
    }

    //iterative version of insertion
    public static Node iterativeTraversal(Node root, int key){
        // start a root node
        Node current = root;
        Node parent = null;

        // if the root is null
        if(root ==null){
            return new Node(key);
        }
    // traverse the tree and find the parent node of the key
        while(current!=null){
            // update parent node as current node
            parent = current;
            if(key<current.data){
                current = current.left;
            }else {
                current = current.right;
            }

        }
        // construct a new node and assign to appropriate parent pointer
        if(key < parent.data){
            parent.left = new Node(key);
        }else {
             parent.right = new Node(key);
        }
        return root;
    }

    public static void main(String [] args){
        Node root = null;
        int arr[] ={13,24,34,5,6,23,45};
        // insert node
        for(int key : arr){
            root =insert(root,key);
           // root = iterativeTraversal(root,key);
        }
        inorder(root);

    }



}
