package arrays;

import java.lang.reflect.Array;
import java.util.Arrays;

public class CountNumberSmallErThanCurrNum_1365 {

    //1365. How Many Numbers Are Smaller Than the Current Number
     /*
    1. num[i] compare with rest values num[j] till length of array and find the small number, also num[j]<num[i]
    Input: nums = [8,1,2,2,3]
    Output: [4,0,1,1,3]
    2. return the index of the valid j's
    3. Can there be duplicate orjust unique values

    */
    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int arr[] = new int[nums.length];
        int cnt=0;
        for(int i=0; i<nums.length;i++){
            for(int j=0; j<nums.length;j++){
                if(j!=i &&nums[j]<nums[i]){
                    cnt++;
                    arr[i]=cnt;

                }
            }
            cnt=0;
        }
        return arr;
    }
     // find linear approach

    public static void main(String[] args) {
        int num[] = {8,1,2,2,3};//[6,5,4,8], [6,3,7,6,9]
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(num)));
    }
}
