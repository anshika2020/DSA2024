package trees;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePath {
    /*
    Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3
     */

    static class Node {
        int data;
       Node left;
       Node right;
        public Node(int d) {
            this.data = d;
        }
    }
    public static List<String> binaryTreePaths(Node root) {
        List<String> list = new ArrayList<>();

         if(root==null){
            return list;
         }
        String currPath = Integer.toString(root.data);
         if(root.left==null&&root.right==null){
            list.add(currPath);
         }
         if(root.left!=null){
             getPathWithDfs(root.left,currPath,list);

         }
           if(root.right!=null){  getPathWithDfs(root.right,currPath,list);

         }
         return list;
    }
    public static void getPathWithDfs(Node root, String currPath, List<String> list){
        currPath+= "->"+ root.data;



        if (root==null){
            list.add(currPath);
        }
        if(root.left==null&&root.right==null){
            list.add(currPath);
        }
        if(root.left!=null) getPathWithDfs(root.left,currPath,list);
        if(root.right!=null) getPathWithDfs(root.right,currPath,list);

    }

    // find binary tree path
    public static List<String> findPaths(Node root){
        List<String> result = new ArrayList<>();
        helper(root, result, "");
        return result;
    }
    public static void helper(Node root,List<String> result,String path){
        // first check root node is not null
        if(root==null) return;

        // first aadd the root val in path
        path+=root.data;
        // now get all left and right node values
        if(root.left==null&&root.right==null){
            result.add(path);
        }else{
            path+="-->";
            helper(root.left, result, path);
            helper(root.right, result, path);
        }
    }

   public static void main(String str[]){
       Node node = new Node(1);
       node.left = new Node(3);
      // node.left.right = new Node(5);
      // node.left.left = new Node(1);

       node.right = new Node(3);
       node.right.right = new Node(2);
       System.out.println(binaryTreePaths(node));
       System.out.println(
               findPaths(node));
   }
}
