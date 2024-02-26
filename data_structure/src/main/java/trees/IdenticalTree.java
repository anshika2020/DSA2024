package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class IdenticalTree {
    static class Node{
        Node left;
        Node right;
        int val;

        public Node(int d){
            this.val=d;
            left=right=null;
        }
    }

    public static boolean isTreeIdentical(Node root1, Node root2){
        if(root1==null||root2==null) return false;

        // create two queues for both tree nodes
        Queue<Node> tree1 = new LinkedList<>();
        Queue<Node> tree2 = new LinkedList<>();

        if(root1.val!=root2.val)return false;

        tree1.add(root1);
        tree2.add(root2);

        while(!tree1.isEmpty() && !tree2.isEmpty()){
            ArrayList<Integer> list1 =new ArrayList<>();
            ArrayList<Integer> list2 =new ArrayList<>();
            int size = tree1.size();
            for(int i=0; i<size;i++){

                Node temp1 =tree1.poll();
                Node temp2= tree2.poll();
                list1.add(temp1.val);
                list2.add(temp2.val);
                    System.out.println(":::list1 : " + list1 + ":: list2 :" + list2);
                    if (temp1.left != null && temp2.left != null) {
                        tree1.add(temp1.left);
                        tree2.add(temp2.left);
                    }
                    if (temp1.right != null && temp2.right != null) {
                        tree1.add(temp1.right);
                        tree2.add(temp2.right);
                    }

                }
            if (!list1.containsAll(list2)) {
                return false;
            }
            }
        return true;

    }

    public static void main(String[] args) {

        Node root1 = new Node(5);
        root1.left =new Node(6);
        root1.right =new Node(7);

        Node root2 = new Node(5);
        root2.left =new Node(6);
        root2.right =new Node(9);

        System.out.println(isTreeIdentical(root1, root2));
    }
}
