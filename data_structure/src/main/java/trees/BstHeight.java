package trees;

public class BstHeight {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int d) {
            this.data = d;
        }
    }
    public static int getHeight(Node root){
        // Base case: empty tree has height 0
        if(root==null){
            return 0;
        }
            // recur for left and right subtree and consider maximum depth
            return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }

    // another approach
    public static int height(Node root){
        if(root==null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rtHeight = height(root.right);
        if (leftHeight>rtHeight){
           return leftHeight+1;
        }else{
            return rtHeight+1;
        }

    }

    public static void main(String arg[]){
        Node node = new Node(5);
        node.left = new Node(3);
       // node.left.left = new Node(1);
      //  node.left.right = new Node(4);
        node.right = new Node(8);
       // node.right.left = new Node(6);
      //  node.right = new Node(9);
        System.out.println(getHeight(node));
        System.out.println(height(node));

    }
}
