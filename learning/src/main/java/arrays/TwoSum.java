package arrays;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        if(nums.length==0) return null;

        Map<Integer, Integer> map = new HashMap<>(); //create a map to store values of array where the value is the key and index is the value
        for (int i = 0; i < nums.length; i++) {

            if (map.containsKey(target - nums[i])) { // checkif the 9-num[i] values exist
                System.out.println("map.get(target - nums[i]), i : "+ map.get(target - nums[i])+"nums[i] :"+nums[i]+ "::i "+ i);
                return new int[]{map.get(target - nums[i]), i}; // return
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No number combination found to match with target");
    }

    public static void main(String[] args) {
        int num [] = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(num,9)));
    }
}
