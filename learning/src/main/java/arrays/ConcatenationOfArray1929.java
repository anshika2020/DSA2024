package arrays;

import java.util.Arrays;

public class ConcatenationOfArray1929 {
    /*
    Given an integer array nums of length n, you want to create an array ans of length 2n where ans[i] == nums[i] and ans[i + n] == nums[i] for 0 <= i < n (0-indexed).

Specifically, ans is the concatenation of two nums arrays.

Return the array ans.



Example 1:

Input: nums = [1,2,1]
Output: [1,2,1,1,2,1]
Explanation: The array ans is formed as follows:
- ans = [nums[0],nums[1],nums[2],nums[0],nums[1],nums[2]]
- ans = [1,2,1,1,2,1]
     */
    public static int[] concatenateArray(int[] nums){
        if(nums.length<1) return nums;
        int[] ans= new int[nums.length*2];
        for(int i =0; i<nums.length;i++){
            ans[i] = nums[i];
            ans[i+nums.length] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,1};
        System.out.println(Arrays.toString(concatenateArray(nums)));
    }
}
