package sorting;

import java.util.*;

public class IntersectionOfThreeSortedArrays {
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
// approach 1: make first list as a base and pick the item from list and check in other list if exist then as in the result list
    public static List<Integer> find_intersection(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
       List<Integer> results = new ArrayList<>();
        Set<Integer> temp = new HashSet<>();
        // base case
        if(arr1.size()>0 &&arr2.size()>0&&arr3.size()>0){
            for(int i=0; i< arr1.size();i++){
                if(arr2.contains(arr1.get(i)) && arr3.contains(arr1.get(i))){
                    temp.add(arr1.get(i));
                }
            }
        }else{
            results.add(-1);
        }
     // add set to arraylist
        for(Integer num: temp){
            results.add(num);
        }
      return results;
    }

    public static void main(String[] args) {
//        Integer[] arr1 = {30, 30, 30};
//        Integer[] arr2 = {10, 30, 30};
//        Integer[] arr3 = {10, 20, 30}; // expected output should be 30

        Integer[] arr1 = {1,2,2,2,9};
        Integer[] arr2 = {1,1,2,2};
        Integer[] arr3 = {10, 20, 30}; // expected output should be 30
        System.out.println(find_intersection(Arrays.asList(arr1), Arrays.asList(arr2), Arrays.asList(arr3)));

    }
}
