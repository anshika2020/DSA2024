package sortingPgm.medium;

import java.util.Arrays;

public class LC189_RotateArrayWithKSteps {


    // Approach 1 :brute force apporach : TC: O(k*n) and SC: O(1)
    public  static void rotate1(int[] nums, int k){

        k %= nums.length; // avoid the array bound of exception
        //int previous = 0; // to store the last ndex value till k
        // now iterate through 0 to k and get last index value
        for(int i=0; i<k; i++){
            int previous = nums[nums.length-1];
            System.out.println("previous :" + previous);
            for(int j=0; j<nums.length; j++){
                int temp = nums[j];
                nums[j] = previous;
                previous = temp;
            }
        }
        System.out.println(Arrays.toString(nums));

    }
    // Apporach 2 : use addition array to store elements from kth position . This is an effcient solution which gives TC :O(n) and SC : O(n)
    public static void rotate2(int[] nums, int k) {
        // we have to rotate k times wherer rotation is happening from end index
        // keep moving to right till k time and put last k elemnt at beginning
        // first copy the elements from kth position and put it in new array\
        int[] arr = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            System.out.println("mod: "+( (i + k) % nums.length));
            arr[(i + k) % nums.length] = nums[i];
        }
        System.out.println("before :" + Arrays.toString(arr));
        for(int i=0; i<nums.length;i++){
            nums[i]=arr[i];
        }
        System.out.println(Arrays.toString(arr));
    }

    //Apporach 3: Just reverese array three time, 1) first entire array 0-->n-1 , 2) 0-->k-1 and 3) k -->n-1.  TC :O(n) and SC : O(1)

    public static void rotate3(int[] nums, int k) {

        k %=nums.length;

        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);

    }
// swap the element timm start is less than end
    public static void reverse(int[] nums, int start, int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }

    }


    public static void main(String[] args) {
        int[] num = {1, 2, 3, 4, 5, 6, 7};
        int num1 [] = new int[]{-1,-100,3,99};
        rotate2(num, 3);
    }

}
