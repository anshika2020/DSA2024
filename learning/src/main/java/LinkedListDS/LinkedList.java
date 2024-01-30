package LinkedListDS;


public class LinkedList<P>{
    private Node head;
    private Node tail;
   public LinkedList(){
       this.head = new Node("head");
       tail = head;
   }

   public Node getHead(){
        return head;
   }

   public void addNode(Node nodeToAdd){
       tail.next = nodeToAdd;
       tail = nodeToAdd;
   }



    public static class Node{

        private Node next;
        private String data;
        public Node getNext() {
            return next;
        }

        public void setNext(final Node next) {
            this.next = next;
        }

        public String getData() {
            return data;
        }

        public void setData(final String data) {
            this.data = data;
        }



        public Node(String d){
            data=d;
        }


        @Override
        public String toString() {
            return "data='" + data + '\'' +
                    '}';
        }
    }
}
