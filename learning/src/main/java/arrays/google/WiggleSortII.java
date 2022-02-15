package arrays.google;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class WiggleSortII {

    /*
    Wiggle Sort II

Given an integer array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....
You may assume the input array always has a valid answer.
 Example 1:
Input: nums = [1,5,1,1,6,4]
1<5>1
Output: [1,6,1,5,1,4]
Explanation: [1,4,1,5,1,6] is also accepted.

Example 2:
Input: nums = [1,3,2,2,3,1]
Output: [2,3,1,3,1,2]

     */

    public static int[] wiggleWave1(int[] nums) {
        if (nums.length <= 1) return nums;
        //int ans[] = new int[nums.length];
        Arrays.sort(nums);
        int start = 0;
        int result[] = new int[nums.length];
        int len = nums.length - 1;
        // first put  all the  numbers at odd indexes and put them in the result array and increment i by 2 and keep on decreasing the length
        int j = 1;
        while (j < nums.length) {
            result[j] = nums[len];
            len--;
            j += 2;
           // System.out.println(Arrays.toString(result));
        }
        int k = 0;
        // then put  all the  numbers at even indexes and put them in the result array and increment i by 2 and keep on decreasing the length
        while (k < nums.length) {
            result[k] = nums[len];
            len--;
            k += 2;
          //  System.out.println(Arrays.toString(result));
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = result[i];
        }
        return nums;

    }
// using priorityqueue , sort in reverseoder then iterate through the loop for both odd and even index.
    public static int[] wiggleWave2(int[] nums){
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        // add all the nums element in the queue
        for(int i=0;i< nums.length;i++){
            pq.add(nums[i]);
        }
        int size= pq.size(); // need to get the size before polling out the element from the queue else quesize will keep on changing based on priority.
        for(int k=1;k< size;k+=2){
            nums[k] = pq.poll();
        }
        // now put element on even indexes
        for(int j=0;j< size;j+=2){
            nums[j] = pq.poll();
        }
        return nums;
    }

    public static void main(String[] args) {
        int nums[] ={1,5,1,1,6,4};
        //[1,6,1,5,1,4]
       // System.out.println(Arrays.toString(wiggleWave1(nums)));
        System.out.println(Arrays.toString(wiggleWave2(nums)));
    }
}
