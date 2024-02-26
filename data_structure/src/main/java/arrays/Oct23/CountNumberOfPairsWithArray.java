package arrays.Oct23;

import java.util.HashMap;
import java.util.Map;

public class CountNumberOfPairsWithArray {

    public static int countKDifference(int[] nums, int k) {

        int cnt=0;
        Map<Integer, Integer> map = new HashMap<>();

        for(int n:nums){
            System.out.println("(map.containsKey(n-k) : " + (n-k) +  " n : " + n);
            System.out.println("(map.containsKey(n+k)"+(n+k));
            // now check if the n-k exist in map then add in the counter
            if(map.containsKey(n-k)){

                cnt += map.get(n-k);
            }

            // now check if the n+k exist in the map then add in the counter
            if(map.containsKey(n+k)){
                cnt += map.get(n+k);
            }
            map.put(n, map.getOrDefault(n, 0)+1);

        }
        return cnt;
    }

    public static void main(String[] args) {
        int [] num = {1,2,2,1};
        System.out.printf(" totak numbers "+ countKDifference(num, 1));
    }
}
