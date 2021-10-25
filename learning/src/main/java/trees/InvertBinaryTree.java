package trees;

public class InvertBinaryTree {

    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int d) {
            this.data = d;
        }
    }

    public static Node invertBT(Node root){
      if(root==null){
          return null;
      }

        System.out.println("root data: "+ root.data);
        Node left =invertBT(root.left); // first get all the left nodes
        Node right = invertBT(root.right);// get all the right nodes
      root.left = right;
      root.right = left;
        System.out.println("root return :" + root.data);

      return root;
    }

    public static void preOrderTraversal(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void main(String arg[]){
        Node node = new Node(4);
        node.left = new Node(2);
        node.left.left = new Node(1);
        node.left.right = new Node(3);
        node.right = new Node(7);
        node.right.left = new Node(6);
        node.right.right = new Node(9);

        preOrderTraversal(node);

        System.out.println("\nafter inversion");
        invertBT(node);
        preOrderTraversal(node);


    }
}
