package arrays;

public class MaximumSubArray {
    /*
    53. Maximum Subarray
Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

A subarray is a contiguous part of an array.
Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
     */

    public int maxSubArray(int[] nums) {
        int maxSubArr=Integer.MIN_VALUE; // get the minimum value
        for(int i=0; i<nums.length;i++){ // iterate till length
            int currentSubArr = 0; // variable to store the currentSub array
            for(int j = i; j<nums.length;j++){ // iterate from ith to length
                currentSubArr +=nums[j]; // add the num[j] value in currentSubArr variable
                maxSubArr = Math.max(maxSubArr,currentSubArr); // Calculate Max suing Math API between current and maxSubArr
            }

        }
        return maxSubArr; // return sum of subarray
    }

    public int maxSubArray1(int[] nums) {

        int maxSoFar=nums[0];
        int max=nums[0];

        for(int i=1;i<nums.length;i++){
            maxSoFar= Math.max(nums[i], maxSoFar+nums[i]);
            max= Math.max(max, maxSoFar);
        }

        return max;
    }
}
