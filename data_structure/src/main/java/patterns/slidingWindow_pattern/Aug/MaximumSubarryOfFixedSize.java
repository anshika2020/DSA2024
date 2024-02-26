package patterns.slidingWindow_pattern.Aug;

public class MaximumSubarryOfFixedSize {

    /*
    maximum sum of a contiguos subarray of size 3
     [4,2,1,7,8,1,2,8,1,0]

     subarrays = [[4,2,1],[2,1,7],[1,7,8],[7,8,1]....]
              sum=  [ [7],[10],[16],[16].....

              question to solve:maxsum
    */


    public static int maxSum(int arr[], int k) {
        // check edge case
        if (arr.length < k) return -1;
        // create varto store sum
        int sum = 0;
        int i = 0;
        int max = 0;
        // first find the sum first subarray
        for (i = 0; i < k; i++) {
            sum += arr[i];
        }
        max = sum;
        //get the start point to move the sliding window by substracting first one and add next one
        int start = 0;
        // start the loop from 1 and compare the sum
        for (int j = i; j < arr.length; j++) {
            sum += arr[j] - arr[start];
            start++;//keep removing the start value
            if (sum > max) {
                max = sum;
            }
        }
            return max;
    }

    public static void main(String[] args) {
        int arr[] = {4,2,1,7,8,1,2,8,1,0};
        System.out.println(maxSum(arr,3));
    }
}
