package trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PrintAllPathOFtree {
    static class TreeNode {
        int val;
        TreeNode left_ptr;
        TreeNode right_ptr;

        public TreeNode(int d) {
            this.val = d;
        }
    }
    /*
    Print All Paths Of A Tree
Given a binary tree, return all paths from root to leaf.
Example One
Input:
         root: 1, 1L: 2, 2L : 4, 2R:5, 1R: 3, 3L:6, 3R:7
         output : [[1,2,4],[1,2,5],[1,3,6][1,3,7]
     */

    public static List<List<Integer>> getAllPath(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
      //  List<Integer> slate = new ArrayList<>();
        //dfshelper(root, results, new Integer[5],0);
        dfshelper1(root, results, new ArrayList<>());
        return results;
    }

    private static void dfshelper1(TreeNode root, List<List<Integer>> results, List<Integer> temp) {
        List<Integer> path = new ArrayList<>();
        // check base case
        if (root == null) {
            return;
        }

        int num = root.val;
        temp.add(num);
        // Check base case for child node
        if (root.left_ptr == null && root.right_ptr == null) {
            results.add(new ArrayList<>(temp));
            return;
        }

        if(root.left_ptr!=null) {
            dfshelper1(root.left_ptr, results, temp);
            temp.remove(temp.size()-1);
        }
        if(root.right_ptr!=null) {
            dfshelper1(root.right_ptr, results, temp);
            temp.remove(temp.size()-1);
        }
    }


    private static void dfshelper(TreeNode root, List<List<Integer>> results, Integer [] temp , int len) {
          List<Integer> path = new ArrayList<>();
        // check base case
        if (root == null) {
            return;
        }

        temp[len] = root.val;
        len++;
        // Check base case for child node
         // int num[] = {root.val};

        if (root.left_ptr == null && root.right_ptr == null) {
            for(int i=0; i<len;i++) {
                 path.add(temp[i]);
            }
            results.add(path);
        }

        if(root.left_ptr!=null) {
            dfshelper(root.left_ptr, results, temp, len);
            dfshelper(root.left_ptr, results, temp, len);

        }
        if(root.right_ptr!=null) {
            dfshelper(root.right_ptr, results, temp, len);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left_ptr = new TreeNode(2);
        root.right_ptr = new TreeNode(3);
        root.left_ptr.right_ptr = new TreeNode(5);
        root.left_ptr.left_ptr = new TreeNode(4);
        root.right_ptr.right_ptr = new TreeNode(7);
        root.right_ptr.left_ptr = new TreeNode(6);

        System.out.println(getAllPath(root));
    }
}
