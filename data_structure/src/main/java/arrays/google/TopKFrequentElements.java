package arrays.google;

import java.util.*;

public class TopKFrequentElements {
    /*
    Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
     */
    /*
    Let's start from the simple heap approach with O(Nlogk) time complexity. To ensure that O(Nlogk) is always less than O(NlogN),
    the particular case k = N could be considered separately and solved in O(N) time.
     */

    public static int[] topKElements1(int nums[],int k){
        int [] res = new int[k];

        Map<Integer, Integer> map= new HashMap<>();
        for(int i=0; i<nums.length;i++){ // put all all values in map with number of occurence
          map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>((n1,n2)->map.get(n1)-map.get(n2));

        // add all values in queue
        for(int i:map.keySet()){
            pq.add(i);
            if(pq.size()>k){
                pq.poll();
            }
        }

        // now fetch top two frequent element in order of highest occurence to low occurence
        for(int j=k-1;j>=0;j--){
            res[j] = pq.poll();
        }
        return res;
    }
    
//    //use merge sorting then add them set
//    public static int[] topKElements2(int nums[],int k){
//        // sort the arrays
//        mergeSort(nums);
//    }
//
//    private static void mergeSort(int[] nums) {
//    }

    public static void main(String[] args) {
        int nums[] ={1,1,1,2,2,3};//[1,2]
        System.out.println(Arrays.toString(topKElements1(nums,1)));
    }
}
