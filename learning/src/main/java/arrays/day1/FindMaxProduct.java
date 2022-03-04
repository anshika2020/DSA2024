package arrays.day1;

import java.util.Arrays;

public class FindMaxProduct {
    /*
Find a pair with maximum product in array of Integers

Given an array with both +ive and -ive integers, return a pair with highest product.

Examples :

Input: arr[] = {1, 4, 3, 6, 7, 0}
Output: {6,7}

Input: arr[] = {-1, -3, -4, 2, 0, -5}
Output: {-4,-5}
*/
// TC: O(n log n)
    public static int findMaxProduct(int [] arr){
        int max= 0;
        int len =arr.length;
        // check edge case
        if(arr.length<2){
            return 0;
        }

        Arrays.sort(arr);
        int a = arr[0]; // because begging can be negative and also can be max product
        int b=arr[1];
        if(a*b>arr[len-1]*arr[len-2]){
            max= a*b;
        }else{
            max=arr[len-1]*arr[len-2];
        }

        System.out.println(Arrays.toString(arr));

        return max;

    }

    // Now we can do in linear as well
    // lets do it in linear way
    public static int findMaxProduct2(int [] arr){
        int maxProduct=Integer.MIN_VALUE;
        // take two max and two min variable to get two max and two min integer
        int max1= arr[0];
        int max2 = Integer.MIN_VALUE;
        int min1 = arr[0];
        int min2 = Integer.MAX_VALUE;

        // iterate through the array to get two min and max integers in array
        for(int i=1; i<arr.length;i++){
            if(arr[i]>max1){
                max2= max1;
                max1=arr[i];
            }else if(arr[i]>max2){
                max2 = arr[i];

            }

            if(arr[i]<min1){
                min2= min1;
                min1= arr[i];
            }else if(arr[i]<min2){
                min2= arr[i];
            }
        }
        // now check the maxproduct
        if(max1*max2>min1*min2){
            return max1*max2;

        }else{
           return min1*min2;
        }
    }


    public static void main(String[] args) {
        int arr[] = {-1, -3, -4, 2, 0, -5};
        System.out.println(findMaxProduct(arr));
        System.out.println(findMaxProduct2(arr));
    }
}
