package arrays;

import java.util.*;

public class TopkFrequentElement {

    /*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
    Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
     */
    public static int[] topKFrequent(int[] nums, int k) {
      // create the map to store value as key and frequency as value
        Map<Integer, Integer> map = new HashMap<>();
        // create int array of size k to store result
        int result [] = new int[k];
        // add array value to the map
        for(int i=0; i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);//get the count for the element if already present in map or get default value which is 0
        }

        // initialize priority queue with min heap
        PriorityQueue<Integer> queue = new PriorityQueue<>( (n1, n2)->map.get(n1)-map.get(n2));

        // add map value in priority queue
        for(int n: map.keySet()){
            queue.add(n);
            if(queue.size()>k){
                queue.poll();
            }
        }

        // now add queue value in the result array
        for(int i=k-1; i>=0;i--){
            result[i] = queue.poll();
        }

        return result;
    }
    public static void main(String[] args) {
        int [] arr = {1, 2, 3, 1,2, 4, 3,4, 4,1};
        System.out.println(Arrays.toString(topKFrequent( arr,2)));
        // System.out.println(find_top_k_frequent_elements1( list,2));
    }

}
