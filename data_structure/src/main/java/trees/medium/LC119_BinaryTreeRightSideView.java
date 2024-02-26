package trees.medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC119_BinaryTreeRightSideView {

    /*
    Given the root of a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

Example 1:

Input: root = [1,2,3,null,5,null,4]
Output: [1,3,4]
     */

    /*
    There are two apporaches using queue and just use list to maintin current and next level
     */

    // using queue
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root== null) return result;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int len = q.size();
            for(int i=0;i<len;i++){
                TreeNode node = q.remove();
               // now get the right most node val
               if(i==len-1){
                   result.add(node.val);
               }
               if(node.left!=null){
                   q.add(node.left);
               }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
        }
        return result;
    }
    // using current level and next level
    public static List<Integer> rightSideView1(TreeNode root) {
        List<Integer> resutl = new ArrayList<>();
        List<TreeNode> cur = new ArrayList<>();
        if(root!=null){
            cur.add(root);
        }
        while(!cur.isEmpty()){
            List<TreeNode> next = new ArrayList<>();
            resutl.add(cur.get(cur.size()-1).val);

            for(TreeNode node : cur){

                if(node.left!=null){
                    next.add(node.left);
                }
                if(node.right!=null){
                    next.add(node.right);
                }
                cur=next;
            }
        }
        return resutl;
    }

    public static class TreeNode {
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

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);

        node.left= new TreeNode(2);
        node.right= new TreeNode(3);

        node.left.right= new TreeNode(5);
        node.right.right= new TreeNode(4);

        System.out.println(rightSideView(node));
        System.out.println(rightSideView1(node));
    }
}
