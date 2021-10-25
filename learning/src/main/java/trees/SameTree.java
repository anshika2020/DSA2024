package trees;

public class SameTree {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int d) {
            this.data = d;
        }
    }

    public static boolean areTreesSame(Node p, Node q){
        int count=0;
        if(p==null&&q==null){
            return true;
        }

        if(p.data!=q.data){
            System.out.println("Tree are not same");
            return false;
        }
            // check the height of the both trees
        //step 1: p.right = 3 and q.right=3
        //step2:p.left = 2 and q.left=2
        //step

        /*
            counter: 1
            p.data: 1 q.data: 1
            values in leftp:2 left q 2
            values in rightp:3 right q 3
            counter: 2
            p.data: 2 q.data: 2
         */


//        count =count+1;
//        System.out.println("counter: "+count);
//        System.out.println("p.data: "+p.data +"q.data: "+q.data); //1:data=1, 2:
//        System.out.println("values in leftp:" +p.left.data+ "left q " + q.left.data);
//        System.out.println("values in rightp:" +p.right.data+ "right q " + q.right.data);
        return areTreesSame(p.left, p.left) && areTreesSame(p.right, q.right);
    }


    public static void main(String args[]){
        Node p = new Node(1);
        p.left = new Node(2);
        p.right= new Node(3);

        Node q = new Node(1);
        q.left = new Node(2);
        q.right= new Node(3);
        System.out.println(areTreesSame(p,q));
    }
}
