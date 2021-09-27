package practiceList;
import java.util.HashMap;
import java.util.Map;

public class StairCase {
    static int numOfWays = 0;

    public static int climbStairs(int n) {
        Map<Integer, Integer> map = new HashMap<>();

        noFoWaysClimb(n, map);

        return numOfWays;
    }
    public static void noFoWaysClimb(int n, Map<Integer, Integer> map){
        if(map.containsKey(n)){
            numOfWays+= map.get(n);
            return;
        }else{
            // base case
            if(n==0){
                // check if this step exist in the map
                numOfWays+=1;
                return;//1
            }
            if(n<0) // -1
            {
                return;
            }
            noFoWaysClimb(n-1, map);
            noFoWaysClimb(n-2, map);
        }
        map.put(n,numOfWays);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
