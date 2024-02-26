package patterns.slidingWindow_pattern;

public class MaximumSubArraySum {
    /*
    Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
A subarray is a contiguous part of an array.
Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.
     */

    public static int maxSubArray(int[] nums){
        //get two variables one for current max, and another for maximum max
        int currentMax=nums[0]; //lets assume the first element is the current max and max subArr
        int maxSubArr = nums[0];
        // checkedgecase
        if(nums.length<=1)return maxSubArr;
        // iterate through the array till len
        for (int i=1; i<nums.length;i++){
            // first get the max of current max
            currentMax = Math.max(nums[i], currentMax+nums[i]);
            maxSubArr = Math.max(currentMax,maxSubArr);
        }
       return maxSubArr;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
