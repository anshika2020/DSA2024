package arrays.google;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement_LC215 {

    public int findKthLargest(int[] nums, int k) {
        int result = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // by default PriorityQueue is in Ascending Lexicographical order
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k) {// maintain the queue size to k length only
                {
                    pq.remove();
                }
            }
            result = pq.peek();
            System.out.println("Result : "+result);
        }

        return result;
    }

    public static void main(String [] args){
        int[] num = {12, 5, 787, 1, 23};
        KthLargestElement_LC215 kth =new KthLargestElement_LC215();
        System.out.println(kth.findKthLargest(num, 2));
    }

}
