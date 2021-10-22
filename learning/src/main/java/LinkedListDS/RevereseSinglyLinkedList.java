package LinkedListDS;

public class RevereseSinglyLinkedList {
    private static Node head;
     static class Node{
        Node next;

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }

        Object data;
        public Node(Object d){
            this.data = d;
        }
    }

//    static class SinglyLinkedList {
//        Node head;
//        public SinglyLinkedList(){
//
//        }
//
//        public SinglyLinkedList addNode(SinglyLinkedList list,Object d) {
//            Node newNode = new Node(d);
//            newNode.next = list.head;
//            list.head = newNode;
//            return list;
//
//        }
//    }

/*Initialize three pointers prev as NULL, curr as head and next as NULL.
Iterate through the linked list. In loop, do following.
// Before changing next of current,
// store next node
next = curr->next
// Now change next of current
// This is where actual reversing happens
curr->next = prev
// Move prev and curr one step forward
prev = curr
curr = next

 */
    public static Node reverseLinkedList(Node node){
        Node prev = null;
        Node curr = node;
        Node nextTemp = null;
        while (curr != null) {
            nextTemp= curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        node = prev;
        return node;
    }

    private static void display(Node node){
        while(node!=null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String arg[]){

        Node head = new Node("Dog");
        head.next = new Node("Eat");
        head.next.next = new Node("Sweet");
        head.next.next = new Node("Cat");
        display(head);
        reverseLinkedList(head);
        System.out.println("\n");
        display(head);

    }
}
