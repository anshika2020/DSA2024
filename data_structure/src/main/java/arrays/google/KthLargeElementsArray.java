package arrays.google;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargeElementsArray {
/*
k largest elements
Medium Accuracy: 53.0% Submissions: 34893 Points: 4

Given an array Arr of N positive integers, find K largest elements from the array.  The output elements should be printed in decreasing order.
Example 1:
Input:
N = 5, K = 2
Arr[] = {12, 5, 787, 1, 23}
Output: 787 23
Explanation: 1st largest element in the
array is 787 and second largest is 23.

What I know already:
N array would be with positive numbers
Top 2 largest number need to print
Order of printing should be decreasing
Questions:
What could be the minimum and maximum length of the array?
Can an array be sorted in increasing or decreasing order at any given point?
Can an array have many duplicate values?

Approach:
Sort it by using divide and conquer approach like quick sort or merge sort then pick the last two elements from the end of the array.The time complexity would be O(NlogN)
Use priority queue which is one of the efficient ways in this scenario to solve the problem.

Requirements:
One aux array to store the result
Priority queue class object to add and poll
Params : int n, int[] arr, int k is for number of top elements

*/

/*
  
    Third Maximum Number
            Easy
    Kth Largest Element in a Stream
    Easy
    K Closest Points to Origin
            Medium
    Find the Kth Largest Integer in the Array
    Medium
    Find Subsequence of Length K With the Largest Sum
            Easy
    K Highest Ranked Items Within a Price Range
    Medium

    */


// TC: O(N log K) and SC: O(k) because we are taking extra space to store the top elements

    public  int[] findKthLargestElement(int n, int[] arr, int k){
        int[] ans = new int[k];
        // create a priority queue object
        PriorityQueue<Integer> q= new PriorityQueue<>(Collections.reverseOrder());// sorting take O(N) it is using
        for(int i=0;i<arr.length;i++){ // O(N)
            q.add(arr[i]); // adding will be constant
        }

        for(Integer s : q) {
            System.out.println("in queue:");
            System.out.println(s);
        }
        for(int i=0; i<k;i++){ // O(N)
            ans[i]= q.poll(); // polling is also O(1)

        }

        return ans;
    }


        public static void main(String [] args){
        int[] num = {12, 5, 787, 1, 23};
        KthLargeElementsArray kth =new KthLargeElementsArray();
        System.out.println(Arrays.toString(kth.findKthLargestElement(5,num, 2)));
    }

}

