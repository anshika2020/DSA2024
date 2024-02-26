package trees.easy;


public class IsValidBst {

    /*
    check if it a valid BST which means the left nodes would be less than root and right nodes would be greater than root
    DFS approach
     */

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int d){
            this.val = d;
        }
    }

//    private static boolean isBstValid(TreeNode root){
//       if(root==null) return false;
//       // create stack to store the nodes along with its left subtree
//        Stack<TreeNode> stack = new Stack<>();
//        // get a temp node call it previous to store the previous visited node of the binary tree
//        TreeNode prev = null;
//
//        // traverse the tree till stack is not empty
//        while(!stack.isEmpty()){
//            //push the root node and left subtree of each node into stack
//            TreeNode currentNode =  stack.push(root);
//            // check if the data value of previous is greater or equal to data value of current visited node or not
//            // found  true then return true else false
//        }
//        return false;
//    }

    public static boolean isBstValidTree(TreeNode root){
        return dfs(root,null, null);

    }
    private static boolean dfs(final TreeNode root, final Integer minValue, final Integer maxValue) {
        if(root== null){// if root is null then it  would return true because BST does not get effected by null
            return true;
        }
        // first check null case for both high and low then check whether min or max are less than or greater than root data.
        if((minValue!=null&&minValue>=root.val) ||maxValue!=null&&maxValue<=root.val) {
            return false;
        }else{
            // recursion steps for left side of root and right side of the node
            dfs(root.left,minValue, root.val);
            dfs(root.right, root.val, maxValue);
            return dfs(root.left,minValue, root.val)&&dfs(root.right, root.val, maxValue);
        }
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(250);
        root.left = new TreeNode(200);
        root.right = new TreeNode(300);
//        root.right.left = new TreeNode(275);
//        root.right.right = new TreeNode(7);
        System.out.println(isBstValidTree(root));
    }
}

