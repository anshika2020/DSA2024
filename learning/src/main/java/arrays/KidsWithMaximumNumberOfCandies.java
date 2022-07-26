package arrays;


import java.util.ArrayList;
import java.util.List;

public class KidsWithMaximumNumberOfCandies {
    //1431. Kids With the Greatest Number of Candies (LC)
    /*
    There are n kids with candies. You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.
Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.

Note that multiple kids can have the greatest number of candies.extracaniestest among the kids.
- Kid 3, they will have 5 + 3 = 8 candies, which is the greatest among the kids.
- Kid 4, they will have 1 + 3 = 4 candies, which is not the greatest among

Example 1:

Input: candies = [2,3,5,1,3], extraCandies = 3
Output: [true,true,true,false,true]
Explanation: If you give all extraCandies to:
- Kid 1, they will have 2 + 3 = 5 candies, which is the greatest among the kids.
- Kid 2, they will have 3 + 3 = 6 candies, which is the grea the kids.
- Kid 5, they will have 3 + 3 = 6 candies, which is the greatest among the kids.
     */

    public static List<Boolean> extraCandies(int[] num,int extraCandies){
        List<Boolean> result =new ArrayList<>();
        if(num.length<1||extraCandies==0){
            return result;
        }
        int max = Integer.MIN_VALUE;
        // get the kid with max candy
        for(int n:num){
            if(n>max){
                max=n;
            }
        }
        // iterate through the array and check if the max is greater than the candy + extra candy
        for(int candy:num){
            if(candy+extraCandies>=max){
                result.add(true);
            }else{
                result.add(false);
            }
        }
      return result;
    }

    public static void main(String[] args) {
        int num[] = {2,3,5,1,3};
        System.out.println(extraCandies(num,3));
    }
}
