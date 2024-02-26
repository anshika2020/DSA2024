package trees;

public class MaximumDepthOfBT {

  static class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
    TreeNode() {}
     TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
        this.left = left;
        this.right = right;
    }
 }
    /*
    Given the root of a binary tree, return its maximum depth.

     A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

     Input: root = [3,9,20,null,null,15,7]
Output: 3

         3
        / \
      9    20
           / \
          15  7
     */

    public static int getMaxDepth(TreeNode root){
        if(root==null) {
            return 0;
        }else{
            int leftDepth= getMaxDepth(root.left);
            int rightDepth=getMaxDepth(root.right);
            return Math.max(leftDepth,rightDepth)+1;
        }
    }
     public static void inorderTraversal(TreeNode node){

        if(node==null){
            return;
        }
        inorderTraversal(node.left);
         System.out.print(node.val+" ");
         inorderTraversal(node.right);
     }



     //BFS

     public static void main(String args[]){
        TreeNode t =new TreeNode();
        //t.left = new TreeNode(9);
        // t.right = new TreeNode(20);
        // t.right.left = new TreeNode(15);
        // t.right.right = new TreeNode(7);
         //t.left = new TreeNode(9);
        inorderTraversal(t);
         System.out.println("\n");
         System.out.println(getMaxDepth(t));
     }

}
