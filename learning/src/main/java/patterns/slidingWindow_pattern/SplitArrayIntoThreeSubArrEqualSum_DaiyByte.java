package patterns.slidingWindow_pattern;

public class SplitArrayIntoThreeSubArrEqualSum_DaiyByte {
    /*
    Given an integer array, nums, return whether or not you can split the array into three subarrays all of which have an equal sum
    Ex: Given the following nums…

nums = [2, 3, 9, 9, 3, 2, 3, 2, 9], return true.
nums = [1, 2, 3], return false.
     */

    public static boolean isEqualSumInSubArray(int[] arr, int k){
        // check base case
        if(arr.length==0 || arr.length<=3) return false;
        int sum =0;
        // get the sum of first subarray
        for(int i=0; i<k;i++){
            sum+=arr[i];
        }
        for(int i=k;i<arr.length-1;i++){
            int currentSum =arr[i];
            for(int j=0;j<k;j++){
                currentSum+=arr[j];
                if(currentSum==sum){
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
       int[] nums = {2, 3, 9, 9, 3, 2, 3, 2, 9};
        int nums1[] = {1, 2, 3};
        System.out.println(isEqualSumInSubArray(nums1,3));
    }
}
