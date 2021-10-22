package trees;


import java.util.*;

public class MaxValueInEachLevel {

    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
    /*
    GIven a binary tree, return the largest value in each of its levels
    like
            2
           /  \
         10     20
         output would be [2, 20]
      */

    // this program can be used for Binary tree and trie data structure
    private static List<Integer> getMaxValueEachLevel(TreeNode root){
        // create empty arryalist to store results
        List<Integer> results = new ArrayList<>();
        // check the base case
        if(root==null) return results;
        // create queue
        Queue<TreeNode> queue = new LinkedList<>();
        // add root to queue
        queue.add(root);
        // iterate till queue is not empty
        while(!queue.isEmpty()) {
            ArrayList<Integer> temp = new ArrayList<>();
            // remove the node and store in a temp node
            int count = queue.size();
            for(int i=0; i<count;i++) {
                TreeNode node = queue.remove();
                // take temp array to add values in
                temp.add(node.data);
                // check if left node is not null then add to queue
                if(node.left!=null){
                    queue.add(node.left);
                }
                // check if right node is not null then push to queue
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            // now compare values stored in arr and get the max
            int max = Collections.max(temp);
            // add max value to result
            results.add(max);
        }
        return results;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(9);
        root.right = new TreeNode(12);
        System.out.println(getMaxValueEachLevel(root));
    }

    }
