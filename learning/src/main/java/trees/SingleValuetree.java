package trees;

public class SingleValuetree {
 private static int count =0;
 private static int counter=0;
    static class TreeNode{
        int val;
        TreeNode left_ptr;
        TreeNode right_ptr;
        public TreeNode(int d){
            this.val = d;
        }
    }
    /*
    Single Value Tree

Given a binary tree, find the number of unival subtrees. An unival tree is a tree that has the same value in every node.

root: 5,

     */
    private  static int getUnivalueSubtree(TreeNode root){
        dfsHelper(root);
        return count;

    }

    private static  boolean dfs(TreeNode root){

        // base case 1
        if(root==null) return false;
        // base case 2 leaf nodes
        if(root.left_ptr==null&&root.right_ptr==null){
            count+=1; //
            return true; // single root value can be also unival hence returning true
        }
        boolean LuniValue=false;
        boolean RUnival = false;
        if(root.left_ptr!=null) {
            LuniValue = dfs(root.left_ptr); // This will keep on executinh until we reach Base case 2 i.e. Leaf Node

        }
        // check right node
        if(root.right_ptr!=null) {
             RUnival = dfs(root.right_ptr);
        }

        // Here we have traversed all nodes below Parameter root in the function
        System.out.println("root.val :" + root.val);
        if(RUnival&&LuniValue){// it will check above leaf node value condition
            //System.out.println("unival: left  in check: "+uniValue);
            if((root.left_ptr!=null&&root.left_ptr.val== root.val)||(root.right_ptr!=null&&root.right_ptr.val== root.val)){
                count+=1;
                return true;
            }
        }
        return false;
    }

    private static boolean dfsHelper(TreeNode root) {

        // base case 1
        if(root==null) return false;
        // base case 2 leaf nodes
        if(root.left_ptr==null&&root.right_ptr==null){
            System.out.println("counter " + counter++ + " root.val " + root.val+ " Leaf Node Base");
            count+=1; //
            System.out.println("incrementing counter in base case : "+ count);
            return true; // single root value can be also unival hence returning true
        }

        // recursive class
        boolean LUni = true; // Other than Base Case uniVal is initialized False
        boolean RUni = true;
        // check left node
        if(root.left_ptr!=null){
            LUni = dfsHelper(root.left_ptr); // This will keep on executinh until we reach Base case 2 i.e. Leaf Node
            //System.out.println("counter " + counter++ + " root.val " + root.val+ " Left Node Call " + " univalue "+ uniValue) ;

            // Above call will return True if it is Leaf Noe base case.
            if(root.left_ptr.val!=root.val){// it will check above leaf node value condition
              LUni = false;
            }
        }
        // check right node
        if(root.right_ptr!=null){
           // System.out.println(" left univalue before going right "+ uniValue);
            RUni = dfsHelper(root.right_ptr);
          //  System.out.println("counter " + counter++ + " root.val " + root.val+ " Right Node Call"+ " univalue after "+ uniValue);
            if(root.right_ptr.val!=root.val){
                RUni = false;
            }
        }

        // now check uunivalue uniValue and increase the counter by 1 if true
        if(RUni&&LUni){
            count+=1;
            System.out.println("incrementing counter "+ count);
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left_ptr = new TreeNode(5);
        root.right_ptr = new TreeNode(5);
        root.left_ptr.right_ptr = new TreeNode(5);
        root.left_ptr.left_ptr = new TreeNode(5);
        root.right_ptr.right_ptr = new TreeNode(5);
        root.right_ptr.left_ptr = new TreeNode(4);
        System.out.println(getUnivalueSubtree(root));
    }
    }
