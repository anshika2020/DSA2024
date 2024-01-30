package arrays.google;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class ThirdMaximumNumber {
    /*
    414. Third Maximum Number
Given an integer array nums, return the third distinct maximum number in this array. If the third maximum does not exist, return the maximum number.
Example 1:
Input: nums = [3,2,1]
Output: 1
Explanation:
The first distinct maximum is 3.
The second distinct maximum is 2.
The third distinct maximum is 1.
  */

   public static int thirdmax(int [] nums){
       PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
       for(int i:nums){
           pq.add(i);
       }
       int num=0;
       for(int i=0;i<3;i++) {
           num = pq.poll();
       }
       return num;
   }

    public static void main(String[] args) {
        int nums[] = {3,2,1};
        System.out.println(thirdmax(nums));
    }
}
