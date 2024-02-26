package LinkedListDS;

public class NodesLength {

    static class Node {
        int data;
        Node next;

        public Node(int d) {
            this.data = d;
        }

        public Node(final Object data, final Object o) {
        }

    }

    static class LinkedList {
        Node head;

        public LinkedList addNode(LinkedList list,int data) {
 /* 1 & 2: Allocate the Node &
              Put in the data*/
            Node new_node = new Node(data);

            /* 3. Make next of new Node as head */
            new_node.next = null;
            if (list.head == null) {
                list.head = new_node;
            } else {
                Node last = list.head;
                while (last.next != null) {
                    last = last.next;
                }
                last.next = new_node;
            }
            return list;
            }

        public int getFirstNodeElem(){
            return head.data;
        }

        public int getLastElem(){
            Node last = head;
            while(last.next!=null){
              last = last.next;
            }
            return last.data;
        }
    }


    // linear way to count
    public static int countLength(){
        LinkedList linkedList = new LinkedList();
        int count =1;
        Node current = linkedList.head;
        while(current.next!=null){
            current = current.next;
            count = count+1;
        }
        return count;
    }


    // recursive way to count
    public static int countlengthRec(final Node node){
        if(node==null){
            return 0;
        }else{
            return 1+countlengthRec(node.next);
        }
    }

    private static void display(LinkedList list){
        Node node = list.head;
        while(node!=null){
            System.out.print(node.data+"-->");
            node = node.next;
        }
        System.out.print("null");

    }

    public static void main(String str[]){
        LinkedList list = new LinkedList();
        list.addNode(list,2);
        list.addNode(list,4);
        list.addNode(list,5);
        list.addNode(list,21);
        list.addNode(list,8);
        display(list);
      // System.out.println("Count length :" + countLength());
       System.out.println("\nRecursive :" + countlengthRec(list.head));
       System.out.println("\nfirst node value: "+ list.getFirstNodeElem());
        System.out.println("\nlast node value: "+ list.getLastElem());
    }
}
