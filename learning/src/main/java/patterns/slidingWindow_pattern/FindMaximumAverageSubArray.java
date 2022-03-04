package patterns.slidingWindow_pattern;

public class FindMaximumAverageSubArray {
    /*
    You are given an integer array nums consisting of n elements, and an integer k.

Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.
Example 1:

Input: nums = [1,12,-5,-6,50,3], k = 4
Output: 12.75000
Explanation: Maximum average is (12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75

     */

    public static double findMaxAverage(int[] nums, int k) {
        // check base case
        if(k<=0&&k>nums.length&&nums.length<=1) return -1.0;
        // get the sum of first subarray of k size
        int i=0; double sum=0; double avg=0; double max=0;
        for(i=0; i<k;i++){
            sum += nums[i];
        }
        max=sum;
        int start=0;

        for(int j=i;j<nums.length;j++){
            sum+=nums[j]-nums[start];
            start++;
            if(sum>max){
                max =sum;
            }
        }
        avg = max/k;
        System.out.println("max :" + avg);
        return avg;
    }
// TC: O(n) an space : O(1)

    public static void main(String[] args) {
        int num[] ={1,12,-5,-6,50,3};// {5},1
        System.out.println(findMaxAverage(num,4));
    }
}
