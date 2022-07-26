package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GetAverageAtEachLevelBT {
   static class Node{
        Node left;
        Node right;
        int val;
        public Node(int d){
            this.val=d;
            left=right=null;
        }
    }

    // now the grab the node values at each level : approach 1: BFS
    public static List<Integer> getAvgandReturn(Node root){
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Queue<Node> q= new LinkedList<>();
        // add in the queue
        q.add(root);
        int conter=0;
        while(!q.isEmpty()){
            ArrayList<Integer> temp = new ArrayList<>();
            int cnt = q.size();
            for(int i=0;i<cnt;i++){
                Node node = q.remove();
                temp.add(node.val);
                conter++;
                if(node.left!=null) {
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            int num = Math.round(getAvg(temp));
            result.add(num);

        }
        return result;
    }


    // create a method to calculate the average based on the list size
    public static int getAvg(List<Integer> list){
        if(list.isEmpty()) return -1;
        int sum =0;
        for(int n:list){
            sum+=n;
        }
        return sum/list.size();

    }

    // now the grab the node values at each level : approach 1: BFS
    public static List<Integer> getAvgandReturn1(Node root){
        List<Integer> result = new ArrayList<>();
        if(root==null) return result;
        Queue<Node> q= new LinkedList<>();
        // add in the queue
        q.add(root);
        while(!q.isEmpty()){
            int sum=0;// get the sum of all node's val at  each level
            int cnt=0; // cont the numbder of nodes in the queue
            // create a temp Node queue which will store the lefty and right nodes
            Queue<Node> temp = new LinkedList<>();
            while(!q.isEmpty()){
                Node node= q.remove(); // get the node from the queue
                sum+=node.val;// add the node value in the sum
                cnt++; // increase the counter by 1
                if(node.left!=null) temp.add(node.left);
                if(node.right!=null) temp.add(node.right);
            }
            //now reset primary queue with temp queue
            q=temp;
            result.add(Math.round(sum/cnt));


        }
        return result;
    }
    public static List<Integer> averageOfLevels(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        List<Integer> ans = new ArrayList<>();
        while (q.size() > 0) {
            int qlen = q.size(), row = 0;
            for (int i = 0; i < qlen; i++) {
                Node curr = q.poll();
                row += curr.val;
                if (curr.left != null) q.offer(curr.left);
                if (curr.right != null) q.offer(curr.right);
            }
            ans.add(Math.round(row/qlen));
        }
        return ans;
    }

    //NOw DFS approach


    public static void main(String[] args) {
        Node root =  new Node(4);
        root.left = new Node(5);
        root.right =new Node(7);
        root.left.right = new Node(10);
        root.left.left = new Node(12);
        root.right.left= new Node(9);
        System.out.println(getAvgandReturn(root));
        System.out.println(getAvgandReturn1(root));
        System.out.println(averageOfLevels(root));
    }
}
