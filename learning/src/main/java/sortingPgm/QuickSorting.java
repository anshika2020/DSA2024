package sortingPgm;

import java.util.Arrays;

public class QuickSorting {

    /*
    this is also divide and conquer algorithm
    In quick sort we pick a random element and partition the array, such that all numbers that are less than
    the partitioning element come before all elements that are greater than it.The partitioning can be performed through a series of swaps
     */

    /*
    Algo:
    1. first pick an element called pivot from the array (Pivot selection)
    2. partitioning by dividing the array into smaller arrays, rearrange elements so move small elements from pivot to left and greater to right
    3. Each call to partitioning function is to put the pivot into right place in the array.
    3. Recursively repeat the step in small sub array until all of them are sorted. (recursion)
    Note: quicksort is in-place algorithm
     */

    static int[] quicksortLomutoWithEndPivot(int arr[], int left , int right){


        if (left > right) {
            return arr;
        }
        if(left<right) {
            int index = lomutoPartitioning(arr,left,right);
            //sort left half
            quicksortLomutoWithEndPivot(arr, left, index - 1);
            //sort right half
            quicksortLomutoWithEndPivot(arr, index + 1, right);

        }
        return arr;
    }
    static int[] quicksortLomutoWithMedianPivot(int arr[], int left , int right){
        if (left > right) {
            return arr;
        }
        if(left<right) {
            int index = partition(arr,left,right);
            System.out.println("index :" + index);
            System.out.println("Arrays: subarray :" + Arrays.toString(arr));
            //sort left half
            quicksortLomutoWithMedianPivot(arr, left, index - 1);
            //sort right half
            quicksortLomutoWithMedianPivot(arr, index, right);

        }
        return arr;
    }

    // choosing pivot at median
    private static int partition(int[] arr, int left, int right) {
        int pivot  = arr[(left+right)/2];//pick pivot point
        System.out.println("pivot in partinion: :"+pivot);
        while(left<=right){
            System.out.println(" left "+ left +" right "+ right );
            //find element on left that should be on right
            System.out.println(" arr[left] "+arr[left] +"::  arr[right] "+arr[right]);
            System.out.println(" arr[left]<pivot "+ (arr[left]<pivot) );
            System.out.println(" arr[right]>pivot "+ (arr[right]>pivot) );
            if (arr[left]<pivot){  // check if the left element is less than pivot
                left++;
            }
            //find element on right that should be on left
            else if (arr[right]>pivot){  // check if right is greater than pivot
                right--;
            }else{
            //swap elements and move left and right indices
                System.out.println("both condition are false ");
                swap(arr,left,right);
                left++;
                right--;
            }
        }
        return left;
    }

    /* Lomuto partitioning :
    1. This partition selects a pivot element, which is typically the last element of the array.
    2. While partitioning a range [start,end ] , the algorithm maintains it index i as it scans the array
    3. and neccessary swaps are made to ensure after every iteration.

     */

    static int lomutoPartitioning(int arr[], int low , int high){
        int pivot = arr[high];
        int i = low-1;// index of the smallest element
        for(int j = low; j<=high-1;j++){
            if(arr[j]<=pivot){
                i++;// increment the index of smallest element
                swap(arr, i, j);

            }

        }
        swap(arr, i+1, high);
        return i+1;

    }
    private static void swap(int arr[], int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int arr[] = {4,5,7,2,3,1};
        int arr1[] = {10,9,8,7,6,5};
      //  System.out.println(Arrays.toString(quicksortLomutoWithEndPivot(arr,0,arr.length-1)));
        System.out.println("unsorted array : "+ Arrays.toString(arr1));
        System.out.println(Arrays.toString(quicksortLomutoWithMedianPivot(arr,0,arr.length-1)));
    }
}
