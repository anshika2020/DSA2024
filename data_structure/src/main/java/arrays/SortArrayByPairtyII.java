package arrays;

import java.util.Arrays;

public class SortArrayByPairtyII {
/*
Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.

Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.

You may return any answer array that satisfies this condition.

Example 1:

Input: [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.
also [3,2]
 */

  // first approach
    private static int[] sortArrayByP2(final int[] arr){
        int result[] = new int[arr.length];
        int even =0;
        int odd=1;
        for(int i=0; i<arr.length;i++){
            if(arr[i]%2==0){
                result[even] = arr[i];
                even += 2;
            }else{
                result[odd] = arr[i];
                odd += 2;
            }
        }

       return result;
    }

// second approach
    private static int[] sortArrayyPairty2(int[] A){
        int even = 0;
        int odd = 1;
        while(even<A.length && odd<A.length){
            if(A[even]%2 != 0){
                swap(A,even,odd);
                odd +=2;

            }else{
              even +=2;
            }
        }
        System.out.println(Arrays.toString(A));
        return A;
    }

    private static void swap(int arr[], int even, int odd){
        int temp = arr[even];
        arr[even] = arr[odd];
        arr[odd] = temp;

    }
    public static void main(String arg[]){
       // int arr [] = {2,4,7,9};
        int arr [] = {3,4};
        //System.out.println(Arrays.toString(sortArrayByP2(arr)));
        sortArrayyPairty2(arr);
    }
}
