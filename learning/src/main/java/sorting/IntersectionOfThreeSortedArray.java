package sorting;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfThreeSortedArray {
    /*
    Intersection Of Three Sorted Arrays
Given three arrays sorted in the ascending order, return their intersection sorted array in the ascending order. If the intersection is empty, return an array with one element -1.
Example One
Input:
arr1 = [2, 5, 10]
arr2 = [2, 3, 4, 10]
arr3 = [2, 4, 10]
Output: [2, 10]
Example Two
Input:
arr1 = [1, 2, 3]
arr2 = []
arr3 = [2, 2]
Output: [-1]
     */

    /*
    apporach: get three pointers to ietrate every single array till length and keep checking existence in all and if first array item is greater then increment the first array pointer , if second array item is greater than third array then increment second array else increase third poiter
     */
    public static List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
        List<Integer> result = new ArrayList<>();
        // get three pointers
        int i=0; int j=0; int k=0;
        while(i<arr1.length && j<arr2.length && k< arr3.length){
            if(arr1[i]==arr2[j] && arr2[j]==arr3[k]){
                result.add(arr1[i]);
                i++;
                j++;
                k++;
            }else if(arr1[i]<arr2[j]){
                i++;
            }else if(arr2[j]<arr3[k]){
                j++;
            }else{
                k++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2= {1,2,5,7,9};
        int[] arr3 = {1,3,4,5,8};
        System.out.println("Array intersection :"+ arraysIntersection(arr1,arr2,arr3));
    }

}
