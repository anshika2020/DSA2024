package trees;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class IterativeTreeOderTraversal {
    // using stack
    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int d){
            this.data= d;
        }
    }

    private static void preOder(Node root){
        // create stack
        List<Integer> results = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){

            Node node = stack.pop();
            results.add(node.data);// preorder
            if(node.right!=null){
                stack.push(node.right);
            }
            if(node.left!=null){
                stack.push(node.left);
            }

        }
        System.out.println(results);
    }/*
    #create an empty stack
    #Start from root node and set current node to root node
    #while stack is not empty and curent node is not null , then we are done
    #check if current node is not null and current node exist then push it stack and set current to left child
   #if current node is null then just pop the current node , print the value or add in the list
   #set current node to right node

    */
    private static void inorder(Node root){
        // create stack
        List<Integer> results = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node current = root;
        while(!stack.isEmpty()||current!=null){
           if(current!=null){
               stack.push(current);
               current = current.left;
           }else{
               current = stack.pop();
               results.add(current.data );
               current = current.right;

           }
        }
        System.out.println(results);
    }

    /*Post order
    #create an empty stack
    #Start from root node and set current node to root node
    #while stack is not empty and curent node is not null , then we are done
    #check if current node is not null and current node exist then push it stack and set current to left child
   #if current node is null then just pop the current node , print the value or add in the list
   #set current node to right node

    */

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

      //  preOder(root);
        inorder(root);
    }
}
