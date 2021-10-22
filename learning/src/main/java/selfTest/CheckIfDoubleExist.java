package selfTest;

import java.util.HashSet;
import java.util.Set;

public class CheckIfDoubleExist {

    /*
    Input: arr = [10,2,5,3]
Output: true
Explanation: N = 10 is the double of M = 5,that is, 10 = 2 * 5.
     */

    public static boolean checkDouble(int [] arr){
        // check if the length is 0
        if(arr.length==0) return false;
        // check if the arr contains more only two elements
        if(arr.length<=2) return false;

        // create a set to store the array element
        Set<Integer> set = new HashSet<>();
        // iterate the array
        for(int num: arr){
            if(num%2==0&&set.contains(num/2)){
                return true;
            }
            if(set.contains(num*2)){
                return true;
            }
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int num [] ={10,3,5,3};
        System.out.println(checkDouble(num));
    }
}
