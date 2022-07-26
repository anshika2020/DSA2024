package arrays;

import java.util.*;

public class NumberOfGoodPairs_1512 {
    /*
    Given an array of integers nums, return the number of good pairs.
A pair (i, j) is called good if nums[i] == nums[j] and i < j.
Example 1:

Input: nums = [1,2,3,1,1,3]
Output: 4
Explanation: There are 4 good pairs (0,3), (0,4), (3,4), (2,5) 0-indexed.
     */

    // approach 1 is compairing ith with i+1 which gives O(n^2) time complexity
    public static int goodPair(int[] nums){
        // check edge case
        if(nums.length<=1) return 0;
        int cnt=0;
        for(int i=0; i<nums.length;i++){
            for(int j=i+1; j<nums.length;j++){
                if(nums[i]==nums[j]){
                    cnt++;
                }
            }
        }
        return cnt;
    }

    // approach 2 is using set
    public static int goodPair1(int[] nums){
        int cnt=0;
        int [] arr= new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++){
            if(map.containsKey(nums[i])) {
                cnt += map.get(nums[i]);
            }
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        return cnt;
    }

    // approach 3: O(n) solution
    public static int goodPair2(int[] nums){
        int[] count = new int[nums.length];
        int ans=0;


        for(int i=0; i<nums.length; i++){
            count[nums[i]]++;
        }
        System.out.println(Arrays.toString(count));
        for(int i=0; i<nums.length; i++){
            if(count[nums[i]]>1){
                ans += count[nums[i]]-1;
                count[nums[i]]--;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] num = {1,2,3,1,1,3};
        System.out.println(goodPair1(num));
    }
}
