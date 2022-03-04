package patterns.slidingWindow_pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class findPairOfSmallestDiff {
    /*
    Given an integer array, nums, return all pairs of numbers whose difference equals the minimum difference in the array.

Ex: Given the following nums…

nums = [4, 2, 3], return [[2, 3], [3, 4]] (the minimum difference between any two elements is one and 3 - 2 = 1 and 4 - 3 = 1).
Ex: Given the following nums…

nums = [6, 2, 5, 3, 1], return [[1, 2], [2, 3], [5, 6]].
     */

    public static List<List<Integer>> getAllApirsofMinDiff(int[] nums){
        List<List<Integer>> result =new ArrayList<>();
        if(nums.length<2) return null;

        int min = Integer.MAX_VALUE;
       Arrays.sort(nums);// sorting TC: O(n log n)

        for(int i=0 ; i< nums.length-1;i++){ // O(n)
            ArrayList<Integer> temp = new ArrayList<>();
            int diff = nums[i+1]-nums[i];
            if(diff<=min){
                min =diff;
                temp.add(nums[i]); // O(1)
                temp.add(nums[i+1]);
                result.add(temp);//O(1)
            }
        }

        return result;
    }
    // total time complexity calculation : O(n log n)+O(n)+O(1)+O(1)--> O(n log n)

    public static void main(String[] args) {
        int num[] ={6, 2, 5, 3, 1}; //[[1, 2], [2, 3], [5, 6]]
        System.out.println(getAllApirsofMinDiff(num));
    }
}
