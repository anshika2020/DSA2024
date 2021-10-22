package LinkedListDS;

public class InsertANodeAtPosition {

    static class Node{
        int data;
        Node next;

        public Node(int d){
            this.data = d;
        }

    }

    static class LinkedList {
        Node head;

        // Method to insert a new node
        public static LinkedList addNode(LinkedList list, int data)
        {
            // Create a new node with given data
            Node new_node = new Node(data);
            new_node.next = null;

            // If the Linked List is empty,
            // then make the new node as head
            if (list.head == null) {
                list.head = new_node;
            }
            else {
                // Else traverse till the last node
                // and insert the new_node there
                Node last = list.head;
                while (last.next != null) {
                    last = last.next;
                }

                // Insert the new_node at last node
                last.next = new_node;
            }
            // Return the list by head
            return list;
        }


        public void print() {
            if (this.head == null) {
                return;
            }
            //print all nodes
            Node tempNode = this.head;
            while (tempNode != null) {
                System.out.print(tempNode.data + "->");
                tempNode = tempNode.next;
            }
            System.out.println("NULL");
        }
    }
    private static Node insertNodeAtPosition(Node head, int position, int data){
        LinkedList list = new LinkedList();
        Node newNode = new Node(data);
        Node currentNode = head;
        int index =0;
        while(index<position-1){
            currentNode = currentNode.next;
            index++;
        }
        newNode.next = currentNode.next;
        currentNode.next = newNode;

        return head;
    }

    public static void main(String args[]){
        LinkedList list = new LinkedList();
        list.addNode(list,2);
        list.addNode(list,4);
        list.addNode(list,5);
        list.addNode(list,7);
        list.addNode(list,8);
        list.print();
        System.out.println(insertNodeAtPosition(list.head,1,6));
        list.print();
    }



}
