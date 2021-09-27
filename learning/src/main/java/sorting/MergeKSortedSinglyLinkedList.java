package sorting;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedSinglyLinkedList {

    /*
    Merge k Sorted Singly Linked Lists
Given k singly linked lists where each linked list is sorted in ascending order, merge all of them into a single sorted linked list.
Example:Input: [ [1 -> 3 -> 5], [3 -> 4], [7] ].
Output: 1 -> 3 -> 3 -> 4 -> 5 -> 7
Notes:
Constraints:
0 <= k <= 104.
0 <= Length of each linked list <= 103.
-109 <= Node values <= 109.
Sum of the lengths of all linked lists won’t exceed 105.
     */


    static class SinglyLinkedListNode {
        public int data;
        public SinglyLinkedListNode next;

        public SinglyLinkedListNode(int nodeData) {
            this.data = nodeData;
            this.next = null;
        }
    }

    //Approach 1: This is min heap approach

    private static SinglyLinkedListNode mergeAndSortAllKLinkedList(List<SinglyLinkedListNode> lists) {
        SinglyLinkedListNode head = null;
        SinglyLinkedListNode last = null;

        // create a priority queue as a min heap with comparator in increasing order
        PriorityQueue<SinglyLinkedListNode> pq = new PriorityQueue<>(new Comparator<SinglyLinkedListNode>() {
            @Override
            public int compare(SinglyLinkedListNode o1, SinglyLinkedListNode o2) {
                return o1.data - o2.data;
            }
        });
        // add the list data in the pq
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                pq.add(lists.get(i)); // add all the data in queue
            }
        }

        // loop through the queue pq
        while (!pq.isEmpty()) { // this will take
            // get the top element from the queue and store in a node
            SinglyLinkedListNode top = pq.peek();
            pq.remove();
            // check if there is a node next to the top node , if not null then add in the pq
            if (top.next != null) {
                // add to the pq
                pq.add(top.next);
            }
            // check if the head is null then make top as head and if final list is empty
            if (head == null) {
                head = top;
                // now point last node as top in the final merged list
                last = top; // update the last pointer
            }
            else {
                // insert top at the end of the merged list
                last.next = top;
                last = top; // update the last pointer
            }
        }
        return head;
    }
    private static void display(SinglyLinkedListNode node){
        while(node!=null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();

    }
    public static void main(String[] args) {
        SinglyLinkedListNode node1= new SinglyLinkedListNode(1);
        node1.next = new SinglyLinkedListNode(3);
        node1.next.next = new SinglyLinkedListNode(4);
        node1.next.next.next = new SinglyLinkedListNode(5);

        SinglyLinkedListNode node2= new SinglyLinkedListNode(1);
        node2.next = new SinglyLinkedListNode(2);
        node2.next.next = new SinglyLinkedListNode(5);
        node2.next.next.next = new SinglyLinkedListNode(6);

        SinglyLinkedListNode node3= new SinglyLinkedListNode(1);
        node3.next = new SinglyLinkedListNode(6);
        node3.next.next = new SinglyLinkedListNode(7);
        node3.next.next.next = new SinglyLinkedListNode(8);

        List<SinglyLinkedListNode> lists = new ArrayList<>();
        lists.add(node1);
        lists.add(node2);
        lists.add(node3);
        display(mergeAndSortAllKLinkedList(lists));
        // the heap has size k and we will pop and push n times where n is the number of the nodes, since each push and pop operation takes O(nlogk) hence TC is : O(n log k)
        // Space complexity is based on the length of the list and also auxilary list hecne it is : O(k)
    }
}

