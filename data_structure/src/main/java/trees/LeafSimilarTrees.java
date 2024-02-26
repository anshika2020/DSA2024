package trees;

import java.util.ArrayList;
import java.util.List;

public class LeafSimilarTrees {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int d) {
            this.data = d;
        }
    }
    /*
    consider all leaves of binay tree, from left to right order, the values of those leaves from a leaf value sequence
    for example
         3
       /  \
      5    1
     / \   / \
    6   2  9  8
        /\
       7  4


         3
       /  \
      5    10
     / \   / \
    6   2  9  8
        /\
       7  4




    In the given tree above,the leaf value sequence is (6,7,4,9,8)
    Two binary tree are considered leaf similar if their leaf values sequence is same.
   Both of them have similar leaves Tree A &B { 6,7,4,9,8}

     */

    public static boolean areleafSimilar(Node tree1, Node tree2){

        List<Integer> leaves1 =new ArrayList<>();
        List<Integer> leaves2=new ArrayList<>();
        addLeaves(tree1,leaves1);
        addLeaves(tree2,leaves2);
        if(leaves1.size()!=leaves2.size()) {
            return false;
        }
            for (int i = 0; i <leaves1.size(); i++) {
                if (leaves1.get(i) != leaves2.get(i)) {
                    return false;
                }
                System.out.println(" leaves1 : " + leaves1.get(i) + " leaves2: " + leaves2.get(i));
            }
            return true;

    }

    private static void addLeaves(final Node tree, final List<Integer> leaves) {

        if(tree==null){
            return;
        }
        if(tree.left==null&&tree.right==null){
            System.out.println("added leaves: "+tree.data);
            leaves.add(tree.data);
        }
        addLeaves(tree.left,leaves);
        addLeaves(tree.right,leaves);
    }

    public static void inorderTraversal(Node node){
       if(node==null){
           return;
       }
       inorderTraversal(node.left);
        System.out.print(node.data+" ");
        inorderTraversal(node.right);
    }

    public static void main(String args[]){
        Node t1 = new Node(3);
        t1.left = new Node(5);
        t1.left.left = new Node(6);
        t1.left.right = new Node(2);
        t1.left.right.left = new Node(7);
        t1.left.right.right = new Node(4);
        t1.right = new Node(1);
        t1.right.left = new Node(9);
        t1.right.right = new Node(8);



        Node t2 = new Node(3);
        t2.left = new Node(5);
        t2.left.left = new Node(6);
        t2.left.right = new Node(7);
        t2.right = new Node(1);
        t2.right.left = new Node(4);
        t2.right.right = new Node(2);
        t2.right.right.left = new Node(9);
        t2.right.right.right = new Node(8);

        inorderTraversal(t1);
        System.out.println("\n");
        inorderTraversal(t2);

        System.out.println("\n");
        System.out.println("\n"+areleafSimilar(t1,t2));

    }
}
