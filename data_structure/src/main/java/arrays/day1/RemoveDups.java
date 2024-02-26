package arrays.day1;

import java.util.Arrays;

public class RemoveDups {

    public static int removeDupes(int nums[]){
        if(nums.length==0) return 0;
        int counter = 0; int dups=0;
        nums[counter] =nums[0];
        counter++;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]!=nums[i+1]){
                nums[counter] = nums[i+1];
                counter++;
            }else{
                System.out.println(nums[i]);
                dups++;
            }
        }
        System.out.println("dupes: " + dups);
        return nums.length-dups;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,2,3,4};
        System.out.println(removeDupes(nums));
    }
}
