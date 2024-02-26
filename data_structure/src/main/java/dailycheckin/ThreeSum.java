package dailycheckin;

import java.util.*;

public class ThreeSum {
    /*
    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
     */

    public static List<List<Integer>> threeSum(int[] nums) {
        if(nums==null ||nums.length<3) return new ArrayList<>();
        /*
        use two pointer approach to find two sum then add sum to addional prefix value
        1. first sort the arrays
        2. Get Set of list to store the unique list of triplet
        3. iterate from 0to len-2 as we need to find only find only so we can stop at len-2
        4. get two valriable to hold start and end values
        5. run while loop to get two sum and check if sum ==0 if yes then add result to set increment start and decrement end and if less than 0 then increment start else just decrement end as we need to find so right end is going have higher values
        6. return the list
        */
        Arrays.sort(nums);
        Set<List<Integer>> result = new HashSet<>();
        for(int i=0; i<nums.length-2;i++){
            int start = i+1;
            int end = nums.length-1;
            while(start<end){
                int sum = nums[i]+ nums[start]+nums[end];
                if(sum==0){
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));
                    start++;
                    end--;
                }else if(sum>0){
                    end--;
                }else{
                    start++;
                }
            }
        }
        return new ArrayList<>(result);
    }

    public static void main(String[] args) {
        int num [] = {-1,0,1,2,-1,-4,-2,-3,3,0,4};
        System.out.println("3Sum :" + threeSum(num));
    }
}
