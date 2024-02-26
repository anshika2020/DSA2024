package LinkedListDS;

import java.util.ArrayList;
import java.util.List;

public class UpdateLinkedList {
    /*
    Given a reference to the head of a linked list and two values, m, and n, traverse the entire list keeping the first m elements followed by removing the next n elements. Return the resulting list.

Ex: Given the following head, m, and n…

1 -> 2 -> 3 -> null, m = 1, n = 1, return 1 -> 3 -> null.
Ex: Given the following head, m, and n…

1 -> 3 -> 2 -> 4 -> null, m = 2, n = 2, return 1 -> 3 -> null.

where m is the number of nodes to reatain from head and n is to remove the next number of node
     */
    static class Node{
        int val;
        Node next;
        public Node(int n){
            this.val=n;
            next=null;
        }
    }

    public static void updateLinkedList(Node head, int m,int n){
        // chek if the head is not null
        //check base case size is greater than m and n

        // first get first m nodes then remove next n nodes

        // make the head current node and create a temp node to save the rest next node oafter deletion
        Node currNode = head, nodeDeleteTill;
        if(currNode==null) return;
        //get a conter to keep track of  m and n
        int cnt=0;
        // now check ths
        while(currNode!=null){
            // get the first m nodes
            for(cnt=1;cnt<m&& currNode != null;cnt++){
                currNode = currNode.next;
            }
            // if current node reached to end then return
            if(currNode==null) return;

            // now put the current node in the temp node
            nodeDeleteTill = currNode.next;
            for(cnt=1; cnt<=n&&nodeDeleteTill!=null;cnt++){
                Node temp = nodeDeleteTill; // now store the node to delete in temp and in
                nodeDeleteTill=nodeDeleteTill.next; // store the next node in nodeDeleteTill
            }
            // Link the previous list with remaining nodes
            currNode.next = nodeDeleteTill;

            // set current Node pointer to next iteration
            currNode=nodeDeleteTill;
        }

    }

    /* Function to print linked list */
    static void printList( Node head)
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.printf("%d%s ", temp.val,"-->");
            temp = temp.next;
        }
        System.out.printf("\n");
    }
    public static void main(String[] args) {
        //1 -> 2 -> 3 -> null
        Node head =new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        printList(head);
        updateLinkedList(head,1,1);
        printList(head);

    }
}
