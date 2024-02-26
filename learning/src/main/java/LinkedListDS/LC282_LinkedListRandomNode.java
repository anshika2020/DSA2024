package LinkedListDS;

import java.util.ArrayList;
import java.util.List;

public class LC282_LinkedListRandomNode {

          //  * Definition for singly-linked list.
             public class ListNode {
     int val;
      ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
             }

    class Solution {
        private List<Integer> list = new ArrayList<>();

        public Solution(ListNode head) {
            while(head!=null){
                this.list.add(head.val);
                head = head.next;
            }
        }

        public int getRandom() {
            int pick = (int)Math.random()*list.size();
            return list.get(pick);
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
public static void main(String[] args) {

}
}
