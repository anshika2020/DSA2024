package trees;


public class MergeTwoTree {


    public static LinkedListDS.Node mergeTrees(LinkedListDS.Node t1, LinkedListDS.Node t2) {


        if (t1 == null){
            try {
                System.out.println("value of t1 is null: " + " ::: t2 value: " + t2.data);

            } catch (NullPointerException n) {

            }
        return t2;
    }
        if (t2 == null) {
            try {
                System.out.println( "t2 value: " + t1.data + " T2 is null");

            } catch (NullPointerException n) {

            }

            return t1;
        }
        System.out.println(" t1 data : "+ t1.data +"====t2data :" +t2.data);
        t1.data += t2.data;



            t1.left = mergeTrees(t1.left, t2.left);

           // System.out.println("t1.left : " + t1.left.data + ":::" + t2.left.data);
            t1.right = mergeTrees(t1.right, t2.right);
           // System.out.println("t2.right : " + t1.right.data + ":::" + t2.right.data);

        return t1;
    }

    public static void preOder(LinkedListDS.Node n){
        if(n==null){
            return;
        }
        System.out.print(n.data +" ");
        preOder(n.left);
        preOder(n.right);
    }
    public static void main(String str[]){

        LinkedListDS.Node t1 = new LinkedListDS.Node(1);
        t1.left=new LinkedListDS.Node(2);
        t1.left.right = new LinkedListDS.Node(5);
        //t1.left.right.left = new Node(7);
        t1.left.left = new LinkedListDS.Node(4);
        t1.right=new LinkedListDS.Node(3);


        LinkedListDS.Node t2 = new LinkedListDS.Node(5);
        t2.left = new LinkedListDS.Node(3);
        t2.left.left = new LinkedListDS.Node(2);
        t2.right = new LinkedListDS.Node(6);
        t2.right.left =new LinkedListDS.Node(1);
        t2.right.left.left = new LinkedListDS.Node(7);
        t2.right.left.left.left = new LinkedListDS.Node(8);
        t2.right.right =new LinkedListDS.Node(4);

        preOder(t1);
        System.out.println("\n");
        preOder(t2);
        System.out.println("\n");
        mergeTrees(t1,t2);
        preOder(t1);
    }
}
