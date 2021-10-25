package trees;


import java.util.*;

public class ZigZiagLevelOrderTraversal {

     static class TreeNode {
        Integer data;
         TreeNode right;
         TreeNode left;
        protected TreeNode(Integer d){
            this.data=d;
        }
        public TreeNode(){

        }
    }

    /* preorder traversal
    root : 3
         /   \
        9     20
               / \
             15   7

             output: [[3],[20,9],[15,7]]
     */

    /*
    Algo:
    1. ceate a queue
    2. Add root to queue
    3.loop with while until queue is empty
    4. count the nodes in Q  and add to temp List of arraylist

    for i=0;i<count
    Node =q.remove
    temp.add(node.val)
    add value to result
    add children to queue
    add  temp to result
    end while
    return result

     TC: O(n)
     SC: (n)
     */

   private static List<List<Integer>> zigZagtraversal(TreeNode root ) {
       // create a list of list
       List<List<Integer>> results = new ArrayList<>();
       if(root==null) return results;
       Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       boolean reverse= false;
       while (!queue.isEmpty()){
           ArrayList<Integer> temp = new ArrayList<>();
           int count = queue.size();
           for(int i=0;i<count;i++){
            TreeNode node = queue.remove();
            temp.add(node.data);
            if(node.left!=null) queue.add(node.left);
            if(node.right!=null) queue.add(node.right);
           }
           if(reverse){
               Collections.reverse(temp);
           }
           results.add(temp);
           reverse = !reverse;
       }
       return results;
   }

    private static List<List<Integer>> zigZagtraversal1(TreeNode root ) {
        // create a list of list
        List<List<Integer>> results = new ArrayList<>();
        if(root==null) return results;
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        queue.add(root);
        queue.add(null);
        boolean leftTright = false;
        while (!queue.isEmpty()){
                TreeNode node = queue.remove();
                if(node==null){
                    leftTright= !leftTright;
                    if(!queue.isEmpty()) {
                        queue.add(null);
                    }
                    results.add(new ArrayList<>(temp));
                    temp = new ArrayList<>();
                }else {
                    temp.add(node.data);
                    if(leftTright) {
                        if (node.left != null) queue.add(node.left);
                        if (node.right != null) queue.add(node.right);
                    }else {
                        if (node.right != null) queue.add(node.right);
                        if (node.left != null) queue.add(node.left);
                    }
                }
        }
        return results;
    }

    public static void main(String[] args) {
      TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        TreeNode root1 = new TreeNode(); // to check base case
        System.out.println(zigZagtraversal1(root));
        System.out.println(zigZagtraversal(root));
    }
}
