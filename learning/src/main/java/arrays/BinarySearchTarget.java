package arrays;

public class BinarySearchTarget {

/*
Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.
You must write an algorithm with O(log n) runtime complexity.
Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
 */

   public static int search(int[] nums, int target) {
       if(nums.length==0){
           return -1;
       }

       if(target>nums[nums.length-1]|| target<nums[0]){
           return -1;
       }

       int start =0; int end = nums.length; int mid;

       while(start<=end){
           mid = start+(end-start)/2;
           if(nums[mid] == target){
               return mid;
           }else if(target<nums[mid]){
               end= mid-1; // assign the value for end
           }else{
               start= mid+1; // assign value for start if the target is greater than the mid element in the array
           }
       }
       return -1;
    }
    public static void main(String[] args) {
        int arr[] = {-1,0,3,5,9,12};
        System.out.println(search(arr, 2));
    }
}
