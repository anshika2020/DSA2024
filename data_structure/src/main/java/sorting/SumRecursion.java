package sorting;

import java.util.HashMap;

public class SumRecursion {

/*
Possible To Achieve Target Sum?



Given a set of integers and a target value k, find a non-empty subset that sums up to k.



Example One

Input: [2 4 8], k = 6

Output: True

Because 2+4=6.



Example Two

Input: [2 4 6], k = 5

Output: False

Because no subset of numbers from the input sums up to 5.



Notes

Input Parameters: Function has two arguments: an array of integers (their order doesn’t matter) and the target value  k.



Output: Function must return a boolean value.



Constraints:

1 <= size of the input array <= 18
-10^12 <= elements of the array, k <= 10^12


Custom Input

Input Format: First line of input contains integer n, size of arr. Next n lines contain integer elements of arr. Next line contains integer k. If arr = [2, 4, 8] and k = 6, custom input would be:

3

2

4

8

6



Output Format: Valid output consists of a single character on a single line: 0 for False or 1 for True. For input arr = [2, 4, 8] and k = 6, correct output would be:

1
 */
private static boolean check_if_sum_possible(long[] arr, long k){
    // Boolean flag= false;
    long sum =0;
    return helper2(arr,0,sum,k);
}

    private static boolean helper2(long[] input, int index, long sum, long k) {
        // base case 1
        if(index==input.length){
            return false;
        }
        if(sum==k){
            return true;
        }

        // inclusion
        boolean res =  helper2(input, index+1, sum+input[index], k);
        if(res==true){
            return true;
        }
        // exclusion
        boolean res1 =  helper2(input, index+1, sum, k);
        return res1;
    }

    public static void main(String[] args) {
        long arr[] = {5,-3,-3,-3,-3};
        System.out.println(check_if_sum_possible(arr, -12));
    }
}
