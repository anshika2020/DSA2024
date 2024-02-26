package LinkedListDS;

public class DeleteNodeFromBeginning {
   // delete node from beginning also node and val is given
    static ListNode head = null;
   public static void deleteNode(ListNode node){
       if(node==null){
           return;
       }

       // now store the next of the given node data in temp node
        node.data = node.next.data;
        node.next = node.next.next;
   }



     static class ListNode{
        ListNode next = null;
        int data ;

        ListNode(int d){
          data = d;
        }
         ListNode(ListNode next, int d){
             data = d;
             this.next = next;
         }
    }
    private static void display(ListNode node){
        while(node!=null){
            System.out.print(node.data+" ");
            node = node.next;
        }
        System.out.println();
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        deleteNode(head);
        display(head);

    }
}
