package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        if(nums.length==0) return null;

        Map<Integer, Integer> map = new HashMap<>(); //create a map to store values of array where the value is the key and index is the value
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) { // checkif the target-num[i] values exist
                System.out.println("map.get(target - nums[i]), i : "+ map.get(target - nums[i])+"nums[i] :"+nums[i]+ "::i "+ i);
                return new int[]{map.get(target - nums[i]), i}; // return
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No number combination found to match with target");
    }

    // two pointer approach with sorting
    public static int[] getIndices(int arr[] , int target){
        if(arr.length<2) return arr;
        int start = 0; int end= arr.length-1;
        while(start<end){ //O(n log n)
            int sum = arr[start]+ arr[end];
            if(sum==target){
                return new int[]{start, end};
            }else if(sum<target){
                start++;
            }else{
                end--;
            }
        }
        throw new  IllegalArgumentException("pair no found");
    }

    public static void main(String[] args) {
        int num [] = {2,7,11,15};
        int num1 [] = {1,4,6,2,9,7};// {1,2,4,6,7,9}
         System.out.println(Arrays.toString(twoSum(num,9)));
        System.out.println(Arrays.toString(getIndices(num,9)));
    }
}
