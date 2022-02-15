package arrays.google;

import java.util.Arrays;

public class WiggleSort {
    /*
    280. Wiggle Sort
Medium

874

74

Add to List

Share
Given an integer array nums, reorder it such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

You may assume the input array always has a valid answer.



Example 1:

Input: nums = [3,5,2,1,6,4]
Output: [3,5,1,6,2,4]
Explanation: [1,6,2,5,3,4] is also accepted.
Example 2:

Input: nums = [6,6,5,6,3,8]
Output: [6,6,5,6,3,8]
     */

    public static int[] wiggleSort1(int nums[]){
        Arrays.sort(nums);
        for(int i=1;i<nums.length-1;i+=2){ // lets fix the 0th index, and start with 1 index and then swap at every odd index.
            int temp = nums[i];
            nums[i] =nums[i+1];
            nums[i+1] =temp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int nums[] = {3,5,2,1,6,4};  // output: 3,5,1,6,2,4 or 1,6,2,5,3,4
        System.out.println(Arrays.toString(wiggleSort1(nums)));
    }
}
