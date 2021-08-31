package sorting;

public class MergeTwoSortedList {

     Node head;
     Node tail;

    /*
    Approach 1: recursively-
    1. first account the base case/edge case, if L1 and L2 are null, if null then no merge operation is needed to perform
    2. first determine which list either L1 or L2 has smaller head
    3. Once you get the smaller head then recursively set the next value to head to next merge result
     */
/*
suubclass to create Node
 */
    static class Node {
        int data;
        Node next;

        public Node(int d) {
            this.data = d;
        }

        public Node(final Object data, final Object o) {
        }
    }


    //addNode() will add a new node to the list
    public void addNode(int data) {
        //Create a new node
        Node newNode = new Node(data);

        //Checks if the list is empty
        if(head == null) {
            //If list is empty, both head and tail will point to new node
            head = newNode;
            tail = newNode;
        }
        else {
            //newNode will be added after tail such that tail's next will point to newNode
            tail.next = newNode;
            //newNode will become new tail of the list
            tail = newNode;
        }
    }
    private static Node mergeSortedList(Node L1, Node L2){
        if(L1==null){// check if L1 is null then return L2: base case
            return L2;
        }
        if(L2==null){ // if L2 is null then return L1: Base case
            return L1;
        }
        if(L1.data<L2.data){ // if L1 data is less than L2
            L1.next = mergeSortedList(L1.next,L2); // then recursively call is going to merge
            return L1;
        }else{
            L2.next = mergeSortedList(L1,L2.next);
            return L2;
        }
    }

    // iterative approach
    private static Node mergeSortedTwoList(Node l1, Node l2){
        // base case:
        if(l1==null) return l2;
        if (l2==null) return l1;
        Node prev = new Node(-1);// maintain this prev as current node, in which we can add next node to it
        Node mergedNodeList = prev; // set default value to replace with and easily return the head of merged list later
        while(l1!=null &&l2!=null){// TC: this will run for the length of both list hence O(l1+l2) --> O(n)
           //TC : O(1)
            if(l1.data>=l2.data){ // check if l1.data is greater or equal to then add l2 data to prev node becaause the prev node is current node
                prev.next = l2;
                l2= l2.next;
            }else{
                prev.next = l1; // if l1 is less then point prev node to l1
                l1= l1.next;
            }
            //TC : O(1)
            prev = prev.next; // store next node of current/pev in prev which can be easily accessible by mergedNodeList, now mergedNodeList already has prev so get the next of mergedNodeList
        }
      return mergedNodeList.next;
    }
    private static void display(Node node){
        while(node!=null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();

    }
    public static void main(String[] args) {
      Node head1= new Node(1);
      head1.next = new Node(2);
        head1.next.next = new Node(4);
        head1.next.next.next = new Node(5);

        Node head2 = new Node(3);
        head2.next = new Node(5);
        head2.next.next = new Node(7);
        head2.next.next.next = new Node(8);


        display(head1);
        display(head2);

        display(mergeSortedList(head1,head2)); // TC: O(n+m), SC: O(n+m) because mergeSortedList will not return until both l1 and l2 lists are reached to end hence it will consume more space
        display(mergeSortedTwoList(head1,head2)); // TC: O(n+m) n and m are length of the lists, SC: O(n)

    }

}
