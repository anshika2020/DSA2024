package LinkedListDS;

public class AddTwoNumberInLinkedList121220 {
    /*
    You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.
You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example 1:

Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
  */

    /*
    1. Take two nodes temp and curr , initialize current node with temp node, if no node then retun temp;
    2. check if l1 amd l2 nodes are null then return null
    3. Take a carry int var which will be initialized with 0 but would be updated once sume has carry
    4. now run while loop till l1 and l2 is not null and carr ==1
            -- have int sum to store the sum of node val
            -- check if l1 is not null
                -- keep adding the l1 nodes val in sum
                -- then make move l1 node to l1.next
            -- repeat same for l2 node
            -- now add carry in sum
            -- now get the carry by diving sum /10
            -- create a node to store the val of (sum%10 : the value we will moduling it, will become as a new node  and add it to our listnode)
            -- point node to current.next node
            -- assign next node of curr to curr
   */

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null|| l2==null) return null;
        int carry =0;
        ListNode temp = new ListNode(0);
        ListNode current = temp; // intialize  current node with temp
        while(l1!=null ||l2!=null ||carry ==1){
            int sum =0;
            if(l1!=null){
              sum +=l1.val;
              l1 = l1.next;
            }
            if(l2!=null){
                sum +=l2.val;
                l2 = l2.next;
            }
            // add carry to sum
            sum +=carry;
            carry = sum/10; // get carry if sum has
            // now add the sum to new node
            ListNode node = new ListNode(sum%10);
            current.next = node; // current node will point new node if we get
            current = current.next; // update current node everytime
            System.out.print(current.val +" ");
        }

       return temp.next;

    }



    public static class ListNode {
     int val;
      ListNode next;
      ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println(addTwoNumbers(l1, l2));


    }
}
