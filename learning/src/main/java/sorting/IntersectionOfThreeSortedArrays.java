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
// approach 1: make first list as a base and pick the item from list and check in other list if exist then as in the result list, few test case are failing bcecause this code can not handle the if duplicate value are present in all arrays
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

    // approach 2:
    public static List<Integer> find_intersection1(List<Integer> arr1, List<Integer> arr2, List<Integer> arr3) {
        int i=0; int j=0; int k=0;
        List<Integer> result = new ArrayList<>();
        while(i<arr1.size() &&j<arr2.size()&&k< arr3.size()){ // iterate till lists are lists len is less than i, j and k counters
            // if values are same in all three list then add to result list and increase the counter by 1 for all
            if(arr1.get(i)==arr2.get(j)&& arr2.get(j)==arr3.get(k)){
               result.add(arr1.get(i));
               i+=1;
               j+=1;
               k+=1;
            }else if(arr1.get(i)<arr2.get(j)&&arr1.get(i)<arr3.get(k)){ // if ith value is less than j and kth values of arr2 and arr3 list then increase i counter by one
                i+=1;
            }else if(arr2.get(j)<arr1.get(i)&&arr2.get(j)<arr3.get(k)){ // if jth value is less than i and kth values of arr1 and arr3 list then increase j counter by one
                j+=1;
            }else{// if kth value is less than j and ith values of arr1 and arr2 list then increase k counter by one
                k+=1;
            }
        }
        return result;
    }
    public static void main(String[] args) {
//        Integer[] arr1 = {30, 30, 30};
//        Integer[] arr2 = {10, 30, 30};
//        Integer[] arr3 = {10, 20, 30}; // expected output should be 30

        Integer[] arr1 = {1,2,2,2,9};
        Integer[] arr2 = {1,1,2,2};
        Integer[] arr3 = {1, 2, 30}; // expected output should be 30
      //  System.out.println(find_intersection(Arrays.asList(arr1), Arrays.asList(arr2), Arrays.asList(arr3)));
        System.out.println(find_intersection1(Arrays.asList(arr1), Arrays.asList(arr2), Arrays.asList(arr3)));
    }
}
