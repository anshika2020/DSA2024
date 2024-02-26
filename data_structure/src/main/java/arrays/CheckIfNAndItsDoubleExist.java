package arrays;

import java.util.HashSet;
import java.util.Set;

public class CheckIfNAndItsDoubleExist {

    /*
    LC_1346. Check If N and Its Double Exist
    Given an array arr of integers, check if there exists two integers N and M such that N is the double of M ( i.e. N = 2 * M).
More formally check if there exists two indices i and j such that :

i != j
0 <= i, j < arr.length
arr[i] == 2 * arr[j]
Example 1:
Input: arr = [10,2,5,3]
Output: true
Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
*/

    /*
    1/ check if the numbers is even or not.
    2. pick ith element and then check if the ith is equal to 2*jth
     */

    public static boolean checkDouble(int arr[]){ // TC: O(n^2) SC: O(1)
        if(arr.length==0){
            return false;
        }
        if(arr[0]==0 &&arr[1]==0){  // case when arr has only [0,0]
            return true;
        }

        for(int i=0; i<arr.length;i++) {
            if (arr[i] > 0) { // if only one 0 element
                for (int j = 0; j < arr.length; j++) {
                    if (arr[i] == 2 * arr[j]||arr[j]==2*arr[i]) {
                        System.out.println(arr[i]);
                        System.out.println(arr[j]);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean checkDouble1(int arr[]){ // TC: O(n) SC: O(n)
        Set<Integer> set = new HashSet<>();
        for(int num:arr){
            // don't add if the num is odd
            if(num%2==0&&set.contains(num/2)){
                return true;
            }
            // check if set already has 2*num
            if(set.contains(num*2)){
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] ={10,3,5,3};//{2,3,3,0,0};// {-2,0,10,-19,4,6,-8}; //{7,1,14,11}; //{0,0}
        System.out.println(checkDouble1(arr));
        System.out.println(checkDouble(arr));
    }
}
