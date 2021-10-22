package sortingPgm;

import java.util.Arrays;

public class InsertionSort {
/*
-Decrease the problem of size n to size n-1
-Assume you have solved the problem of size n-1
-now left with one problem to solve which is size of n using the solution of size n-1
-recursive(if top down) and iterative(if bottom up)
 */


    // recursive way to do insertion sorting
/*
Algo:
*/
    private static int[] recursiveInsertionSort(int[] num, int len) // len is the length of the array
    {
        if (len <= 1) { // checking the base case
            return num;
        }

        // sort first len-1 elements
      //  System.out.println("[7,4,6,2]");
        recursiveInsertionSort(num, len - 1); //
        System.out.println("recursive call value :" + Arrays.toString(num) + " \nlen-1: " + (len - 1));
        int i = num[len - 1];
        System.out.println("int i : " + i);
        int j = len - 2;
        System.out.println("int j :" + j);
        while (j >= 0 && num[j] > i) {
            num[j + 1] = num[j];
            System.out.println("num[j+1] :" + num[j + 1]);
            j = j - 1;
            System.out.println("j in while loop: " + j);
        }
        System.out.println("i: " + i);
        num[j + 1] = i;

        return num;
    }

// iterative way to do selection sorting

    private static int[] iterativeSelectionSort(int num[]) {
       // int n = num.length; // get the length of the array
        if(num.length<=1){
            return num;
        }
        for (int i = 1; i < num.length; i++) { // iterate array from 1 to length
            int key = num[i];  // store the ith index value in the key var
            System.out.println("Key : " + key);
            int j = i - 1; // store the i-1 value in j
            System.out.println("j outside while loop :" + j);
            while (j >= 0 && num[j] > key) {

                num[j + 1] = num[j];
                j = j - 1;
            }
            num[j + 1] = key;
        }
        System.out.println(Arrays.toString(num));
        return num;
    }

    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String args[]) {

        int arr[] = {7, 4, 6, 2};
        int num[] = { 12, 11, 13, 5, 6 };
       System.out.println("recursive insertion sort array: " + Arrays.toString(recursiveInsertionSort(arr, arr.length)));

       // iterativeSelectionSort(num);
    }


}