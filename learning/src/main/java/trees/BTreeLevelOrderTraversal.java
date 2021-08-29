package trees;

import java.util.*;

public class BTreeLevelOrderTraversal {

    static class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }
    }
    /*
    B-tree level travewrsal :
           3
          /  \
        9     20
              /  \
            15     7

            output: [[3],[9,20],[15,7]]


            if we want output like
     */

    // iterative approach

    private static List<List<Integer>> btreeLevelTraversalBsf(TreeNode root){

        List<List<Integer>> result = new ArrayList<>();
        // check base case
        if(root==null){
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){

            // count item in queue
            int count = queue.size();
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i=0; i<count;i++) {
                // remove the node from queue
                TreeNode node = queue.remove();
                // add value to temp
                temp.add(node.data);
                // add children to queue
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            result.add(temp);
        }
        return result;
    }


    //preorder traversal
    /* root , left , right
    Algorithm Preorder(tree)
   Create an empty stack nodeStack and push root node to stack.
2) Do the following while nodeStack is not empty.
….a) Pop an item from the stack and print it.
….b) Push right child of a popped item to stack
….c) Push left child of a popped item to stack
     */
    static ArrayList<Integer> preorderDfs(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        // create a stack : out[0,1,3,4,2]
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);

        while (!stack.isEmpty()) {
            int count = stack.size();
            // for(int i=0; i<count;i++){
            TreeNode node = stack.peek();
            result.add(node.data);
            stack.pop();
            // add left and right children to stack

            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }

            //}
        }
        return result;

    }

    // another apporach for preorder
//root , left , right
    public void preorderIteration(TreeNode root) {
        Stack<TreeNode> s = new Stack<TreeNode>();
        while (true) {
            // First print the root node and then add left node
            while (root != null) {
                System.out.print(root.data + " ");
                s.push(root);
                root = root.left;
            }
            // check if Stack is emtpy, if yes, exit from everywhere
            if (s.isEmpty()) {
                return;
            }
            // pop the element from the stack and go right to the tree
            root = s.pop();
            root = root.right;
        }
    }

    //post oder(Left, Right, Root)
    /*
    1.1 Create an empty stack
2.1 Do following while root is not NULL
    a) Push root's right child and then root to stack.
    b) Set root as root's left child.
2.2 Pop an item from stack and set it as root.
    a) If the popped item has a right child and the right child
       is at top of stack, then remove the right child from stack,
       push the root back and set root as root's right child.
    b) Else print root's data and set root as NULL.
2.3 Repeat steps 2.1 and 2.2 while stack is not empty.

     Push directly root node two times while traversing to the left.
     While poping if you find stack top() is same as root then go for root->right else print root.*/
    public static void postorderIterationBsf(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while(true) {
            while(root != null) {
                stack.push(root);// pushing directly root node two times
                stack.push(root);
                root = root.left; // setting root to left
            }

            // Check for empty stack
            if(stack.empty()) return;
            root = stack.pop();

            if(!stack.empty() && stack.peek() == root){
                root = root.right;
            }

            else {

                System.out.print(root.data + " "); root = null;
            }
        }

    }
    /*
    Postorder (Left, Right, Root) : 4 5 2 3 1
    1.1 Create an empty stack
2.1 Do following while root is not NULL
    a) Push root's right child and then root to stack.
    b) Set root as root's left child.
2.2 Pop an item from stack and set it as root.
    a) If the popped item has a right child and the right child
       is at top of stack, then remove the right child from stack,
       push the root back and set root as root's right child.
    b) Else print root's data and set root as NULL.
2.3 Repeat steps 2.1 and 2.2 while stack is not empty.
     */
    static ArrayList<Integer> postOrderDfs(TreeNode root) {
        ArrayList<Integer> result = new ArrayList<>();
        // create a stack : out[0,1,3,4,2]
        Stack<TreeNode> stack = new Stack<>();
       // stack.push(root);
        while (!stack.isEmpty()) {
            if(root!=null){
                stack.push(root);
                root = root.left;

            }
            int count = stack.size();
            for (int i = 0; i < count; i++) {
                TreeNode node = stack.peek();
                result.add(node.data);
                stack.pop();

                // add left and right children to stack
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }

            }
        }
        return result;

    }

    // another version using queue


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
       // System.out.println("preoder traversal");
       // System.out.println(btreeLevelTraversalBsf(root));



        //preorder

        TreeNode root1 = new TreeNode(0);
        root1.left = new TreeNode(1);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
       // System.out.println(preorderDfs(root1));
      //  System.out.println(postOrderDfs(root1));
        postorderIterationBsf(root1);
    }
}
