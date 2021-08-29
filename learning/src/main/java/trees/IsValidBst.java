package trees;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class IsValidBst {

    /*
    check if it a valid BST which means the left nodes would be less than root and right nodes would be greater than root
    DFS approach
     */

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int d){
            this.val = d;
        }
    }

    private static boolean isBstValid(TreeNode root){
       if(root==null) return false;
       // create stack to store the nodes along with its left subtree
        Stack<TreeNode> stack = new Stack<>();
        // get a temp node call it previous to store the previous visited node of the binary tree
        TreeNode prev = null;

        // traverse the tree till stack is not empty
        while(!stack.isEmpty()){
            //push the root node and left subtree of each node into stack
            TreeNode currentNode =  stack.push(root);
            // check if the data value of previous is greater or equal to data value of current visited node or not
            // found  true then return true else false
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(100);
        root.left = new TreeNode(200);
        root.right = new TreeNode(300);
//        root.right.left = new TreeNode(275);
//        root.right.right = new TreeNode(7);
        System.out.println(isBstValid(root));
    }
}

