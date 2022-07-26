package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CreateTargetArrayIntheGivenOrder_1389 {
    public static int[] createTargetArray(int[] nums, int[] index) {
        // add the values in the list with index and nums value
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<nums.length;i++){
            list.add(index[i],nums[i]);
        }

        //now add the values of the list in the result array
        int arr[] = new int[nums.length];
        for(int i=0; i<list.size();i++){
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(createTargetArray(new int[] {0,1,2,3,4}, new int[]{0,1,2,2,1})));
    }
}
