package sorting;

import java.util.ArrayList;
import java.util.List;

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


    //Appraoch 1: fetch element from each linked list and put them in a list and sort it

        class SinglyLinkedListNode {
            public int data;
            public SinglyLinkedListNode next;

            public SinglyLinkedListNode(int nodeData) {
                this.data = nodeData;
                this.next = null;
            }
        }


//    public static SinglyLinkedListNode merge_k_lists(List<SinglyLinkedListNode> lists) {
//        ArrayList tempList = new ArrayList<>();
//        if(lists.isEmpty()){
//            return tempList;
//        }
//    }




}
