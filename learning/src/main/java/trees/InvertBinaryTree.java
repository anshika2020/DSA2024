package trees;

public class InvertBinaryTree {

    public static treeProgams.Node invertBT(treeProgams.Node root){


      if(root==null){
          return null;
      }

        System.out.println("root data: "+ root.data);
        treeProgams.Node left =invertBT(root.left); // first get all the left nodes
        treeProgams.Node right = invertBT(root.right);// get all the right nodes
      root.left = right;
      root.right = left;
        System.out.println("root return :" + root.data);

      return root;
    }

    public static void preOrderTraversal(treeProgams.Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public static void main(String arg[]){
        treeProgams.Node node = new treeProgams.Node(4);
        node.left = new treeProgams.Node(2);
        node.left.left = new treeProgams.Node(1);
        node.left.right = new treeProgams.Node(3);
        node.right = new treeProgams.Node(7);
        node.right.left = new treeProgams.Node(6);
        node.right.right = new treeProgams.Node(9);

        preOrderTraversal(node);

        System.out.println("\nafter inversion");
        invertBT(node);
        preOrderTraversal(node);


    }
}
