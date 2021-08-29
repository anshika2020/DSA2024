package trees;

import LinkedListDS.LinkedList;

import java.util.ArrayList;
import java.util.List;

public class PathSum {
    private static boolean flag;

    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int d){
            this.data= d;
        }
    }
    // given a binary tree and a sum , determine if the tree has a root to leaf path such that adding up all values with be equal to given target
    /*
           5
         /   \
       4      7
      / \      \
     9    2      8

     target sum  = 11
     */

    private static boolean hasPathSum(Node root, int target){
        flag =false;
        isPathSumHelper(root,target);
        return flag;
    }
    private static void isPathSumHelper(Node root, int target) {
        // base case 1
        if(root==null) return;
        // base case2
        if(root.left==null&&root.right==null&&root.data==target){
            flag = true;
            return;
        }
        if(root.left!=null){
           isPathSumHelper(root.left,(target-root.data));
        }
        if(root.right!=null){
             isPathSumHelper(root.right,(target-root.data));
        }
    }

    public static void main(String[] args) {
        Node root = new Node(5);
        root.left = new Node(4);
        root.left.left = new Node(11);
        root.left.left.left = new Node(7);
        root.left.left.right = new Node(2);
        root.right = new Node(8);
        root.right.left = new Node(13);
        root.right.right = new Node(4);
        root.right.right.right = new Node(1);
       // isPathSum(root,21);
        System.out.println( hasPathSum(root,21));

    }
}
