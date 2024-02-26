package sortingPgm;

import java.util.Scanner;

public class QuickSelectSearch {
    /*
    Algorithm :
    1. we will partition the array selecting the last element as the pivot.
    2. Get the left and right
    3. kth element either smallest or largest

function quickSelect(arr, left, right, k)

   if left = right
      return arr[left]

   Select a pivotIndex between left and right

   pivotIndex := partition(arr, left, right,
                                  pivotIndex)
   if k = pivotIndex
      return arr[k]
   else if k < pivotIndex
      right := pivotIndex - 1
   else
      left := pivotIndex + 1
     */

    public static int quickSelect(int[] arr, int lo, int hi, int k) {

        int pivot = arr[hi]; // choosing last element as pivot, it could be small or large as it is not sorted array
        int pi = partition(arr, pivot, lo, hi); // partition the array with pivot
        if (pi > k) // check if pivot is greater than k
        {
            return quickSelect(arr, lo, pi - 1, k); // check left of pivot
        }
        else if (pi < k)
        {
            return quickSelect(arr, pi + 1, hi, k); // check right of pivot
        }
        return pivot;
    }

    public static int partition(int[] arr, int pivot, int lo, int hi) {
        System.out.println("pivot -> " + pivot);
        int i = lo, j = lo;
        while (i <= hi) {
            if (arr[i] >= pivot) {
                swap(arr, i, j);
                i++;
                j++;
            } else {
                i++;
            }
        }
        System.out.println("pivot index -> " + (j - 1));
        return (j - 1);
    }

    // used for swapping ith and jth elements of array
    public static void swap(int[] arr, int i, int j) {
        System.out.println("Swapping " + arr[i] + " and " + arr[j]);
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        int arr[] = {2,5,6,3,9,8};
        int k = 3;
        System.out.println(quickSelect(arr, 0, arr.length - 1, k - 1)); //we passed k-1 as the kth smallest element will be index k-1 in the array
    }

}
