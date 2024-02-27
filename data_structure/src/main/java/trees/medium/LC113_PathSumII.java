package trees.medium;

import java.util.ArrayList;
import java.util.List;

public class LC113_PathSumII {
    /*
    Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values in the path equals targetSum. Each path should be returned as a list of the node values, not node references.

A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.

Input: root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
Output: [[5,4,11,2],[5,8,4,5]]
Explanation: There are two paths whose sum equals targetSum:
5 + 4 + 11 + 2 = 22
5 + 8 + 4 + 5 = 22
     */

    /*
    Recursive apporach is right to find all passible path which sum is equal to target DFS appraoch
    1. Need List of lists to store all possibles paths matches with target only,
    2. List to store the found path
    3. int sum to calculate the sum
    4. create a helper method which will make recurvise vall for left and right both if left or right is not null
        -- There are two base cases :
            --backtracking base case if node == null then add sum to temp list and calculculate the sum of temp list
            --if right node and left are null then add the sum to list of list if sum == target

        --remove the last node from current path, this is called backtracking
     */
    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, targetSum, result, new ArrayList<>());
        return result;
    }

    public static void helper(TreeNode root, int targetSum,  List<List<Integer>> result, List<Integer> slate){
        // base case for back tracking
        if(root==null){
            return;
        }
        int sum =0;
        slate.add(root.val);
        // now the sum of slate list elements
        for(int n : slate){
            sum +=n;
        }

        // base case for recursive call
        if(root.left ==null &&root.right==null){
            // need to compare sum with target and add to final result list
            if(sum==targetSum) {
                System.out.println(slate);
                result.add(new ArrayList<>(slate));
            }
        }

        // make recursive call for left nodes
        if(root.left!=null){
            helper(root.left, targetSum,result,slate);
        }
        if(root.right!=null){
            helper(root.right, targetSum,result,slate);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        //[5,4,8,11,null,13,4,7,2,null,null,5,1]
        TreeNode node = new TreeNode(5);
        node.left = new TreeNode(4);
        node.right = new TreeNode(8);

        node.left.left = new TreeNode(11);

        node.left.left.right = new TreeNode(2);
        node.left.left.left = new TreeNode(7);

        node.right.left = new TreeNode(4);
        node.right.right = new TreeNode(13);

        node.right.right.left = new TreeNode(5);
        node.right.right.right = new TreeNode(1);
        System.out.println(pathSum(node, 27));
    }
}
