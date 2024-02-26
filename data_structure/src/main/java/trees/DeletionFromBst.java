package trees;


public class DeletionFromBst {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int val) {
            this.data = val;
        }
    }
    public static Node insert(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if(key < root.data) {
            root.left = insert(root.left, key);
        }else{
            root.right= insert(root.right, key);
        }
        return root;
    }

    /*
    Algorithm to cover all three cases: leaf node deletion, node deletion with one child, node deletion with two children
    1. create pointer to store parent node
    2.start with root node as current node
    3. search key in BST and set its parents pointer
    4. update parent node as current node
    5. if given key is less than current node then go left else right
    6. return if key is not found in the tree

     */
    public static Node deleteNode(Node root, int value) {
        if (root == null) {
            return null;
        }
        if (root.data > value) {
            root.left = deleteNode(root.left, value);
        } else if (root.data < value) {
            root.right = deleteNode(root.right, value);

        } else {
            // if nodeToBeDeleted have both children
            if (root.left != null && root.right != null) {
                Node temp = root;
                // Finding minimum element from right
                Node minNodeForRight = getMinimumValue(temp.right);
                // Replacing current node with minimum node from right subtree
                root.data = minNodeForRight.data;
                // Deleting minimum node from right now
                root.right = deleteNode(root.right, minNodeForRight.data);

            }
            // if nodeToBeDeleted has only left child
            else if (root.left != null) {
                root = root.left;
            }
            // if nodeToBeDeleted has only right child
            else if (root.right != null) {
                root = root.right;
            }
            // if nodeToBeDeleted do not have child (Leaf node)
            else
                root = null;
        }
        return root;
    }
    public static Node deleteNode2(Node root, int key) {
        if (root == null) return null;
        if (key < root.data) root.left = deleteNode(root.left, key);
        else if (key > root.data) root.right = deleteNode(root.right, key);
        else if (root.left == null) return root.right;
        else if (root.right == null) return root.left;
        else {
            root.data = getMinimumValue(root.right).data;
            root.right = deleteNode(root.right, root.data);
        }
        return root;
    }
public static Node getMinimumValue(Node root){
        if(root.left==null){
            return root;
        }else{
            return getMinimumValue(root.left);
        }

}
    public static void inorder(Node root){
        if(root==null){
            return;
        }
        inorder(root.left); //
        System.out.print(root.data+",");
        inorder(root.right);
    }

    public static void main(String arg[]){
        int[] keys = {15, 10, 20, 8, 12, 16, 25};
        Node root = null;
        for(int key:keys){
            root =insert(root,key);
        }
        System.out.println("Inorder traversal :");
        inorder(root);

        System.out.println("\ndelete the node");
        //deleteNode(root,8);
        deleteNode2(root,8);

        System.out.println("Inorder traversal :");
        inorder(root);



    }
}
