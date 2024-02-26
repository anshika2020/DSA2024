package sorting;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoSortedArrays {
    /*
    Given two integer arrays nums1 and nums2, return an array of their intersection.
    Each element in the result must be unique and you may return the result in any order
Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
     */

        // two pointer approach
     public static int[] intersection1(int[] nums1, int[] nums2) {

         Set<Integer> set = new HashSet<>(); // create set to store the unique result
         for(int i=0;i<nums1.length;i++){// O(n)
             for(int j=0; j<nums2.length;j++){ //O(n)
                 if(nums1[i]==nums2[j]){
                     set.add(nums1[i]);
                 }
             }
         }
          int[] arr = new int[set.size()]; //
         int index=0;
         for(int n:set){ // O(n)
             arr[index++] = n;
         }
         System.out.print(Arrays.toString(arr));
         return arr;
     }


        // this hashing would be O(n)  and SC : O(n)
     public static int[] intersection2(int[] nums1, int[] nums2) {

          Set<Integer> set =new HashSet<>();
          Set<Integer> set2 =new HashSet<>();

         for(int n: nums1){
             set.add(n);
         }

         for(int n1: nums2){
             set2.add(n1);
         }

         set.retainAll(set2);
          int result[]= new int[set.size()];
         int indx=0;
         for(int n1: set){
               result[indx++] = n1;
            }
         System.out.print(Arrays.toString(result));
        return result;
     }

        // another two pointer approach
        public static int[] intersection3(int[] nums1, int[] nums2) {
           Arrays.sort(nums1);
           Arrays.sort(nums2);
            Set<Integer> set = new HashSet<>();
            int i=0; int j=0;
            while(i<=nums1.length-1&&j<=nums2.length-1){
                if(nums1[i]==nums2[j]){
                    set.add(nums1[i]);
                    i++;
                    j++;
                }else if(nums1[i]<nums2[j]){
                    i++;
                }else{
                    j++;
                }

            }
            int indx=0;
            int res[] = new int[set.size()];
            for(int n:set){
                res[indx++] =n;
            }
            System.out.print(Arrays.toString(res));
            return res;
        }

    public static void main(String[] args) {
      int num1[]={4,9,5};

        int num2[]={9,4,9,8,4};
        //intersection1(num1,num2);
        //intersection2(num1,num2);
        intersection3(num1,num2);

    }
}
