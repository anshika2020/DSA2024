package trees;

import java.util.*;

public class BfsLevelOrdeTraversal {
/*

BFS is kind of divide and conquere appraoch as lazy manager
 */
    static class TreeNode{
        int data;
         TreeNode left;
         TreeNode  right;
         public TreeNode(int d){
             this.data= d;
             left=right=null;
         }
    }
/*
 Advantages of BFS : queue:
 1)when  resource is shared among multiple consumers like CPU scheduling or disk scheduling
 2)When data is transferred between two processes like PIpes or File IO

                  Queue (Interface)
                         |
          |----------------------------------------------|
           Dequeue(Interface)                   PriorityQueue(Class)
           {LinkedList, ArrayDequeue}
 */
    // perform level oder traverse and represent the value in group per level: traversal is left to right, level by level
    static List<List<Integer>> bfsLevelOrderTrav(TreeNode root){
        // create a list of list to store the result
          List<List<Integer>> results = new ArrayList<>();
        // create a queue (FIFO)
        Queue<TreeNode> queue = new LinkedListDS.LinkedList<>();
        // add root to queue
        queue.add(root);
        // check while queue is not empty
        while(!queue.isEmpty()) {
            // create  a list to store the node's values
            List<Integer> tempList = new ArrayList<>();
            int count = queue.size();// have the conuter to get all level node in a group
            for(int i=0; i<count;i++) { // start the counter get the number of node at a level then add to temp list
                // remove the node
                TreeNode node = queue.remove(); // remove the present head and store in the node temporarily
                // add data to temp list
                tempList.add(node.data); // as we remove from queue , store in the list

                if (node.left != null) queue.add(node.left);  // if node.left is not null then add left node in the queue
                if (node.right != null) queue.add(node.right);//if node.right is not null then add right node in the queue

            }results.add(tempList);// Once temp list has the nodes of one level , add temp list to results which is list of list , keep on doing till queue is empty
        }
        return results;
    }
    //output we want : [[15,7],[9,20],[3]]
    static List<List<Integer>> BLeveltraversalInReverse(TreeNode root){
        List<List<Integer>> results = new ArrayList<>();// create a list of list to store list of results
        Queue<TreeNode> queue = new LinkedList<>(); // create a queue
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int count = queue.size();
            for(int i=0; i<count;i++){
                TreeNode node = queue.remove();
                temp.add(node.data);
                if(node.left!=null)queue.add(node.left);
                if(node.right!=null)queue.add(node.right);
            }

            results.add(temp);
        }
        Collections.reverse(results); // simplest way
        return results;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        //tc: O(n) for creating the tree and also for fetching at every level is O(n) because it is going one by one level till level n
        System.out.println(bfsLevelOrderTrav(root));

        System.out.println(BLeveltraversalInReverse(root));
    }
}
