package trees;

public class TraversalBst {


    // tree insersion
    public static LinkedListDS.Node insert(LinkedListDS.Node root, int key){
        if(root==null){
            return new LinkedListDS.Node(key);
        }
        if(key< root.data){
            root.left = insert(root.left,key);
        }else{
            root.right= insert(root.right,key);
        }
        return root;
    }

    // inorder traversal
    /*
    algorithm:
    1.check if the current node is not null
    2.traverse left sub tree
    3. Print value of the root data or visit the root
    4. traverse right sub tree
     */

    public static void inorder(LinkedListDS.Node root){
        if(root==null){
            return;
        }

        inorder(root.left); //
       // System.out.print(root.data+",");
       // System.out.print(root.left.data+" ");
       System.out.print(root.data+",");

        inorder(root.right);
       // System.out.println(root.right.data);
    }



    // preorder traversal

    /*Algorithm:
    1. check if the current node is not null
    2. Print value of the root data or visit the root
    3.traverse left sub tree
    4.Traverse right sub tree
     */

    public static void preorder(LinkedListDS.Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+",");
        preorder(root.left);
        preorder(root.right);
    }

    // postorder traversal

    /*Algorithm:
    1. check if the current node is not null
    2.traverse left sub tree
    3.Traverse right sub tree
    4.Print value of the root data or visit the root
     */

    public static void postTraversal(LinkedListDS.Node node){
        if(node==null){
            return;
        }
        postTraversal(node.left);
        postTraversal(node.right);
        System.out.print(node.data+",");
    }
    public static void main(String arg[]){

        //int arr[] = {13,24,34,5,6,23,45};
//        int arr[] = {3,2,5};
//        Node root= null;
//        for(int key:arr){
//           root = insert(root,key);
//        }

       LinkedListDS.Node root1 = new LinkedListDS.Node(3);
        root1.left = new LinkedListDS.Node(9);
        root1.right = new LinkedListDS.Node(20);
        root1.right.left = new LinkedListDS.Node(15);
        root1.right.right = new LinkedListDS.Node(7);
        System.out.println("Inorder traversal :");
        inorder(root1);
        System.out.println("\nPreorder traversal :");
        preorder(root1);
        System.out.println("\nPostorder traversal :");
        postTraversal(root1);
    }
}
