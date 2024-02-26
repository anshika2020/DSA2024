package LinkedListDS;

public class SinglyLinkedListOperations {
     Node head;
     Node tail;
     static class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next =null;
        }
         // add a node
         public void addNodeAtEnd(int data){
             Node endNode = new Node(data); // create a new Node
             Node temp = this;
             while(temp!=null){
                 temp = temp.next;
             }
             temp.next=endNode;


         }

     }


    /* Appends a new node at the end.  This method is
       defined inside LinkedList class shown above */
    public void append(int new_data)
    {
    /* 1. Allocate the Node &
       2. Put in the data
       3. Set next as null */
        Node new_node = new Node(new_data);

    /* 4. If the Linked List is empty, then make the
           new node as head */
        if (head == null)
        {
            head = new Node(new_data);
            return;
        }

    /* 4. This new node is going to be the last node, so
         make next of it as null */
        new_node.next = null;

        /* 5. Else traverse till the last node */
        Node last = head;
        while (last.next != null)
            last = last.next;

        /* 6. Change the next of last node */
        last.next = new_node;
        return;
    }
    // delete a node with given key
    /*
    Iterative approach
    1. find the previous node of the node to be deleted
    2. Change the next node to previous node
    3. free memory for node to be deleted
     */
    public void deleteNodeWithkey(int data){
        //store head node to current node
        Node current = head;
        Node temp=null; // creating temp node to store current node
        while(current!=null&&current.data!=data){
            temp = current;
            current = current.next;
        }
        if(current==null){
            return;
        }
        temp.next = current.next;
    }


    // Print LinkedList
    private void print(){
         Node node= head; // set node as head
        while (node != null) {
                System.out.print(node.data + " "); // print node data with space
                node = node.next; // set node as next node
            }
    }

    //create and print
    public static void main(String args[]){
         SinglyLinkedListOperations list = new SinglyLinkedListOperations();
         list.head = new Node(6);
         Node second = new Node(5);
         Node third = new Node(7);

         list.head.next = second;
         second.next = third;
         System.out.println("\nactual list:");
         list.print();

        list.append(4);
        System.out.println("\nafter node addition: ");
        list.print();



        list.deleteNodeWithkey(7);
        System.out.println("\nafter node deletion: ");
        list.print();
    }
}
