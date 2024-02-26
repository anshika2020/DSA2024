package trees;

public class SearchKeyInBst {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    // search key

    //1. recursive function to insert a key into BST
    public static Node insert(Node root, int data) {
        if (root == null) {
            return new Node(data);
        }
        if (data < root.data) {
            root.left = insert(root.left, data);
        } else {
            root.right = insert(root.right, data);
        }
        return root;
    }

    // search for the key

    public static void searchKey(int key, Node root, Node parent) {
        if (root == null) {
            System.out.println("key not found");
            return;
        }
        // if key found
        if (root.data == key) {
            if (parent == null) {
                System.out.println("Key the the root node ");
            } else if (key < parent.data) {
                System.out.println("Key is found in left node " + parent.data);
            } else {
                System.out.println("Key is found in right node " + parent.data);
            }
            return;
        }
        // if given key is less than the root node, recur for left subtree
        // else recur for right subtree

        if (key < root.data) {
            searchKey(key, root.left, root);
        } else {
            searchKey(key, root.right, root);
        }

    }

    public static Node search(Node root, int key) {
        if (root == null || root.data == key) {
            return root;
        } else {
            return key < root.data ? search(root.left, key) : search(root.right, key);
        }
    }

    public static void main(String arg[]) {
        int[] keys = {15, 10, 20, 8, 12, 16, 25};
         Node root = null;
         for(int key:keys){
             root =insert(root,key);
         }
        // searchKey(15   ,root,null);
       search(root,12);
       System.out.println("The key found  : "+root.data);
    }



}
