package patterns.slidingWindow_pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SmallestSubarrayWithGreaterSum {
    /*
    Given an array of positive numbers and a positive number ‘S,’ find the length of the smallest contiguous subarray whose sum is greater than or equal to ‘S’.
     Return 0 if no such subarray exists.
     Example 1:

    Input: [2, 1, 5, 2, 3, 2], S=7
    Output: 2
    Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
    Example 2:

    Input: [2, 1, 5, 2, 8], S=7
    Output: 1
    Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].
    Example 3:

    Input: [3, 4, 1, 1, 6], S=8
    Output: 3
    Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1]
    or [1, 1, 6].
     */
    public static int getSmallestSubarrayWithgreaterSum(int [] num, int target){

        if(num.length<1) return -1;
        int sum =0; int start=0; int minlen= Integer.MAX_VALUE;
        for(int i=0; i<num.length;i++){ // it will iterate through till end hence TC is O(n)
            sum+=num[i];// add the current element
            while(sum>=target){ // shrink the window as small as possible until sum is smaller than target

                System.out.println("i-start: "+ (i-start+1)+"::i:"+i+"  start: "+start);
                minlen = Math.min(minlen, (i-start)+1);//2-0+1
                sum -=num[start]; // substract the element going out
                start++;
            }
        }
        return minlen==Integer.MAX_VALUE?0:minlen;
    }

    public static void main(String[] args) {
        int [] input= {2, 1, 5, 2, 3, 2};
        //Output: 2
      //  Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].
        int input1[] ={2, 1, 5, 2, 8};
        System.out.println(getSmallestSubarrayWithgreaterSum(input,7));
    }
}
