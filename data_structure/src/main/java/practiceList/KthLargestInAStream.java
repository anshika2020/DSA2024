package practiceList;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KthLargestInAStream {
    PriorityQueue<Integer> heapMin ;
    int k;
    /*
    Kth Largest In A Stream
Given an initial list along with another list of numbers to be appended with the initial list and an integer K, return an array consisting of the Kth largest element after adding each element from the first list to the second list.
Example
Input: [ 2, [4, 6], [5, 2, 20] ]

Output: [5, 5, 6]
     */


    public KthLargestInAStream(int k, int[] nums) {
     this.heapMin = new PriorityQueue<>();
     this.k= k;
     if(nums.length==0){
         throw new IllegalArgumentException("No default values provided or size is not defined");
     }

     for(int num : nums){
         heapMin.add(num);
         if(heapMin.size()>k) {
             heapMin.poll();
         }
     }
    }
    public int add(int val) {
      heapMin.offer(val);
      if(heapMin.size()>k) {
           heapMin.poll();
      }
      return heapMin.peek();
    }
    /**
     * Your KthLargest object will be instantiated and called as such:
     * KthLargest obj = new KthLargest(k, nums);
     * int param_1 = obj.add(val);
     */

    public static List<Integer> kth_largest(int k, List<Integer> initial_stream,
                                            List<Integer> append_stream) {
        List<Integer> result = new ArrayList<>();
        // create priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Write your code here


        for(int num : initial_stream){
            pq.add(num);
            if(pq.size()>k){
                pq.poll();
            }
        }

        for(int appendVal:append_stream){
            pq.offer(appendVal);
            if(pq.size()>k){
                pq.poll();
            }

            int val = pq.peek();
            result.add(val);
        }

        return result;


    }

    public static void main(String[] args) {
        int [] num = {4,6,2,3};
        KthLargestInAStream kth = new KthLargestInAStream(3, num);
        System.out.println(kth.add(9)); // 4,5,6,7,9
        System.out.println(kth.add(4));
        System.out.println(kth.add(8));
    }
}
