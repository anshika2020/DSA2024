package sorting;

import java.util.*;

public class SumOfTwoInASortedArray {

    /*
    Given an array sorted in non-decreasing order and a target number, find the indices of the two values from the array that sum up to the given target number.

Example:

Input: [1, 2, 3, 5, 10], 7

Output: [1, 3]

Sum of the elements at index 1 and 3 is 7.

Notes:

The function returns an array of size two where the two elements specify the input array indices whose values sum up to the given target number.
In case when no answer exists, return an array of size two with both values equal to -1, i.e., [-1, -1].
In case when multiple answers exist, you may return any of them.
The order of the indices returned does not matter.
A single index cannot be used twice.
Constraints:

2 <= Array Size <= 105.
-105 <= Array Elements <= 105.
-105 <= Target Number <= 105.
Array can contain duplicate elements.

     */

    // brute force approach
    /*
    1. Get the number from array
    2. Get the diff by substracting from sum to number
    3. get next number from array
    4. check if the current number is equal to diff if true true then return index of previous number and current number
     */
    /*
    1. Get the number from array
    2. Create a hashmap object to store sum-current number as Key and current index as value
    3. check if value exist in hashmap then return index else store the diff(sum-current number) in hashmap
     */

    public static int[] getSum(int [] arr, int sum){
        final Map<Integer,Integer> map = new HashMap<>();
        if(arr.length<2){
            return arr;
        }

        for(int i=0; i<arr.length;i++){
            int diff = sum-arr[i];
            if(!map.containsKey(diff)){
                map.put(arr[i],i);
            }else{

                return new int[]{map.get(diff), i};
            }

        }
        throw  new  IllegalArgumentException("Number not found");
    }
// if the list is not sorted then
    public static List<Integer> pair_sum_sorted_array(List<Integer> numbers, int target) {
        List list = new ArrayList();
        boolean found = false;
        final Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<numbers.size();i++){
            int diff = target-numbers.get(i);
            if(!map.containsKey(diff)){
                map.put(numbers.get(i),i);
            }else{
                list.add(map.get(diff));
                list.add(i);
                found =true;
                break;
            }
        }

        if(!found){
            list.add(-1);
            list.add(-1);
        }
        return list;
    }
/*
two pointer apporach: decrease and conquer
1. move one pointer from left and one from right
2.store the sum of the numbers[cursor1] +numbers[cursor2_high] in a variable currentSum
3. if    numbers[cursor1_lo] +numbers[cursor2_high] == target : return indices
4. if  numbers[cursor1_lo] +numbers[cursor2_high] > target : move cursor by one point from  right : cursor2_high-- to reduce the total to get close to the taget
5. if  numbers[cursor1_lo] +numbers[cursor2_high] < target : move cursor by one point from  left : cursor1_lo++
 */
// Complete the function below.
public static List<Integer> pair_sum_sorted_array1(List<Integer> numbers, int target) {
    int low =0 ; int high = numbers.size()-1;
    List list = new ArrayList<>();
    int currentSum =0;
    boolean flag= false;
    while(low<high){
        currentSum = numbers.get(low)+numbers.get(high);

        if(currentSum==target){
            list.add(low);
            list.add(high);
            flag=true;
            return list;
        }else if(currentSum>target){
            high--;
        }else{
            low++;
        }
    }
    if(!flag)
    {
        list.add(-1);
        list.add(-1);
    }
    return list;
}

    public static void main(String[] args) {
        int num[] = {1,2,3,5,10};
        Integer nums[] = new Integer[] {1,2,3,5,10};
     //   System.out.println(Arrays.toString(getSum(num,7)));
        System.out.println(pair_sum_sorted_array1(Arrays.asList(nums),7));
       // System.out.println(pair_sum_sorted_array(Arrays.asList(nums),7));
    }

    //Test case
    /*
    1. [5,1,2,3,5,10] , 7
    2. [1], 3
    3.[2,1,2], 4 : failed
    4.[6,-10,-7,-5,0,8,10] 3

    5. [5,-10,-5,1,4,6] 8
    6. [5,1,3,5,7,9] 100
    7.[ 5,-9,-7,-5,-3,-1]-100 Expected -1

     */
}
