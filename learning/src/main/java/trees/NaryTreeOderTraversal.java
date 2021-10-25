package trees;

import java.util.*;

public class NaryTreeOderTraversal {
    /*
       output would
     */
    static class TreeNode {
        int val;
        List<TreeNode> children = new LinkedList<>();

        public TreeNode(int val, List<TreeNode> children) {
            this.val = val;
            this.children = children;
        }

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode() {
        }
    }


    static List<List<Integer>> getNaryTreeBSF(TreeNode root){
        List<List<Integer>> results = new ArrayList<>();
        if(root==null) return results;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int count = queue.size();
            for(int i=0; i<count;i++){
                TreeNode node = queue.remove();
                temp.add(node.val);
                for(TreeNode n : node.children){
                    queue.add(n);
                }
            }
            results.add(temp);
        }
        return results;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.children.add(new TreeNode(3));
        root.children.get(0).children.add(new TreeNode(5));
        root.children.get(0).children.add(new TreeNode(6));
        root.children.add(new TreeNode(2));
        root.children.add(new TreeNode(4));



        System.out.println(getNaryTreeBSF(root));
    }

}