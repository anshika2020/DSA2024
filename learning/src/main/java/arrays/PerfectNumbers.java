package arrays;

import java.util.Arrays;

public class PerfectNumbers {
    /*
    Perfect Number
Difficulty Level : Easy
Last Updated : 25 Mar, 2021
A number is a perfect number if is equal to sum of its proper divisors, that is, sum of its positive divisors excluding the number itself. Write a function to check if a given number is perfect or not.
Examples:

Input: n = 15
Output: false
Divisors of 15 are 1, 3 and 5. Sum of
divisors is 9 which is not equal to 15.

Input: n = 6
Output: true
Divisors of 6 are 1, 2 and 3. Sum of
divisors is 6.
     */

    public static boolean checkPerfectNumber(int n){
        int sum =0;
        for(int i=1;i<n;i++){
            if(n%i==0){
                sum+=i;
            }
        }
        if(sum==n){
            System.out.println(n+ "  is a perfect number");
            return true;
        }else {
            System.out.println(n+ "  is NOT a perfect number");
            return false;
        }
    }

    public static void main(String[] args) {
        checkPerfectNumber(15);
    }
}
