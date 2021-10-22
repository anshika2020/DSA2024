package LinkedListDS;

public class FindMiddleNodeOfLinkedList {
    private static Node head;
    /**
     * Java program to find middle element of linked list in one pass.
     * In order to find middle element of a linked list
     * we need to find the length first but since we can only
     * traverse linked list one time, we will have to use two pointers
     * one which we will increment on each iteration while
     * other which will be incremented every second iteration.
     * So when the first pointer will point to the end of a
     * linked list, second will be pointing to the middle
     * element of a linked list
     */



    public static void getMidlleElemeWithLinear() {
        //creating LinkedList with 5 elements including head
        LinkedList linkedList = new LinkedList();
        head = linkedList.getHead();
        linkedList.addNode( new Node("1"));
        linkedList.addNode( new Node("2"));
        linkedList.addNode( new Node("3"));
        linkedList.addNode( new Node("4"));


        //finding middle element of LinkedList in single pass
        Node current = head;
        int length = 0;
        Node middle = head;
        while(current.getNext() != null){
            length++;
            if(length%2 ==0){
                middle = middle.getNext();
            }
            current = current.getNext();
        }
        if(length%2 == 1){
            middle = middle.getNext();
        }
        System.out.println("length of LinkedList: " + length);
        System.out.println("middle element of LinkedList : " + middle);

    }


    private static int getMidlleElemWithRecursive(){
        //creating LinkedList with 5 elements including head
        LinkedList linkedList = new LinkedList();
        head = linkedList.getHead();
        linkedList.addNode( new Node("5"));
        linkedList.addNode( new Node("4"));
        linkedList.addNode( new Node("8"));
        linkedList.addNode( new Node("1"));
        linkedList.addNode( new Node("9"));


        // find middle element

        Node slow = head;
        Node fast = head;

        while(fast.getNext()!=null&& fast.getNext().getNext()!=null){
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        return (Integer.valueOf(slow.getNext().getData()));
    }

    private static int getLengthOfLinkedList(Node head){
        int count = 0;
        Node current = head;
        // count total nodes
        while(current!=null){
            count = count+1;
            current = current.getNext();

        }
        System.out.println("number of total nodes: "+ count);
        return count;


    }



    public static void main(String args[]){

        //creating LinkedList with 5 elements including head
        LinkedList linkedList = new LinkedList();
        head = linkedList.getHead();
        linkedList.addNode( new Node("5"));
        linkedList.addNode( new Node("4"));
        linkedList.addNode( new Node("8"));
        linkedList.addNode( new Node("1"));
        linkedList.addNode( new Node("9"));
        getLengthOfLinkedList(head);

        getMidlleElemeWithLinear();

        System.out.println("value :" + getMidlleElemWithRecursive());
    }

}
