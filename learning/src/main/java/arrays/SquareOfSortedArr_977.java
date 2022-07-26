package arrays;

import java.util.Arrays;

public class SquareOfSortedArr_977 {
    /*
    Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.
    Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
     */
// two pointer apporach
    public static int [] sqrArr(int num[]){

        // check edge case
        if(num.length<1) return num;
        int res[]=new int[num.length];
        //create start and end point and also one index where we want to put the value
        int start=0;
        int end= num.length-1;
        int index = end;
        while(start<=end){
            int pow1 =num[start]*num[start];
            int pow2= num[end]*num[end];
            if(pow1>pow2){
               res[index--] =pow1;
               start++;
            }else{
                res[index--] =pow2;
                end--;
            }
        }
        return res;
    }
// another approach
public static int[] sortedSquares(int[] nums) {

    int cnt=0;
    for(int i=0; i<nums.length;i++){
        int sqr = nums[i]*nums[i];
        nums[cnt] = sqr;
        cnt++;
    }
  //  System.out.println(Arrays.toString(nums));

    return sortArraysDescending(nums);
  }

    public int[] sortArrays(int [] arr){
        int result[]=new int[arr.length];

        int start =0; int end = arr.length-1; int index=end;
        while(start<=end){
            if(arr[start]>arr[end]){
                result[index--] = arr[start];
                start++;
            }else{
                result[index--] = arr[end];
                end--;
            }
        }
       // System.out.println(Arrays.toString(result));
        return result;
    }

    public static int[] sortArraysDescending(int[] arr){
        int result[]=new int[arr.length];

        int start =0; int end = arr.length-1; int index=start;
        while(end>=start){
            if(arr[end]>arr[start]){
                result[index++] = arr[end];
                end--;
            }else{
                result[index++] = arr[start];
                start++;
            }
        }
     //   System.out.println(Arrays.toString(result));
        return result;
    }
    public static void main(String[] args) {
        int num[] ={-4,-1,0,3,10};
      //  System.out.println(Arrays.toString(sqrArr(num)));
        System.out.println(Arrays.toString(sortedSquares(num)));
    }
}
