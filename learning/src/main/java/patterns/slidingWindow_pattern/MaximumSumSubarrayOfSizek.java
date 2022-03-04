package patterns.slidingWindow_pattern;

public class MaximumSumSubarrayOfSizek {
    /*
    Given an array of integers Arr of size N and a number K. Return the maximum sum of a subarray of size K.
Example 1:
Input:
N = 4, K = 2
Arr = [100, 200, 300, 400]
Output:
700
Explanation:
Arr3  + Arr4 =700,
which is maximum.

     */
    public static int getMaxSumOfSubArray(int num[], int k){
        // check the base case
        if(k<=1&&num.length>=k) return -1;

        int sum =0; int i=0;
        // now get the sum of first subarray
        for(i=0; i<k;i++){
            sum+=num[i];
        }
        System.out.println("Sum :" + sum);

        // now check if the the other subarrays are greater sum than current one
        int max=sum; int start=0;// we need start so that we can decrease the previous window
        for(int j=i; j<num.length;j++){ // start with i because we already got the sum of size k subarray hence we start from there rather beginning

            sum += num[j]-num[start]; // remove the start value
            start++; // increase the start window with next element
            //System.out.println("Sum indise :" + sum);
            if(sum>max){
                max = sum;
            }
        }
        return max;

    }
    public static void main(String[] args) {
        int num[] = {100, 200, 300, 400};
        System.out.println(getMaxSumOfSubArray(num,2));
    }
}
